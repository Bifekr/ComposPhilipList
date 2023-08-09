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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import ir.minicartoon.composphiliplist.R
import ir.minicartoon.composphiliplist.playlist.ui.theme.ComposPhilipListTheme

class Part5_TextStyle : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            SimpleTextStyle()
        }
    }
}

@Composable
fun SimpleTextStyle() {

    val fontFamily: FontFamily = FontFamily(
        Font(R.font.signikanegative_light, FontWeight.Light),
        Font(R.font.signikanegative_regular, FontWeight.Normal),
        Font(R.font.signikanegative_medium, FontWeight.Medium),
        Font(R.font.signikanegative_semibold, FontWeight.SemiBold),
        Font(R.font.signikanegative_bold, FontWeight.Bold)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff101010))

    ) {
        Text(
            text = "jetpack Compose",
            color = Color.Blue,
            fontSize = 18.sp,
            fontFamily = fontFamily

        )
    }
}