package ir.minicartoon.composphiliplist.playlist

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

class Part7_TextFiled : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val snackbarHostState = remember { SnackbarHostState() }
            val scope = rememberCoroutineScope()
            var textfiledState by remember { mutableStateOf("") }

            /*  Scaffold(
                  snackbarHost = { SnackbarHost(snackbarHostState) },
                  floatingActionButton = {
                      var clickCount by remember { mutableStateOf(0) }
                      ExtendedFloatingActionButton(
                          onClick = {
                              // show snackbar as a suspend function
                              scope.launch {
                                  snackbarHostState.showSnackbar(
                                      "Snackbar # ${++clickCount}"
                                  )
                              }
                          }
                      ) { Text("Show snackbar") }
                  },
                  content = { innerPadding ->
                      Text(
                          text = "Body content",
                          modifier = Modifier.padding(innerPadding).fillMaxSize().wrapContentSize()
                      )
                  }
              )*/
      Scaffold(
          snackbarHost = { SnackbarHost(snackbarHostState) },

          ) {
          Column(
              modifier = Modifier.fillMaxSize(),
              horizontalAlignment = Alignment.CenterHorizontally,
              verticalArrangement = Arrangement.Center
          ) {
              TextField(
                  value = textfiledState,
                        onValueChange = {
                            textfiledState = it
                        },
                        singleLine = true,
                        label = { "Enter Your Name" })
                    Spacer(modifier = Modifier.height(it.calculateBottomPadding()))
                    Button(
                        onClick = {
                            scope.launch {
                                snackbarHostState.showSnackbar(
                                    message = "Hello $textfiledState",
                                    actionLabel = "Click me",
                                    duration = SnackbarDuration.Short
                                )
                            }
                        })
                    {
                        Text(text = "Click me")
                    }
          }
      }

        }
    }
}

//review 4
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowSnackBar() {
    var title by remember {
        mutableStateOf("")
    }
    val snackBarHostState3 = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    Scaffold(snackbarHost = { SnackbarHost(snackBarHostState3) }

    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                value = title,
                onValueChange = {
                    title = it
                },
                singleLine = true,
                label = { "Enter Your Name" })
            Spacer(modifier = Modifier.height(it.calculateBottomPadding()))
            Button(
                onClick = {
                    scope.launch {
                        snackBarHostState3.showSnackbar(
                            message = "Hello $title",
                            actionLabel = "Click me",
                            duration = SnackbarDuration.Short
                        )
                    }
                })
            {
                Text(text = "Click me")
            }
        }
    }

}


