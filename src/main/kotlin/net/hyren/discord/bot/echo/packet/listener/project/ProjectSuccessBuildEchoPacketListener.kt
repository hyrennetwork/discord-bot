package net.hyren.discord.bot.echo.packet.listener.project

import com.redefantasy.core.shared.echo.api.listener.EchoListener
import com.redefantasy.core.shared.echo.packets.project.ProjectSuccessBuildEchoPacket
import org.greenrobot.eventbus.Subscribe

/**
 * @author Gutyerrez
 */
class ProjectSuccessBuildEchoPacketListener : EchoListener {

	@Subscribe
	fun on(
		packet: ProjectSuccessBuildEchoPacket
	) {

	}

}