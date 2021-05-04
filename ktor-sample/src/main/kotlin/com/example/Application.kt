package com.example

import com.example.group.groupComponents
import com.example.group.groupModule
import com.typesafe.config.ConfigFactory
import io.github.config4k.extract
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.flywaydb.core.Flyway
import org.jetbrains.exposed.sql.Database
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.ktor.di
import org.kodein.di.singleton
import studentComponents
import studentModule


fun main() {
    val config = ConfigFactory.load().extract<AppConfig>()

    migrate(config.database)

    val engine = embeddedServer(Netty, port = config.http.port, host = "127.0.0.1") {
        di {
            coreComponents(config)
            studentComponents()
            groupComponents()
        }

        configureSerialization()
        studentModule()
        groupModule()
    }

    engine.start(wait = true)
}

fun DI.Builder.coreComponents(config: AppConfig) {
    bind<AppConfig>() with singleton { config }

    bind<Database>() with singleton {
        Database.connect(
            url = config.database.url,
            user = config.database.user,
            password = config.database.password
        )
    }
}

fun migrate(database: DatabaseConfig) {
    Flyway
        .configure()
        .dataSource(database.url, database.user, database.password)
        .load()
        .migrate()
}
