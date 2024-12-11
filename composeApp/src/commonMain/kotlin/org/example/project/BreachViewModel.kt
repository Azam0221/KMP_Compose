package org.example.project

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BreachViewModel(private val apiClient: ApiClient) {
    private val _breachList = MutableStateFlow<List<Breach>>(emptyList())
    val breachList: StateFlow<List<Breach>> = _breachList

    init {
        fetchBreaches()
    }

    private fun fetchBreaches(){
      CoroutineScope(Dispatchers.Default).launch {
          try{
              val fetchedBreaches = apiClient.getBreaches()
              println("Fetched breaches: $fetchedBreaches")
              _breachList.value = fetchedBreaches
      }
          catch (e:Exception){
              e.printStackTrace()
              println("Error fetching breaches: ${e.message}")
          }


        }
    }
}