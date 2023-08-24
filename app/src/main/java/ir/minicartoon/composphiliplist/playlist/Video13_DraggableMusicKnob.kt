package ir.minicartoon.composphiliplist.playlist

import android.os.Bundle
import android.view.MotionEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import ir.minicartoon.composphiliplist.R
import ir.minicartoon.composphiliplist.playlist.ui.theme.ComposPhilipListTheme
import kotlin.math.PI
import kotlin.math.atan2

class Video13_DraggableMusicKnob : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun KnobMusic(
    modifier: Modifier = Modifier,
    limitingAngle: Float = 25f,
    onValueChange: (Float) -> Unit
) {

    var rotation by remember {
        mutableFloatStateOf(limitingAngle)
    }
    var touchX by remember {
        mutableFloatStateOf(0f)
    }

    var touchY by remember {
        mutableFloatStateOf(0f)
    }

    var centerX by remember {
        mutableFloatStateOf(0f)
    }

    var centerY by remember {
        mutableFloatStateOf(0f)
    }

    Image(painter = painterResource(id = R.drawable.music_knob),
        contentDescription = "Music Knob",
        modifier = modifier
            .fillMaxSize()
            .onGloballyPositioned {
                val boundWindow = it.boundsInWindow()
                centerX = boundWindow.size.width / 2f
                centerY = boundWindow.size.height / 2f
            }
            .pointerInteropFilter { event ->

                touchX = event.x
                touchY = event.y

                var angle = -atan2(centerY - touchY, centerX - centerY) * (180f / PI).toFloat()

                when (event.action) {
                    MotionEvent.ACTION_MOVE,
                    MotionEvent.ACTION_DOWN -> {

                        if (angle !in -limitingAngle..limitingAngle) {

                            val fixAngle = if (angle in -180f..-limitingAngle) {
                                360f + angle
                            } else {
                                angle
                            }
                            rotation = fixAngle

                            true
                        } else
                            false


                    }


                }
                false
            }


    )


}

//