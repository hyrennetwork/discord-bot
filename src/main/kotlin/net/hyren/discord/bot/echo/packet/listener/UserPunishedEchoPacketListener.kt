package net.hyren.discord.bot.echo.packet.listener

import com.redefantasy.core.shared.CoreProvider
import com.redefantasy.core.shared.echo.api.listener.EchoListener
import com.redefantasy.core.shared.echo.packets.UserPunishedPacket
import net.hyren.discord.bot.misc.jda.member.validatePunishments
import net.hyren.discord.bot.user.getMember
import org.greenrobot.eventbus.Subscribe

/**
 * @author Gutyerrez
 */
class UserPunishedEchoPacketListener : EchoListener {

	@Subscribe
	fun on(
		packet: UserPunishedPacket
	) {
		val user = CoreProvider.Cache.Local.USERS.provide().fetchById(
			packet.userId!!
		) ?: return

		val member = user.getMember() ?: return

		member.validatePunishments()
	}

}