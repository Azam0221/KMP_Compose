package org.example.project



interface ApiClient {
    suspend fun getBreaches(): List<Breach>
}


