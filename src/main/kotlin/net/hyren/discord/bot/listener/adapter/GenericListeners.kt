package net.hyren.discord.bot.listener.adapter

import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.hyren.discord.bot.DiscordBotConstants

/**
 * @author Gutyerrez
 */
class GenericListeners : ListenerAdapter() {

    override fun onGuildMemberJoin(
        event: GuildMemberJoinEvent
    ) {
        val guild = event.guild
        val member = event.member

        val verificationRole = when (guild) {
            DiscordBotConstants.GUILDS[DiscordBotConstants.GuildType.MAIN] -> DiscordBotConstants.Roles.MainGuild.VERIFICATION
            else -> null
        } ?: return

        guild.addRoleToMember(member, verificationRole).queue()
    }

    override fun onGuildMessageReceived(
        event: GuildMessageReceivedEvent
    ) {
        val channel = event.channel

        channel.sendMessage("Bump!").queue()
    }

}