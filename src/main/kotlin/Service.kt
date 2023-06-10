import io.ktor.client.HttpClient
import io.ktor.client.request.get
suspend fun HttpClient.execute() {
    val response = get("http://httpstat.us/200")
    println(response.status)
}