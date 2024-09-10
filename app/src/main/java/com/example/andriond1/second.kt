package com.example.andriond1
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val message = intent.getStringExtra("message") ?: "No message received"

            Column(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Message received: $message", style = MaterialTheme.typography.headlineMedium)
                Spacer(modifier = Modifier.height(20.dp))
                Button(onClick = {
                    val resultIntent = Intent()
                    resultIntent.putExtra("result", "Received: $message")
                    setResult(RESULT_OK, resultIntent)
                    finish()
                }) {
                    Text("Return to FirstActivity")
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        // Log or show lifecycle stage
    }

    // Implement other lifecycle methods as needed
}