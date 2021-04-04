package net.hyren.discord.bot

import net.dv8tion.jda.api.entities.Guild
import java.util.function.Supplier

/**
 * @author Gutyerrez
 */
object DiscordBotConstants {

    val MAIN_GUILD_ID = 826289489214701600

    val GUILDS = mapOf(
            Pair(
                    GuildType.MAIN,
                    Supplier<Guild> {
                        DiscordBotApplication.jda.guildCache.getElementById(MAIN_GUILD_ID)
                    }.get()
            )
    )

    object Tokens {

        const val ACCESS_TOKEN = "ODI4MTI0NzAwMzYxNDkwNDkz.YGlBOg.AuRFFGk64gpGcJjBvZtqC_EkhdY"

    }

    object Roles {

        object MAIN_GUILD {

            val MASTER = DiscordBotApplication.jda.roleCache.getElementById(828129837780303914)
            val MANAGER = DiscordBotApplication.jda.roleCache.getElementById(828129861327519765)
            val ADMINISTRATOR = DiscordBotApplication.jda.roleCache.getElementById(828129861327519765)
            val MODERATOR = DiscordBotApplication.jda.roleCache.getElementById(828129864694890526)
            val HELPER = DiscordBotApplication.jda.roleCache.getElementById(828129870831157269)
            val YOUTUBER = DiscordBotApplication.jda.roleCache.getElementById(828129875448692777)
            val MVP_PLUS = DiscordBotApplication.jda.roleCache.getElementById(828129896714338305)
            val MVP = DiscordBotApplication.jda.roleCache.getElementById(828129902594490379)
            val VIP_PLUS = DiscordBotApplication.jda.roleCache.getElementById(828129906146934784)
            val VIP = DiscordBotApplication.jda.roleCache.getElementById(828129913453936651)
            val MEMBER = DiscordBotApplication.jda.roleCache.getElementById(828129920307691531)

        }

    }

    enum class GuildType {

        MAIN,
        STAFF;

    }

}
