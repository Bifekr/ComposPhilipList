package ir.minicartoon.composphiliplist.playlist

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Video12_ProgressBar : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProgressbarSample(percentage = 75f, number = 200)

        }
    }
}


@Composable
fun ProgressbarSample(
    percentage: Float,
    number: Int,
    radius: Dp = 50.dp,
    text: TextUnit = 24.sp,
    color: Color = Color.Blue,
    animDelay: Int = 0,
    animDuration: Int = 2000,
    strokeWidth: Dp = 8.dp
) {
    var animatePlayed by remember { mutableStateOf(false) }
    val curPercentage = animateFloatAsState(
        targetValue = if (animatePlayed) percentage else 0f,
        tween(
            delayMillis = animDelay, durationMillis = animDuration
        ), label = ""
    )

    LaunchedEffect(key1 = true) {
        animatePlayed = true
    }

    Box(contentAlignment = Alignment.Center, modifier = Modifier.size(radius * 2f)) {
        Canvas(modifier = Modifier.size(radius * 2f)) {
            drawArc(
                color = Color.Blue,
                startAngle = -90f,
                sweepAngle = 360 * curPercentage.value,
                useCenter = false,
                style = Stroke(strokeWidth.value, cap = StrokeCap.Round)
            )
        }
        Text(
            text = (curPercentage.value * number).toInt().toString(),
            color = color,
            fontSize = text

        )
    }
}

//review  4
@Composable
fun CircleProgressBarExample4(

    modifier: Modifier = Modifier,
    percentage: Float,
    number: Int,
    fontSize: TextUnit = 28.sp,
    radius: Dp = 50.dp,
    strokeWidth: Dp = 8.dp,
    animDuration: Int = 1000,
    animDelay: Int = 0

) {

    var animPlayed = remember { mutableStateOf(false) }
    var curPercentage = animateFloatAsState(
        targetValue = if (animPlayed.value) percentage else 0f,
        tween(
            durationMillis = animDuration, delayMillis = animDelay
        ), label = ""
    )

    LaunchedEffect(key1 = true) { animPlayed.value = true }
    Box(modifier = Modifier.size(radius * 2), contentAlignment = Alignment.Center) {
        Canvas(modifier = Modifier.size(radius * 2)) {
            drawArc(
                color = Color.Cyan,
                -90f,
                360 * curPercentage.value,
                false,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )

        }
        Text(text = (number * curPercentage.value).toInt().toString(), fontSize = fontSize)
    }


}

//review  5
@Composable
fun CircleProgressExample5(
    percentage: Float,
    number: Int,
    durationAnim: Int = 1000,
    delayAnim: Int = 0
) {
    val animPlayed = remember { mutableStateOf(false) }
    val curPercentage = animateFloatAsState(
        targetValue = if (animPlayed.value) percentage else 0f, tween(
            durationMillis = durationAnim, delayMillis = delayAnim
        ), label = ""
    )
    LaunchedEffect(key1 = true) { animPlayed.value = true }

    Box(modifier = Modifier.size(50.dp * 2), contentAlignment = Alignment.Center) {
        Canvas(modifier = Modifier.size(50.dp * 2)) {
            drawArc(
                color = Color.Green,
                -90f,
                360 * curPercentage.value, false, style = Stroke(8.dp.toPx(), cap = StrokeCap.Round)
            )
        }
        Text(text = (number * curPercentage.value).toInt().toString())
    }
}

//review 6 , time= 20 min
@Composable
fun ProgressBarSample6(
    number: Int,
    maxNumber: Int,
    degree: Float,
    animDelay: Int = 0,
    animDuration: Int = 5000,
    strokeWidth: Dp = 8.dp
) {
    val curDegree =
        animateFloatAsState(
            targetValue = degree,
            tween(
                delayMillis = animDelay, durationMillis = animDuration
            ),
            label = "",
        )

    Box(modifier = Modifier.size(250.dp), contentAlignment = Alignment.Center) {
        Canvas(modifier = Modifier.size(250.dp)) {
            drawArc(
                color = Color.Blue,
                startAngle = -90f,
                sweepAngle = 360 * curDegree.value,
                false,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
        }

        Text(text = (number * curDegree.value).toInt().toString())
    }

}