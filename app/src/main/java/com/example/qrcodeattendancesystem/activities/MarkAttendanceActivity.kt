package com.example.qrcodeattendancesystem.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.qrcodeattendancesystem.ui.theme.QRCodeAttendanceSystemTheme

class MarkAttendanceActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QRCodeAttendanceSystemTheme {
                MarkAttendanceScreen()
            }
        }
    }
}

@Composable
fun MarkAttendanceScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background) {

        Text(text = "MarkAttendance Screen")
    }
}

@Preview(showBackground = true)
@Composable
fun MarkAttendanceScreenPreview() {
    QRCodeAttendanceSystemTheme {
        ViewAttendanceScreen()
    }
}