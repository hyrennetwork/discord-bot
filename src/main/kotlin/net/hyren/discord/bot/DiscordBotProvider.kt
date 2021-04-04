package net.hyren.discord.bot

import com.redefantasy.core.shared.CoreProvider
import com.redefantasy.core.shared.applications.ApplicationType
import com.redefantasy.core.shared.applications.data.Application
import java.net.InetSocketAddress

/**
 * @author Gutyerrez
 */
object DiscordBotProvider {

    fun prepare() {
        CoreProvider.prepare(
                Application(
                        "discord-bot",
                        "Discord Bot",
                        null,
                        InetSocketAddress(
                                "127.0.0.1",
                                0
                        ),
                        ApplicationType.GENERIC,
                        null,
                        null
                )
        )
    }

}