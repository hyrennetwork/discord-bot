package net.hyren.discord.bot

import com.redefantasy.core.shared.CoreProvider
import com.redefantasy.core.shared.scheduler.AsyncScheduler
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.OnlineStatus
import net.dv8tion.jda.api.requests.GatewayIntent
import net.dv8tion.jda.api.utils.cache.CacheFlag
import net.hyren.discord.bot.echo.packet.listener.ProjectStartedBuildEchoPacketListener
import net.hyren.discord.bot.echo.packet.listener.UserGroupsUpdatedEchoPacketListener
import net.hyren.discord.bot.echo.packet.listener.UserPunishedEchoPacketListener
import net.hyren.discord.bot.listener.adapter.GenericListeners
import net.hyren.discord.bot.misc.punish.task.ValidateMembersPunishmentRunnable
import java.util.concurrent.TimeUnit

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
		).disableCache(
			CacheFlag.VOICE_STATE,
			CacheFlag.EMOTE
		).addEventListeners(
			GenericListeners()
		).setStatus(
			OnlineStatus.OFFLINE
		).build()

		/**
		 * ECHO
		 */
		CoreProvider.Databases.Redis.ECHO.provide().registerListener(UserGroupsUpdatedEchoPacketListener())
		CoreProvider.Databases.Redis.ECHO.provide().registerListener(UserPunishedEchoPacketListener())
		CoreProvider.Databases.Redis.ECHO.provide().registerListener(ProjectStartedBuildEchoPacketListener())

		/**
		 * Tasks
		 */

		AsyncScheduler.scheduleAsyncRepeatingTask(
			ValidateMembersPunishmentRunnable(),
			0,
			5,
			TimeUnit.SECONDS
		)
	}

}