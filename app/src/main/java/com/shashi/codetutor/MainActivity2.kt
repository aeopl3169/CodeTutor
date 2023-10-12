package com.shashi.codetutor

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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.shashi.codetutor.ui.theme.customBlack

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen2(MainActivityViewModel())
        }
    }
}

//@SuppressLint("UnrememberedMutableState")
@Composable
fun MainScreen2(mainActivityViewModel: MainActivityViewModel) {

    mainActivityViewModel.counter.observeAsState().value.let {
        Log.i("shashil", "MainScreen2: $it")
    }

    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = { mainActivityViewModel.decreaseCount.invoke() },
                    colors = ButtonDefaults.buttonColors(Color.Red)) {
                Text(text = "Decrement")
            }

            Text(text = "${mainActivityViewModel.counter.value}")

            Button(onClick = { mainActivityViewModel.increaseCount.invoke() },
                colors = ButtonDefaults.buttonColors(customBlack)) {
                Text(text = "Increment")
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    MainScreen2(MainActivityViewModel())
}