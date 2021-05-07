package net.hyren.discord.bot

import net.hyren.core.shared.CoreProvider
import net.hyren.core.shared.applications.ApplicationType
import net.hyren.core.shared.applications.data.Application
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

		val echo = CoreProvider.Databases.Redis.ECHO.provide()

		echo.defaultSubscriber = echo.subscribe { _, runnable ->
			runnable.run()
		}
	}

}