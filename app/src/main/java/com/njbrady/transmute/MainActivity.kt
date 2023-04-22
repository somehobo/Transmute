package com.njbrady.transmute

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.njbrady.transmute.ui.theme.TransmuteTheme

const val APP_NAME = "PacketMap"

class MainActivity : ComponentActivity() {
    val tracerViewModel = TracerViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(topBar = {
                TopAppBar(title = {     Text(APP_NAME)
                }, actions = {
                    IconButton(
                        onClick = { tracerViewModel.pleaseGetDadJoke() },
                        modifier = Modifier
                            .size(40.dp)
                    ) {
                        Icon(
                            modifier = Modifier.size(40.dp),
                            imageVector = Icons.Outlined.Refresh,
                            contentDescription = ""
                        )
                    }
                })
            }) {
                TransmuteTheme {

                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background
                    ) {
                        Layout(tracerViewModel)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TransmuteTheme {
        Greeting("Android")
    }
}

@Composable
fun Layout(tracerViewModel: TracerViewModel){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
//            Title()
            RandoDadJoke(modifier = Modifier.padding(16.dp), tracerViewModel)
            Route(modifier = Modifier.padding(16.dp), tracerViewModel)
//            RandoButton(modifier = Modifier.padding(16.dp), tracerViewModel)
    }
}

@Composable
fun Title(){
    Text(APP_NAME, fontSize = 50.sp)
}

@Composable
fun RandoButton(modifier: Modifier, tracerViewModel: TracerViewModel){
    Button(onClick = {
        tracerViewModel.pleaseGetDadJoke()
    }) {
        Text(text = "Request Random Joke", fontSize = 30.sp)
    }
}

@Composable
fun RandoDadJoke(modifier: Modifier,tracerViewModel: TracerViewModel){
    val dadJoke by tracerViewModel.dadJoke.collectAsState()
    dadJoke?.let {
        Text(text = "Response from server: $it", modifier = modifier, fontSize = 30.sp)
    }
}

@Composable
fun Route(modifier: Modifier,tracerViewModel: TracerViewModel) {
    val route by tracerViewModel.route.collectAsState()
    route?.let {
        Text(text = "Package Route: $it", modifier = modifier, fontSize = 30.sp)
    }
}
