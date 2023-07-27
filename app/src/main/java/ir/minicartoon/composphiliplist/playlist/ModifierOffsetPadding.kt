package ir.minicartoon.composphiliplist.playlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class ModifierOffsetPadding : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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
    }
}



