package net.hyren.discord.bot

import net.dv8tion.jda.api.entities.Guild
import net.dv8tion.jda.api.entities.Role
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

        /*"ODI4MTI0NzAwMzYxNDkwNDkz.YGlBOg.AuRFFGk64gpGcJjBvZtqC_EkhdY"*/
        const val ACCESS_TOKEN = "a2vbM_VJ5AUNNEJlo_F6B9e5S_sjv4JziT6tancrth6nrVtlHUoDMHYULeeG8BFjmoDMe0TgweDCx5fZRpjR"

    }

    object Roles {

        fun getRolesByGuild(
            guild: Guild? = GUILDS[GuildType.MAIN]
        ): GuildRoles? = when(guild) {
            GUILDS[GuildType.MAIN] -> MainGuild
            else -> null
        }

        object MainGuild : GuildRoles() {

            override val MASTER = DiscordBotApplication.jda.roleCache.getElementById(828129837780303914)
            override val MANAGER = DiscordBotApplication.jda.roleCache.getElementById(828129861327519765)
            override val ADMINISTRATOR = DiscordBotApplication.jda.roleCache.getElementById(828129861327519765)
            override val MODERATOR = DiscordBotApplication.jda.roleCache.getElementById(828129864694890526)
            override val HELPER = DiscordBotApplication.jda.roleCache.getElementById(828129870831157269)
            override val YOUTUBER = DiscordBotApplication.jda.roleCache.getElementById(828129875448692777)
            override val MVP_PLUS = DiscordBotApplication.jda.roleCache.getElementById(828129896714338305)
            override val MVP = DiscordBotApplication.jda.roleCache.getElementById(828129902594490379)
            override val VIP_PLUS = DiscordBotApplication.jda.roleCache.getElementById(828129906146934784)
            override val VIP = DiscordBotApplication.jda.roleCache.getElementById(828129913453936651)
            override val MEMBER = DiscordBotApplication.jda.roleCache.getElementById(828129920307691531)

            override val VERIFICATION = DiscordBotApplication.jda.roleCache.getElementById(828204580977508382)

        }

        abstract class GuildRoles {

            abstract val MASTER: Role?
            abstract val MANAGER: Role?
            abstract val ADMINISTRATOR: Role?
            abstract val MODERATOR: Role?
            abstract val HELPER: Role?
            abstract val YOUTUBER: Role?
            abstract val MVP_PLUS: Role?
            abstract val MVP: Role?
            abstract val VIP_PLUS: Role?
            abstract val VIP: Role?
            abstract val MEMBER: Role?

            abstract val VERIFICATION: Role?

        }

    }

    enum class GuildType {

        MAIN,
        STAFF;

    }

}
