package net.hyren.discord.bot.echo.packet.listener

import com.redefantasy.core.shared.echo.api.listener.EchoListener
import com.redefantasy.core.shared.echo.packets.project.ProjectStartedBuildEchoPacket
import net.dv8tion.jda.api.EmbedBuilder
import net.hyren.discord.bot.DiscordBotApplication
import org.greenrobot.eventbus.Subscribe

/**
 * @author Gutyerrez
 */
class ProjectStartedBuildEchoPacketListener : EchoListener {

	@Subscribe
	fun on(
		packet: ProjectStartedBuildEchoPacket
	) {
		println("AA")

		val chat = DiscordBotApplication.jda.getTextChannelById(826289489214701603)

		println(chat === null)

		chat?.sendMessage(
			EmbedBuilder()
				.setTitle("Iniciando build #${packet.buildId}")
				.addField(
					"Projeto",
					"Teste",
					true
				).addField(
					"Status",
					"Aguardando início",
					true
				).addField(
					"Requisitado por",
					"Gutyerrez",
					true
				).addField(
					"Commit",
					"287asd87",
					true
				).build()
		)?.queue {
			println("AAA")
		}
	}

}