package net.hyren.discord.bot.misc.jda.member

import com.redefantasy.core.shared.CoreProvider
import com.redefantasy.core.shared.misc.utils.ChatColor
import net.dv8tion.jda.api.entities.Member
import net.hyren.discord.bot.DiscordBotConstants
import net.hyren.discord.bot.groups.asRole

/**
 * @author Gutyerrez
 */
fun Member.canSyncData() = this.syncData() == true

fun Member.canNotSyncData() = this.syncData() == null || this.syncData() == false

fun Member.syncData(): Any? {
	val user = CoreProvider.Cache.Local.USERS.provide().fetchByDiscordId(
		this.idLong
	) ?: return null

	val highestGroup = user.getHighestGroup()

	val role = highestGroup.asRole(
		guild
	) ?: return null

	val currentName = this.nickname

	if (!roles.contains(role))
		guild.addRoleToMember(this, role).queue()

	if (currentName === null || currentName != ChatColor.stripColor(
			user.getFancyName()
		)
	) {
		this.modifyNickname(
			ChatColor.stripColor(
				user.getFancyName()
			)
		).queue()
	}

	return true
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