package net.hyren.discord.bot.listener.adapter

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

/**
 * @author Gutyerrez
 */
class GenericListeners : ListenerAdapter() {

    override fun onGuildMessageReceived(
            event: GuildMessageReceivedEvent
    ) {
        val channel = event.channel

        channel.sendMessage("Bump!").queue()
    }

}