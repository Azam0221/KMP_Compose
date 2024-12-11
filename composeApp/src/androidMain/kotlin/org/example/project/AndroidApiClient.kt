package org.example.project


import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.engine.okhttp.*


class AndroidApiClient : ApiClient {
    private val client = HttpClient(OkHttp) {
        install(io.ktor.client.plugins.contentnegotiation.ContentNegotiation) {
            kotlinx.serialization.json.Json {
                ignoreUnknownKeys = true
            }
        }
    }
  //  val baseUrl = "https://haveibeenpwned.com/api/v2/breaches"

    override suspend fun getBreaches(): List<Breach> {
        try {
            val response: String = client.get("https://haveibeenpwned.com/api/v2/breaches").body()
            println("Raw response: $response") // Log the raw response
            return kotlinx.serialization.json.Json.decodeFromString(response)
        } catch (e: Exception) {
            println("Error fetching breaches: ${e.message}")
            throw e
        }
    }
}

