package ir.minicartoon.composphiliplist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import ir.minicartoon.composphiliplist.ui.theme.ComposPhilipListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(
                message = Message("milad", "newMessage")
            )

        }

    }

}


data class Message(val author: String, val message: String)

@Composable
fun NewMessageCard(msg: String) {
    Text(text = "hello $msg")
}

@Composable
fun MessageCard(message: Message) {
    Text(text = message.author)
    Text(text = message.message)
}

@Preview
@Composable
fun PreviewMessageCard() {
    MessageCard(message = Message("milad", "newMessage"))
}

