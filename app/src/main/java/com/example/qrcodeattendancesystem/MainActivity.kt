package com.example.qrcodeattendancesystem

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.qrcodeattendancesystem.activities.*
import com.example.qrcodeattendancesystem.ui.theme.QRCodeAttendanceSystemTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QRCodeAttendanceSystemTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val context = LocalContext.current

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background) {

        Column {

            Button(onClick = { context.startActivity(Intent(context, LoginActivity::class.java)) }) {
                Text(text = "Log In")
            }

            Button(onClick = { context.startActivity(Intent(context, QRCodeScannerActivity::class.java)) }) {
                Text(text = "QR Code Scanner")
            }

            Button(onClick = { context.startActivity(Intent(context, MarkAttendanceActivity::class.java)) }) {
                Text(text = "Mark Attendance")
            }

            Button(onClick = { context.startActivity(Intent(context, ViewAttendanceActivity::class.java)) }) {
                Text(text = "View Attendance")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    QRCodeAttendanceSystemTheme {
        MainScreen()
    }
}