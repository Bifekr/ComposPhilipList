package ir.minicartoon.composphiliplist.playlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import ir.minicartoon.composphiliplist.playlist.ui.theme.ComposPhilipListTheme

class Part9_ConstraintLayout : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Composable
fun ConstraintSample() {

    val constraints = ConstraintSet {
        val boxGreen = createRefFor("gBox")
        val blueBox = createRefFor("bBox")
        val guidLine = createGuidelineFromTop(0.5f)

        constrain(boxGreen) {
            top.linkTo(guidLine)
            start.linkTo(parent.start)
            width = Dimension.value(100.dp)
            height = Dimension.value(80.dp)
        }

        constrain(blueBox) {
            top.linkTo(parent.top)
            start.linkTo(boxGreen.end)
            end.linkTo(parent.end)
            width = Dimension.value(100.dp)
            height = Dimension.value(80.dp)
        }

        createHorizontalChain(boxGreen, blueBox, chainStyle = ChainStyle.Packed)

    }

    ConstraintLayout(constraints) {
        Box(
            modifier = Modifier
                .background(Color.Green)
                .layoutId("gBox")
        )
        Box(
            modifier = Modifier
                .background(Color.Blue)
                .layoutId("bBox")
        )
    }
}