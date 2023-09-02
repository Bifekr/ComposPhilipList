package ir.minicartoon.composphiliplist.playlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.minicartoon.composphiliplist.playlist.ui.theme.ComposPhilipListTheme

class Part8_Recyclerview : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Composable
fun SimpleList() {

    Column {
        for (i in 1..50)
            Text(
                text = "item in $i",
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            )
    }

}

@Composable
fun ScrollSimpleList() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.verticalScroll(scrollState)
    ) {
        for (i in 0..50)
            Text(
                text = "value of $i"
            )

    }
}

@Composable
fun LazyColumnSample() {

    LazyColumn {
        //All items loaded when app Startup
        items(5000) {
            Text(
                text = "item in $it",
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            )
        }
    }
}

@Composable
fun LazyColumn2() {

    LazyColumn {
        itemsIndexed(
            listOf("this", "is", "list", "in", "Compose")

        ) { int, String ->
            Text(text = String)

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
        for (i in 0..4) {
            Text(text = "this item number is $i")
        }

    }
}