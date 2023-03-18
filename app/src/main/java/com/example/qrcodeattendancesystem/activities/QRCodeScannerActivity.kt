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

class QRCodeScannerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QRCodeAttendanceSystemTheme {
                QRCodeScannerScreen()
            }
        }
    }
}

@Composable
fun QRCodeScannerScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background) {

        Text(text = "QRCodeScanner Screen")
    }
}

@Preview(showBackground = true)
@Composable
fun QRCodeScannerScreenPreview() {
    QRCodeAttendanceSystemTheme {
        QRCodeScannerScreen()
    }
}