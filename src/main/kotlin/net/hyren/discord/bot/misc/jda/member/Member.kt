package net.hyren.discord.bot.misc.jda.member

import com.redefantasy.core.shared.CoreProvider
import net.dv8tion.jda.api.entities.Member
import net.hyren.discord.bot.DiscordBotConstants
import net.hyren.discord.bot.groups.asRole

/**
 * @author Gutyerrez
 */
fun Member.syncData() {
    val user = CoreProvider.Cache.Local.USERS.provide().fetchByDiscordId(
            this.idLong
    ) ?: return

    val highestGroup = user.getHighestGroup()

    val role = highestGroup.asRole() ?: return

    DiscordBotConstants.GUILDS.values.forEach {
        it.addRoleToMember(this, role).queue()
    }
}