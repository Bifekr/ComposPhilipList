package ir.minicartoon.composphiliplist.playlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
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
import ir.minicartoon.composphiliplist.playlist.ui.theme.BlueViolet1
import ir.minicartoon.composphiliplist.playlist.ui.theme.ComposPhilipListTheme

class Part9_ConstraintLayout : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

//google documentation Way
@Composable
fun ConstraintLayoutContent() {
    ConstraintLayout {
        // Create references for the composables to constrain
        val (button, text) = createRefs()

        Button(
            onClick = { /* Do something */ },
            // Assign reference "button" to the Button composable
            // and constrain it to the top of the ConstraintLayout
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top, margin = 16.dp)
            }
        ) {
            Text("Button")
        }

        // Assign reference "text" to the Text composable
        // and constrain it to the bottom of the Button composable
        Text(
            "Text",
            Modifier.constrainAs(text) {
                top.linkTo(button.bottom, margin = 16.dp)
            }
        )
    }
}

//philip way
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

//review 4
@Composable
fun ConstraintSample2() {
    val contraints = ConstraintSet {
        val greenBox = createRefFor("greenBox")
        val yellowBox = createRefFor("yellowBox")
//gouidLine
        val guideLine = createGuidelineFromTop(.5f)

        constrain(greenBox) {

            start.linkTo(parent.start)
            top.linkTo(guideLine)
//            top.linkTo(parent.top)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }

        constrain(yellowBox)
        {
            start.linkTo(greenBox.end)
            top.linkTo(parent.top)
            end.linkTo(parent.end)
//            width= Dimension.fillToConstraints
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }


//        Chain out of constraint Block
        createHorizontalChain(greenBox, yellowBox, chainStyle = ChainStyle.Packed)

    }

    ConstraintLayout(contraints, modifier = Modifier.fillMaxWidth()) {

        Box(
            modifier = Modifier
                .background(BlueViolet1)
                .layoutId("greenBox")
        )
        Box(modifier = Modifier
            .background(Color.Yellow)
            .layoutId("yellowBox"))

    }

}