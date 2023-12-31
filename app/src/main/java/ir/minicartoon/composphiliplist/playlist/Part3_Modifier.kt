package ir.minicartoon.composphiliplist.playlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.minicartoon.composphiliplist.playlist.ui.theme.ComposPhilipListTheme

class Part3_Modifier : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Column(
                Modifier
                    .fillMaxSize(0.5f)
//                    .width(300.dp)
//                    .requiredWidth (250.dp)
                    .padding(10.dp)
                    .border(5.dp, Color.Blue),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Spacer(modifier = Modifier.height(120.dp))
                Text(
                    text = "Hello", Modifier
                        .offset(50.dp, 120.dp)
                )
                Text(text = "World!")
            }


        }
    }
}

@Composable
fun SsetContent() {
    Column(
        modifier = Modifier
            .background(color = Color.Green)
            .fillMaxHeight(0.5f)
            .width(300.dp)
//                    .padding(4.dp)
            .border(8.dp, color = Color.Red)
//                    .padding(8.dp)
            .border(8.dp, color = Color.Blue)
//                    .padding(8.dp)
            .border(12.dp, color = Color.Black)
            .padding(15.dp)
//                    .border(14.dp,color=Color.Magenta)
//                    .requiredHeight(600.dp)
    ) {

        Text(
            text = "Hello"
//                    ,modifier=Modifier
//                    .offset(y=20.dp)
//                    .padding(20.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))


        Text(text = "Dream")

    }

}