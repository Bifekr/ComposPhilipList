package ir.minicartoon.composphiliplist


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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

@Composable
fun ProfileImage() {

}

data class Message(val author: String, val message: String)

@Composable
fun NewMessageCard(msg: String) {
    Text(text = "hello $msg")
}

@Composable
fun MessageCard(message: Message) {
    // Add padding around our message
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = androidx.core.R.drawable.ic_call_answer),
            contentDescription = "content Profile",
            Modifier
                // Set image size to 40 dp
                .size(40.dp)
                // Clip image to be shaped as a circle
                .clip(CircleShape)

        )
        // Add a horizontal space between the image and the column
        Spacer(
            modifier = Modifier.width(8.dp)
        )
        Column {
            Text(text = message.author)
            // Add a vertical space between the author and message texts
            Spacer(Modifier.height(12.dp))
            Text(text = message.message)
        }
    }


}

@Preview
@Composable
fun PreviewMessageCard() {
    MessageCard(message = Message("milad", "newMessage"))
}

