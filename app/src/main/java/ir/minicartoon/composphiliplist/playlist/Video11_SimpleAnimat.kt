package ir.minicartoon.composphiliplist.playlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Video11_SimpleAnimat : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleAnimation()
            var sizeState by remember { mutableStateOf(200.dp) }
            val size by animateDpAsState(
                targetValue = sizeState, tween(
                    durationMillis = 1000
                )/*     keyframes {
                         durationMillis = 5000
                         sizeState at 0 with LinearEasing
                         sizeState * 1.5f at 1000 with FastOutLinearInEasing
                         sizeState * 2f at 5000

                     }*/, label = ""/*     tween(
                         durationMillis = 3000,
                         delayMillis = 200,
                         easing = LinearOutSlowInEasing
                     )*//*     spring(
                         Spring.DampingRatioHighBouncy
                     )*/
            )
            val infiniteTransition = rememberInfiniteTransition(label = "")
            val colorss by infiniteTransition.animateColor(
                initialValue = Color.Yellow,
                targetValue = Color.Blue,
                animationSpec = infiniteRepeatable(
                    tween(durationMillis = 2000), repeatMode = RepeatMode.Reverse
                ),
                label = ""
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

@Composable
fun SimpleAnimation() {
    var sizeState by remember { mutableStateOf(200.dp) }
    val animState by animateDpAsState(
        targetValue = sizeState,

        tween(
            durationMillis = 5000,
            delayMillis = 1000,
            easing = LinearEasing

        ),
        label = ""
    )

    Box(modifier = Modifier
        .size(animState)
        .background(Color.Blue)
        .clickable {
            sizeState += 26.dp
        })

}

//review 3 time : 30 min
@Composable
fun SimpleAnimation3() {
    var sizeState by remember { mutableStateOf(200.dp) }
    val animState by animateDpAsState(
        targetValue = sizeState,

        /*   tween(
               durationMillis = 5000,
               delayMillis = 1000,
               easing = LinearEasing

           )*/
        /* spring(Spring.DampingRatioHighBouncy
         )*/
        keyframes {
            durationMillis = 3000
            sizeState * 0 at 5000 with LinearOutSlowInEasing
            sizeState * 2f at 1000 with LinearEasing
        },
        label = ""
    )

    var infinitTransation = rememberInfiniteTransition(label = "")
    var color = infinitTransation.animateColor(
        initialValue = Color.Cyan,
        targetValue = Color.Blue,
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 1000), repeatMode = RepeatMode.Reverse
        )
    )
    Box(modifier = Modifier
        .size(animState)
        .background(color.value)
        .clickable {
            sizeState += 26.dp
        })

    Text(text = "click me to decrement", modifier = Modifier.clickable {
        sizeState -= 30.dp
    })
}