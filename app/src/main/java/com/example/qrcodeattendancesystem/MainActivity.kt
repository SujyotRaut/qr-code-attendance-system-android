package com.example.qrcodeattendancesystem

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

        Column(modifier = Modifier.fillMaxSize()) {

            Box(modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.2f)
                .background(MaterialTheme.colorScheme.primary)) {

                Image(modifier = Modifier
                    .width(200.dp)
                    .align(Alignment.Center),
                    painter = painterResource(id = R.drawable.default_profile_picture),
                    contentDescription = "Profile Image")
            }

            Row(modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)) {

                Column(modifier = Modifier.weight(1f)) {
                    Text(text = "Student ID")
                    Text(text = "Course")
                    Text(text = "Year")
                    Text(text = "Semester")
                    Text(text = "Branch")
                }

                Column {
                    Text(text = ":")
                    Text(text = ":")
                    Text(text = ":")
                    Text(text = ":")
                    Text(text = ":")
                }

                Column(modifier = Modifier.weight(1f)) {
                    Text(text = "TBE19138")
                    Text(text = "BE")
                    Text(text = "4th")
                    Text(text = "8th")
                    Text(text = "CSE")
                }
            }

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)) {

                MyButton(modifier = Modifier.weight(1f),
                    text = "Attendance",
                    onClick = {
                        val intent = Intent(context, ViewAttendanceActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
                        context.startActivity(intent) })

                MyButton(modifier = Modifier.weight(1f),
                    text = "Scan QR",
                    onClick = {
                        val intent = Intent(context, QRCodeScannerActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
                        context.startActivity(intent) })
            }
        }
    }
}

@Composable
fun MyButton(modifier: Modifier = Modifier, text: String = "Button", onClick: () -> Unit = {}) {
    Button(onClick = onClick, modifier = modifier) {
        Text(text = text.uppercase())
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    QRCodeAttendanceSystemTheme {
        MainScreen()
    }
}