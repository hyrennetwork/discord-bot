plugins {
    kotlin("jvm") version "1.4.32"

    id("com.github.johnrengelman.shadow") version "6.1.0"
}

group = "net.hyren"
version = "0.1-ALPHA"

repositories {
    mavenCentral()

    jcenter()

    maven("https://m2.dv8tion.net/releases")
    maven("https://maven.pkg.github.com/hyrendev/nexus/") {
        credentials {
            username = System.getenv("MAVEN_USERNAME")
            password = System.getenv("MAVEN_PASSWORD")
        }
    }
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

    shadowJar {
        manifest {
            attributes["Main-Class"] = "net.hyren.discord.bot.DiscordBotApplication"
        }

        archiveFileName.set("${project.name}.jar")
    }
}

dependencies {
    // kotlin
    compileOnly(kotlin("stdlib"))

    // exposed
    compileOnly("org.jetbrains.exposed:exposed-core:0.29.1")
    compileOnly("org.jetbrains.exposed:exposed-dao:0.29.1")
    compileOnly("org.jetbrains.exposed:exposed-jdbc:0.29.1")
    compileOnly("org.jetbrains.exposed:exposed-jodatime:0.29.1")

    // jda
    implementation("net.dv8tion:JDA:4.2.1_253") {
        exclude("opus-java")
    }

    // eventbus
    compileOnly("org.greenrobot:eventbus:3.2.0")

    // caffeine
    compileOnly("com.github.ben-manes.caffeine:caffeine:2.8.5")

    // core
    implementation("net.hyren:core-shared:0.1-ALPHA")
}
