package ir.minicartoon.composphiliplist.playlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.minicartoon.composphiliplist.playlist.ui.theme.ComposPhilipListTheme

class Video11_SimpleAnimat : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var sizeState by remember { mutableStateOf(200.dp) }
            val size by animateDpAsState(
                targetValue = sizeState,
                tween(
                    durationMillis = 1000
                )
                /*     keyframes {
                         durationMillis = 5000
                         sizeState at 0 with LinearEasing
                         sizeState * 1.5f at 1000 with FastOutLinearInEasing
                         sizeState * 2f at 5000

                     }*/, label = ""
                /*     tween(
                         durationMillis = 3000,
                         delayMillis = 200,
                         easing = LinearOutSlowInEasing
                     )*/
                /*     spring(
                         Spring.DampingRatioHighBouncy
                     )*/
            )
            val infiniteTransition = rememberInfiniteTransition(label = "")
            val colorss by infiniteTransition.animateColor(
                initialValue = Color.Yellow,
                targetValue = Color.Blue,
                animationSpec = infiniteRepeatable(
                    tween(durationMillis = 2000), repeatMode = RepeatMode.Reverse
                ), label = ""
            )

            Box(
                modifier = Modifier
                    .background(colorss)
                    .size(size)
                    .clickable {
                        sizeState += 50.dp
                    }, contentAlignment = Alignment.Center
            ) {
                Text(text = "click me", fontSize = 25.sp)
            }

        }
    }
}
