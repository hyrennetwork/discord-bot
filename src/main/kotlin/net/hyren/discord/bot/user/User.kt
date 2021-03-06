package net.hyren.discord.bot.user

import net.dv8tion.jda.api.entities.Guild
import net.dv8tion.jda.api.entities.Member
import net.hyren.core.shared.users.data.User
import net.hyren.discord.bot.DiscordBotConstants

/**
 * @author Gutyerrez
 */
fun User.getMember(
    guild: Guild? = DiscordBotConstants.GUILDS[DiscordBotConstants.GuildType.MAIN]
): Member? {
    if (this.discordId === null) return null

    return guild?.getMemberById(this.discordId!!)
}

fun net.dv8tion.jda.api.entities.User.getMember(
    guild: Guild? = DiscordBotConstants.GUILDS[DiscordBotConstants.GuildType.MAIN]
): Member? {
    return guild?.memberCache?.getElementById(this.idLong)
}