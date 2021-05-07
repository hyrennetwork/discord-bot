package net.hyren.discord.bot.echo.packet.listener.project

import net.dv8tion.jda.api.EmbedBuilder
import net.hyren.core.shared.echo.api.listener.EchoListener
import net.hyren.core.shared.echo.packets.project.ProjectStartedBuildEchoPacket
import net.hyren.discord.bot.DiscordBotApplication
import net.hyren.discord.bot.DiscordBotConstants
import org.greenrobot.eventbus.Subscribe

/**
 * @author Gutyerrez
 */
class ProjectStartedBuildEchoPacketListener : EchoListener {

	@Subscribe
	fun on(
		packet: ProjectStartedBuildEchoPacket
	) {
		println(DiscordBotConstants.Channels.GENERAL_CHAT === null)

		val chat = DiscordBotApplication.jda.getTextChannelById(826289489214701603)

		chat?.sendMessage(
			EmbedBuilder()
				.setTitle("Iniciando build #${packet.buildId}")
				.setDescription("Projeto teste...")
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
				).addField(
					"Branch",
					"main",
					true
				).build()
		)?.queue()
	}

}