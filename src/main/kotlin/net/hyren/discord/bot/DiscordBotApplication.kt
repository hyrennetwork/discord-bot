package net.hyren.discord.bot

import com.redefantasy.core.shared.CoreProvider
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.OnlineStatus
import net.dv8tion.jda.api.requests.GatewayIntent
import net.hyren.discord.bot.echo.packet.listener.UserGroupsUpdatedEchoPacketListener
import net.hyren.discord.bot.listener.adapter.GenericListeners

/**
 * @author Gutyerrez
 */
object DiscordBotApplication {

    lateinit var jda: JDA

    @JvmStatic
    fun main(args: Array<String>) {
        DiscordBotProvider.prepare()

        jda = JDABuilder.createDefault(
                DiscordBotConstants.Tokens.ACCESS_TOKEN,
                GatewayIntent.GUILD_MESSAGES,
                GatewayIntent.GUILD_MEMBERS,
                GatewayIntent.GUILD_PRESENCES,
                GatewayIntent.GUILD_MESSAGES,
                GatewayIntent.GUILD_MESSAGE_TYPING,
        ).addEventListeners(
                GenericListeners()
        ).setStatus(
                OnlineStatus.OFFLINE
        ).build()

        /**
         * ECHO
         */
        CoreProvider.Databases.Redis.ECHO.provide().registerListener(UserGroupsUpdatedEchoPacketListener())
    }

}