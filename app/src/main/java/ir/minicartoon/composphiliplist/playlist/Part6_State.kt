package ir.minicartoon.composphiliplist.playlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

class Part6_State : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(Modifier.fillMaxSize()) {
                val color = remember { mutableStateOf(Color.Yellow) }
                BoxesColor(
                    Modifier
                        .weight(1f)
                        .fillMaxSize(),
                    updateColor = {
                        color.value = it
                    }
                )


                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxSize()
                        .background(color.value)
                )
            }
        }
    }
}

@Composable
fun BoxColor(modifier: Modifier = Modifier) {
    val color = remember { mutableStateOf(Color.Yellow) }
    Box(modifier = modifier
        .background(color.value)
        .clickable {
            color.value = Color(
                Random.nextFloat(),
                Random.nextFloat(),
                Random.nextFloat(),
                1f
            )
        }

    )
}

@Composable
fun BoxesColor(modifier: Modifier = Modifier, updateColor: (Color) -> Unit) {
    Box(modifier = modifier
        .background(Color.Blue)
        .clickable {

            updateColor(
                Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                )

            )
        }
    )
}