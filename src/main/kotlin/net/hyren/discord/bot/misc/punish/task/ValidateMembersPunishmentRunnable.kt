package net.hyren.discord.bot.misc.punish.task

import net.hyren.discord.bot.DiscordBotConstants
import net.hyren.discord.bot.misc.jda.member.validatePunishments

/**
 * @author Gutyerrez
 */
class ValidateMembersPunishmentRunnable : Runnable {

	override fun run() {
		DiscordBotConstants.Channels.GENERAL_CHAT?.members?.forEach { it.validatePunishments() }
	}

}