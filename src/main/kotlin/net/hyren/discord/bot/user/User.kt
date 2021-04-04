package net.hyren.discord.bot.user

import com.redefantasy.core.shared.users.data.User
import net.dv8tion.jda.api.entities.Guild
import net.dv8tion.jda.api.entities.Member
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