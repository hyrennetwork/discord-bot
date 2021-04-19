package net.hyren.discord.bot.echo.packet.listener.project

import com.redefantasy.core.shared.echo.api.listener.EchoListener
import com.redefantasy.core.shared.echo.packets.project.ProjectFailedBuildEchoPacket
import org.greenrobot.eventbus.Subscribe

/**
 * @author Gutyerrez
 */
class ProjectFailedBuildEchoPacketListener : EchoListener {

	@Subscribe
	fun on(
		packet: ProjectFailedBuildEchoPacket
	) {

	}

}