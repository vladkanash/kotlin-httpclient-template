import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.append
import kotlinx.serialization.Serializable
import java.util.Locale.GERMAN

suspend fun HttpClient.execute() {
    getRequest()
    postRequest()
}

private suspend fun HttpClient.getRequest() {
    val response = get("http://httpstat.us/200")
    println(response.status)
}

private suspend fun HttpClient.postRequest() {
    post("http://httpstat.us/201") {
        headers {
            append(HttpHeaders.ContentType, ContentType.Application.Json)
            append(HttpHeaders.AcceptLanguage, GERMAN.language)
        }
        setBody(Item(id = "1", name = "test"))
    }
}

@Serializable
private data class Item(
    val id: String,
    val name: String,
)
