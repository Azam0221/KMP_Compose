package org.example.project


import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.engine.darwin.*

class IosApiClient : ApiClient {
    private val client = HttpClient(Darwin) {
        install(io.ktor.client.plugins.contentnegotiation.ContentNegotiation) {
            kotlinx.serialization.json.Json {
                ignoreUnknownKeys = true
            }
        }

    }
    override suspend fun getBreaches(): List<Breach> {
        try {
            val response: String = client.get("https://haveibeenpwned.com/api/v2/breaches").body()
            println("Raw response: $response")
            return kotlinx.serialization.json.Json.decodeFromString(response)
        } catch (e: Exception) {
            println("Error fetching breaches: ${e.message}")
            throw e
        }
    }
}