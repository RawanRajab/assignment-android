package com.example.andriond1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class FirstActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var message by remember { mutableStateOf("") }

            Column(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = message,
                    onValueChange = { message = it },
                    label = { Text("Enter your message") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(20.dp))
                Button(onClick = {
                    val intent = Intent(this@FirstActivity, SecondActivity::class.java)
                    intent.putExtra("message", message)
                    startActivityForResult(intent, 1)
                }) {
                    Text("Send to SecondActivity")
                }
                Spacer(modifier = Modifier.height(20.dp))
                Button(onClick = {
                    val intent = Intent(this@FirstActivity, ThirdActivity::class.java)
                    startActivity(intent)
                }) {
                    Text("Go to ThirdActivity")
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // Handle result from SecondActivity if needed
    }

    override fun onResume() {
        super.onResume()
        // Log or show lifecycle stage
    }
}