package com.example.ipwho.presentation.MyIpScreen

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.ipwho.presentation.MyIpScreen.view_model.MyIpScreenViewModel
import org.koin.androidx.compose.inject

@Composable
fun MyIpScreen() {
    val viewModel by inject<MyIpScreenViewModel>()
    val state = viewModel.state.value
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        state.IpInfo?.let { result ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                item {
                    Text(
                        text = result.flag.emoji,
                        color = Color.White,
                        fontSize = 50.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic,
                        modifier = Modifier
                            .padding(20.dp)
                    )

                    val mapIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("geo:${result.latitude}, ${result.longitude}?q=${result.latitude},${result.longitude} (Label+Name)") // souradnice a pointer
                    )
                    val context = LocalContext.current
                    mapIntent.setPackage("com.google.android.apps.maps")
                    Button(
                        onClick = {
                            startActivity(context, mapIntent, null)
                        }
                    ) {
                        Text("Location of IP")
                    }



                    Text(
                        text = "IP : ${result.ip}",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic,
                        modifier = Modifier
                            .padding(20.dp)
                    )

                    Text(
                        text = "Success : ${result.success}",
                        color = if (result.success) Color.Green else Color.Red,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic,
                        modifier = Modifier
                            .padding(20.dp)
                    )

                    Text(
                        text = "Type : ${result.type}",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic,
                        modifier = Modifier
                            .padding(20.dp)
                    )

                    Text(
                        text = "Continent : ${result.continent}",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic,
                        modifier = Modifier
                            .padding(20.dp)
                    )

                    Text(
                        text = "Continent code : ${result.continent_code}",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic,
                        modifier = Modifier
                            .padding(20.dp)
                    )

                    Text(
                        text = "Country : ${result.country}",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic,
                        modifier = Modifier
                            .padding(20.dp)
                    )

                    Text(
                        text = "Country code : ${result.country_code}",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic,
                        modifier = Modifier
                            .padding(20.dp)
                    )

                    Text(
                        text = "Region : ${result.region}",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic,
                        modifier = Modifier
                            .padding(20.dp)
                    )

                    Text(
                        text = "City : ${result.city}",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic,
                        modifier = Modifier
                            .padding(20.dp)
                    )

                    Text(
                        text = "is EU : ${result.is_eu}",
                        color = if (result.is_eu) Color.Green else Color.Red,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic,
                        modifier = Modifier
                            .padding(20.dp)
                    )

                    Text(
                        text = "Postal : ${result.postal}",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic,
                        modifier = Modifier
                            .padding(20.dp)
                    )

                    Text(
                        text = "Calling code : ${result.calling_code}",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic,
                        modifier = Modifier
                            .padding(20.dp)
                    )

                    Text(
                        text = "Capital : ${result.capital}",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic,
                        modifier = Modifier
                            .padding(20.dp)
                    )

                    Text(
                        text = "Borders : ${result.borders}",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic,
                        modifier = Modifier
                            .padding(20.dp)
                    )

                    Text(
                        text = "Connection asn : ${result.connection.asn}",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic,
                        modifier = Modifier
                            .padding(20.dp)
                    )

                    Text(
                        text = "Connection org : ${result.connection.org}",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic,
                        modifier = Modifier
                            .padding(20.dp)
                    )

                    Text(
                        text = "Connection isp : ${result.connection.isp}",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic,
                        modifier = Modifier
                            .padding(20.dp)
                    )

                    Text(
                        text = "Connection domain : ${result.connection.domain}",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic,
                        modifier = Modifier
                            .padding(20.dp)
                    )

                    Text(
                        text = "Time zone id : ${result.timezone.id}",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic,
                        modifier = Modifier
                            .padding(20.dp)
                    )

                    Text(
                        text = "Time zone abddr : ${result.timezone.abbr}",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic,
                        modifier = Modifier
                            .padding(20.dp)
                    )

                    Text(
                        text = "Time zone is dst : ${result.timezone.is_dst}",
                        color = if (result.timezone.is_dst) Color.Green else Color.Red,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic,
                        modifier = Modifier
                            .padding(20.dp)
                    )

                    Text(
                        text = "Time zone offset : ${result.timezone.offset}",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic,
                        modifier = Modifier
                            .padding(20.dp)
                    )

                    Text(
                        text = "Time zone utc : ${result.timezone.utc}",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic,
                        modifier = Modifier
                            .padding(20.dp)
                    )

                    Text(
                        text = "Time zone current time : ${result.timezone.current_time}",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic,
                        modifier = Modifier
                            .padding(20.dp)
                    )
                }
            }

        }

        if (state.Loading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        }
    }
}