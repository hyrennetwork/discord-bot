package net.hyren.discord.bot.groups

import com.redefantasy.core.shared.groups.Group
import net.dv8tion.jda.api.entities.Guild
import net.dv8tion.jda.api.entities.Role
import net.hyren.discord.bot.DiscordBotConstants

/**
 * @author Gutyerrez
 */
fun Group.asRole(
        guild: Guild? = DiscordBotConstants.GUILDS[DiscordBotConstants.GuildType.MAIN]
): Role? {
    if (guild?.idLong == DiscordBotConstants.MAIN_GUILD_ID) {
        when {
            this == Group.MASTER -> DiscordBotConstants.Roles.MAIN_GUILD.MASTER
            this == Group.MANAGER -> DiscordBotConstants.Roles.MAIN_GUILD.MANAGER
            this == Group.ADMINISTRATOR -> DiscordBotConstants.Roles.MAIN_GUILD.ADMINISTRATOR
            this == Group.MODERATOR -> DiscordBotConstants.Roles.MAIN_GUILD.MODERATOR
            this == Group.HELPER -> DiscordBotConstants.Roles.MAIN_GUILD.HELPER
            this == Group.YOUTUBER -> DiscordBotConstants.Roles.MAIN_GUILD.YOUTUBER
            this == Group.MVP_PLUS -> DiscordBotConstants.Roles.MAIN_GUILD.MVP_PLUS
            this == Group.MVP -> DiscordBotConstants.Roles.MAIN_GUILD.MVP
            this == Group.VIP_PLUS -> DiscordBotConstants.Roles.MAIN_GUILD.VIP_PLUS
            this == Group.VIP -> DiscordBotConstants.Roles.MAIN_GUILD.VIP
            this == Group.DEFAULT -> DiscordBotConstants.Roles.MAIN_GUILD.MEMBER
        }
    }

    return null
}