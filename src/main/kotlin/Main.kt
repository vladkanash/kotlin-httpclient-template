import io.github.oshai.kotlinlogging.KotlinLogging
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.runBlocking

private val log = KotlinLogging.logger { }

fun main() {
    log.info { "Starting application" }

    val client = initClient()

    runBlocking {
        client.execute()
    }

    client.close()

    log.info { "Exiting application" }
}

private fun initClient(): HttpClient =
    HttpClient {
        install(ContentNegotiation) {
            json()
        }
        install(Logging) {
            level = LogLevel.INFO
        }
    }
