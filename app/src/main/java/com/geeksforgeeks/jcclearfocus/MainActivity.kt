package com.geeksforgeeks.jcclearfocus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            // Creating a Simple Scaffold Layout for the application
            Scaffold(

                // Creating a Top Bar
                topBar = { TopAppBar(title = { Text("GFG | Clear Focus BasicTextField", color = Color.White) }, backgroundColor = Color(0xff0f9d58)) },

                // Creating Content
                content = {

                    // Creating a Column Layout
                    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

                        val focusRequester = remember { FocusRequester() }
                        val focusManager = LocalFocusManager.current
                        var value by remember { mutableStateOf("") }
                        BasicTextField(
                            value = value,
                            onValueChange = { value = it },
                            decorationBox = { innerTextField ->
                                Row(
                                    Modifier
                                        .background(Color.LightGray, RoundedCornerShape(percent = 30))
                                        .padding(16.dp)
                                        .focusRequester(focusRequester)
                                ) {
                                    //...
                                    innerTextField()
                                }
                            }
                        )

                        Spacer(Modifier.height(100.dp))

                        Button(onClick = { focusManager.clearFocus() }, colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58))) {
                            Text("Clear focus", color = Color.White)
                        }
                    }
                }
            )
        }
    }
}
