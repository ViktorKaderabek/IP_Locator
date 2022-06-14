package com.example.ipwho.presentation.HomeScreen

import android.widget.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ipwho.presentation.MainActivity
import com.example.ipwho.presentation.Screen


@Composable
fun HomeScreen(
    navController: NavController
) {
    var textFieldState by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Text(
            text = "Welocme in ip informations detector",
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Italic,
            modifier = Modifier
                .padding(20.dp)
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp)
                .background(Color.White),
            value = textFieldState,
            label = {
                Text(
                    text = "Enter IP adress",
                    color = Color.Black
                )
            },
            onValueChange = {
                textFieldState = it
            },
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(Color.White)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                modifier = Modifier
                    .height(50.dp)
                    .width(135.dp)
                    .background(Color.White),
                onClick = {
                    navController
                        .navigate(Screen.MyIpScreen.route)
                },
                colors = ButtonDefaults.buttonColors(Color.White)

            ) {
                Text(
                    text = "My IP Info",
                    color = Color.Black,
                )
            }

            Button(
                modifier = Modifier
                    .height(50.dp)
                    .width(135.dp)
                    .background(Color.White),
                onClick = {
                        navController
                            .navigate(Screen.MyIpScreen.route)
                },
                colors = ButtonDefaults.buttonColors(Color.White)

            ) {
                Text(
                    text = "Other IP info",
                    color = Color.Black,
                )
            }
        }
    }
}
