package ir.minicartoon.composphiliplist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
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

        setContent {


            SimpleTextStyle()
//AnnotationTextStyle()p

        }
    }

}


@Composable
fun SimpleTextStyle() {

    val fontFamily = FontFamily(
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
            style = TextStyle(
                color = Color.Blue, fontSize = 32.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.End,
                textDecoration = TextDecoration.Underline
            )

        )
    }
}

@Composable
fun AnnotationTextStyle() {
    val fontFamily = FontFamily(
        Font(R.font.signikanegative_light, FontWeight.Light),
        Font(R.font.signikanegative_regular, FontWeight.Normal),
        Font(R.font.signikanegative_semibold, FontWeight.SemiBold),
        Font(R.font.signikanegative_bold, FontWeight.Bold),
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff101010))
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.Blue,
                        fontSize = 50.sp
                    )
                ) {
                    append("J")
                }
                append("etpack ")

                withStyle(
                    style = SpanStyle(
                        color = Color.Cyan,
                        fontSize = 50.sp
                    )
                ) {
                    append("C")
                }

                append("ompose")


            },
            color = Color.Green,
            fontFamily = fontFamily,
            fontSize = 32.sp
        )
    }
}