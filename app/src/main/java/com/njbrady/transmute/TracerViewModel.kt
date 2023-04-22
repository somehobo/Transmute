package com.njbrady.transmute

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.njbrady.transmute.Requests.getDadJoke
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Thread.State

class TracerViewModel : ViewModel() {

    private val _dadJoke = MutableStateFlow<String?>(null)
    private val _route = MutableStateFlow<String?>(null)


    val dadJoke: StateFlow<String?> = _dadJoke
    val route: StateFlow<String?> = _route


    fun pleaseGetDadJoke() {
        //get fake dad joke
        //compile fake route
        _dadJoke.value = dadJokes.random()
        val randomCities = cities.shuffled().take(5)
        _route.value =
            randomCities[0] + " -> " + randomCities[1] + " -> " + randomCities[2] + " -> " + randomCities[3] + " -> " + randomCities[4]
    }


}