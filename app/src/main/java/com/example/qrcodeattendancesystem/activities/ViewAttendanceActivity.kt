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

class ViewAttendanceActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QRCodeAttendanceSystemTheme {
                ViewAttendanceScreen()
            }
        }
    }
}

@Composable
fun ViewAttendanceScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background) {

        Text(text = "ViewAttendance Screen")
    }
}

@Preview(showBackground = true)
@Composable
fun ViewAttendanceScreenPreview() {
    QRCodeAttendanceSystemTheme {
        ViewAttendanceScreen()
    }
}