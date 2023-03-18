package com.example.qrcodeattendancesystem.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.qrcodeattendancesystem.MyButton
import com.example.qrcodeattendancesystem.ui.theme.QRCodeAttendanceSystemTheme
import com.example.qrcodeattendancesystem.R

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QRCodeAttendanceSystemTheme {
                LoginScreen()
            }
        }
    }
}

@Composable
fun LoginScreen() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background) {

        Column (modifier = Modifier.fillMaxSize()) {

            Box(modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .background(MaterialTheme.colorScheme.primary)) {

                Image(
                    modifier = Modifier.width(200.dp).align(Alignment.Center),
                    painter = painterResource(id = R.drawable.default_profile_picture),
                    contentDescription = "Profile Image")
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)) {

                TextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text(text = "Username") },
                    modifier = Modifier.fillMaxWidth()
                )

                TextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text(text = "Password") },
                    modifier = Modifier.fillMaxWidth()
                )

                MyButton(modifier = Modifier.fillMaxWidth(), text = "Login")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    QRCodeAttendanceSystemTheme {
        LoginScreen()
    }
}