package net.hyren.discord.bot

import com.redefantasy.core.shared.CoreProvider

/**
 * @author Gutyerrez
 */
object DiscordBotProvider {

    fun prepare() {
        CoreProvider.prepare(
            10080
        )
    }

}