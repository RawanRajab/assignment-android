package com.example.andriond1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class ThirdActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = { makePhoneCall() }) {
                    Text("Make a Phone Call")
                }
                Spacer(modifier = Modifier.height(20.dp))
                Button(onClick = { shareContent() }) {
                    Text("Share Content")
                }
                Spacer(modifier = Modifier.height(20.dp))
                Button(onClick = { openMedium() }) {
                    Text("Open Medium Website")
                }
            }
        }
    }

    private fun makePhoneCall() {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:01101594902")
        startActivity(intent)
    }

    private fun shareContent() {
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "Check out this content!")
            type = "text/plain"
        }
        startActivity(Intent.createChooser(sendIntent, null))
    }

    private fun openMedium() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://medium.com/@ramadan123sayed/understanding-explicit-and-implicit-intents-in-android-179830599398"))
        startActivity(intent)
    }
}