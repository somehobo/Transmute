package com.njbrady.transmute

import android.graphics.fonts.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.njbrady.transmute.ui.theme.TransmuteTheme

const val APP_NAME = "PacketMap"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TransmuteTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Layout()
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
fun Layout(){
    LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
        item{
            Title()
            RandoButton()
            RandoImage()
        }
    }
}

@Composable
fun Title(){
    Text(APP_NAME, fontSize = 50.sp)
}

@Composable
fun RandoButton(){
    Button(onClick = {
        //your onclick code here
    }) {
        Text(text = "Generate Random Image", fontSize = 30.sp)
    }
}

@Composable
fun RandoImage(){
    //get request goes here
}
