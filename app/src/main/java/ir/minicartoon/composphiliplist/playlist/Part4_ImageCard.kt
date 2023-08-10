package ir.minicartoon.composphiliplist.playlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import org.w3c.dom.Text

class Part4_ImageCard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}


@Composable
fun ImageCard2(
    title: Text,
    desc: Text,
    painter: Painter,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
//        elevation = 6.dp
    ) {

        Box(modifier = Modifier.fillMaxSize()) {
//            Image (painter=painter,description=desc,contentScale = ContentScale.FillWidth)


        }
    }
}

//@Composable
//fun ImageCard3(
//    painter: Painter, description: String, title: String, modifier: Modifier = Modifier
//) {
//    Card(
//        modifier = modifier.fillMaxWidth(0.7f),
//        shape = RoundedCornerShape(15.dp),
////        elevation = 5.dp
//
//    ) {
//        Box(modifier = Modifier.height(150.dp)) {
//            Image(
//                painter = painter, description, contentScale = ContentScale.FillWidth
//            )
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(12.dp),
//                contentAlignment = Alignment.BottomStart
//            ) {
//                Text(title, style = TextStyle(color = Color.White, fontSize = 16.sp))
//            }
//
//        }
//
//    }
//
//}