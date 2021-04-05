package net.hyren.discord.bot.listener.adapter

import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent
import net.dv8tion.jda.api.events.guild.member.GuildMemberUpdateEvent
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.dv8tion.jda.api.events.user.UserActivityEndEvent
import net.dv8tion.jda.api.events.user.UserActivityStartEvent
import net.dv8tion.jda.api.events.user.UserTypingEvent
import net.dv8tion.jda.api.events.user.update.UserUpdateOnlineStatusEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.hyren.discord.bot.DiscordBotApplication
import net.hyren.discord.bot.DiscordBotConstants
import net.hyren.discord.bot.misc.jda.member.canNotSyncData
import net.hyren.discord.bot.misc.jda.member.removeRoles
import net.hyren.discord.bot.misc.jda.member.syncData

/**
 * @author Gutyerrez
 */
class GenericListeners : ListenerAdapter() {

    override fun onGuildMemberJoin(
        event: GuildMemberJoinEvent
    ) {
        val guild = event.guild
        val member = event.member

        if (member.canNotSyncData()) {
            val verificationRole = when (guild) {
                DiscordBotConstants.GUILDS[DiscordBotConstants.GuildType.MAIN] -> DiscordBotConstants.Roles.MainGuild.VERIFICATION
                else -> null
            } ?: return

            guild.addRoleToMember(member, verificationRole).queue()
        }
    }

    override fun onUserActivityStart(
        event: UserActivityStartEvent
    ) {
        val member = event.member

        member.syncData()
    }

    override fun onUserUpdateOnlineStatus(
        event: UserUpdateOnlineStatusEvent
    ) {
        val member = event.member

        member.syncData()
    }

    override fun onUserActivityEnd(
        event: UserActivityEndEvent
    ) {
        val member = event.member

        member.syncData()
    }

    override fun onUserTyping(
        event: UserTypingEvent
    ) {
        val member = event.member

        member?.syncData()
    }

    override fun onMessageReceived(
        event: MessageReceivedEvent
    ) {
        val member = event.member

        member?.syncData()
    }

    override fun onGuildMemberUpdate(
        event: GuildMemberUpdateEvent
    ) {
        val guild = event.guild
        val member = event.member

        if (member.canNotSyncData()) {
            member.removeRoles()

            val verificationRole = when (guild) {
                DiscordBotConstants.GUILDS[DiscordBotConstants.GuildType.MAIN] -> DiscordBotConstants.Roles.MainGuild.VERIFICATION
                else -> null
            } ?: return

            guild.addRoleToMember(member, verificationRole).queue()
        }
    }

    override fun onGuildMessageReceived(
        event: GuildMessageReceivedEvent
    ) {
        val member = event.member
        val channel = event.channel

        println("dale")

        println(channel.idLong == 828128934032834580)
        println(member == null)
        println(member?.idLong != DiscordBotApplication.jda.selfUser.idLong)

        if (channel.idLong == 828128934032834580 && member == null || member?.idLong != DiscordBotApplication.jda.selfUser.idLong) {
            println("?")

            val message = event.message

            message.delete().queue()
        }
    }

}