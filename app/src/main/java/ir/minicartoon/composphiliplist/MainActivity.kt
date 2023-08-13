package ir.minicartoon.composphiliplist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            SimpleList()
//            ScrollSimpleList()
//            LazyColumnSample()
            LazyColumn2()
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


