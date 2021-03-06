package net.hyren.discord.bot.misc.jda.member

import net.dv8tion.jda.api.Permission
import net.dv8tion.jda.api.entities.Member
import net.hyren.core.shared.CoreProvider
import net.hyren.discord.bot.DiscordBotConstants
import net.hyren.discord.bot.groups.asRole

/**
 * @author Gutyerrez
 */
fun Member.canSyncData() = this.syncData() == true

fun Member.canNotSyncData() = this.syncData() == null || this.syncData() == false

fun Member.syncData(): Any? {
	if (user.isBot) return null

	val user = CoreProvider.Cache.Local.USERS.provide().fetchByDiscordId(
		idLong
	) ?: return null

	val verificationRole = DiscordBotConstants.Roles.getRolesByGuild(guild)?.VERIFICATION

	if (roles.contains(verificationRole))
		verificationRole?.let { guild.removeRoleFromMember(this, verificationRole).queue() }

	val highestGroup = user.getHighestGroup()

	validatePunishments()

	val role = highestGroup.asRole(
		guild
	) ?: return null

	if (!roles.contains(role))
		guild.addRoleToMember(this, role).queue()

	if (nickname === null || nickname != "${user.getHighestGroup().prefix}${user.name}") {
		modifyNickname(
			"${user.getHighestGroup().prefix}${user.name}"
		).queue()
	}

	return true
}

fun Member.validatePunishments() {
	val user = CoreProvider.Cache.Local.USERS.provide().fetchByDiscordId(
		idLong
	) ?: return

	CoreProvider.Cache.Local.USERS_PUNISHMENTS.provide().invalidate(user.getUniqueId())

	if (user.getPunishments().stream().filter { !it.isBan() && !it.isRevoked() && (it.isPending() || it.isActive()) }.findFirst().isPresent) {
		DiscordBotConstants.Channels.GENERAL_CHAT?.manager?.putPermissionOverride(
			this,
			emptySet(),
			setOf(
				Permission.MESSAGE_WRITE
			)
		)?.queue()
	} else if (
		DiscordBotConstants.Channels.GENERAL_CHAT?.getPermissionOverride(
			this
		)?.denied?.contains(Permission.MESSAGE_WRITE) == true
	) {
		DiscordBotConstants.Channels.GENERAL_CHAT?.manager?.removePermissionOverride(this)?.queue()
	}
}

fun Member.removeRoles() {
	roles.stream()
		.filter { !it.isPublicRole }
		.filter { !it.isManaged }
		.filter { it != DiscordBotConstants.Roles.getRolesByGuild(guild)?.VERIFICATION }
		.forEach {
			guild.removeRoleFromMember(this, it).queue()
		}
}