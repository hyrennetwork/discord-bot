package net.hyren.discord.bot.groups

import net.dv8tion.jda.api.entities.Guild
import net.dv8tion.jda.api.entities.Role
import net.hyren.core.shared.groups.Group
import net.hyren.discord.bot.DiscordBotConstants

/**
 * @author Gutyerrez
 */
fun Group.asRole(
	guild: Guild? = DiscordBotConstants.GUILDS[DiscordBotConstants.GuildType.MAIN]
): Role? {
	return if (guild?.idLong == DiscordBotConstants.MAIN_GUILD_ID) {
		when {
			this == Group.MASTER -> DiscordBotConstants.Roles.MainGuild.MASTER
			this == Group.MANAGER -> DiscordBotConstants.Roles.MainGuild.MANAGER
			this == Group.ADMINISTRATOR -> DiscordBotConstants.Roles.MainGuild.ADMINISTRATOR
			this == Group.MODERATOR -> DiscordBotConstants.Roles.MainGuild.MODERATOR
			this == Group.HELPER -> DiscordBotConstants.Roles.MainGuild.HELPER
			this == Group.YOUTUBER -> DiscordBotConstants.Roles.MainGuild.YOUTUBER
			this == Group.MVP_PLUS -> DiscordBotConstants.Roles.MainGuild.MVP_PLUS
			this == Group.MVP -> DiscordBotConstants.Roles.MainGuild.MVP
			this == Group.VIP_PLUS -> DiscordBotConstants.Roles.MainGuild.VIP_PLUS
			this == Group.VIP -> DiscordBotConstants.Roles.MainGuild.VIP
			this == Group.DEFAULT -> DiscordBotConstants.Roles.MainGuild.MEMBER
			else -> null
		}
	} else null
}