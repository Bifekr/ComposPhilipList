package ir.minicartoon.composphiliplist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleList4()
        }

    }

}

//review4
@Composable
fun SimpleList4() {
    val scrollState = rememberScrollState()
    val list = listOf("one", "twoe", "three", "for")
    val j = 0
    Column(Modifier.verticalScroll(scrollState)) {
        for (i in 1..50) {
            Text(text = "this item number is $i")
        }

    }
}

//review 5
@Composable
fun ImageCard2(
    title: String,
    desc: String,
    painter: Painter,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
            .width(300.dp),
        RoundedCornerShape(8.dp),


        ) {
        Box(modifier = Modifier.height(150.dp)) {

            Image(painter = painter, contentDescription = desc, contentScale = ContentScale.Crop)
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(
                                Color.Transparent,
                                Color.Black
                            ), 300f
                        ),
                    )
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp), contentAlignment = Alignment.BottomCenter
            ) {
                Text(text = title, style = TextStyle(fontSize = 16.sp, color = Color.White))
            }
        }
    }


}
