package ir.minicartoon.composphiliplist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var fontFamily = FontFamily(
            Font(R.font.signikanegative_light, FontWeight.Light),
            Font(R.font.signikanegative_regular, FontWeight.Thin),
            Font(R.font.signikanegative_medium, FontWeight.Medium),
            Font(R.font.signikanegative_semibold, FontWeight.SemiBold),
            Font(R.font.signikanegative_bold, FontWeight.Bold),
            Font(R.font.signikanegative_light, FontWeight.Light)

        )
        setContent {
            Box(
                modifier = Modifier
                    .background(color = Color(0xFF101010))
                    .fillMaxSize()

            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.Magenta,
                                fontSize = 60.sp
                            )
                        ) {
                            append("J")
                        }
                        append("etpack ")
                        withStyle(
                            style = SpanStyle(
                                color = Color.Magenta,
                                fontSize = 60.sp
                            )
                        ) {
                            append("C")
                        }
                        append("ompose ")
                    },
//                    text = "Jetpack Compose",
                    color = Color.Green,
                    fontSize = 35.sp,
                    fontStyle = FontStyle.Italic,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    textDecoration = TextDecoration.Underline

                )


            }
        }
    }


}