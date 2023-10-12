package com.shashi.codetutor

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(this.applicationContext)
        }
    }
}

//@SuppressLint("UnrememberedMutableState")
@Composable
fun MainScreen(context: Context? = null) {

    var counter = rememberSaveable {
        mutableStateOf(0)
    }
    Log.i("shashil", "When composable is called : $counter")

    var increaseCount = {
        counter.value++
    }

    var decreaseCount = {
        counter.value--
    }

    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = { decreaseCount.invoke() }) {
                Text(text = "Decrement")
            }
            
            Text(text = "${counter.value}")
            
            Button(onClick = { increaseCount.invoke() }) {
                Text(text = "Increment")
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    MainScreen()
}