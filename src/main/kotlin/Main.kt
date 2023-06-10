import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.runBlocking

fun main() {
    val client = initClient()

    runBlocking {
        client.execute()
    }

    client.close()
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
