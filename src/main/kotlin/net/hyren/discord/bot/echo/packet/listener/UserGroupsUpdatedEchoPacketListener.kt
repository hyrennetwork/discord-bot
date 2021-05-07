package net.hyren.discord.bot.echo.packet.listener

import net.hyren.core.shared.CoreProvider
import net.hyren.core.shared.echo.api.listener.EchoListener
import net.hyren.core.shared.echo.packets.UserGroupsUpdatedPacket
import net.hyren.discord.bot.misc.jda.member.syncData
import net.hyren.discord.bot.user.getMember
import org.greenrobot.eventbus.Subscribe

/**
 * @author Gutyerrez
 */
class UserGroupsUpdatedEchoPacketListener : EchoListener {

	@Subscribe
	fun on(
		packet: UserGroupsUpdatedPacket
	) {
		val userId = packet.userId ?: return

		val user = CoreProvider.Cache.Local.USERS.provide().fetchById(userId) ?: return

		val member = user.getMember() ?: return

		member.syncData()
	}

}