package com.example.campuschats.Activity

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import com.example.campuschats.R

@Composable
fun authorizationActivityFun() {
    val bebasFontFamily = FontFamily(
        Font(R.font.bebas_neue_regular)
    )
    val ubuntuFontFamily = FontFamily(
        Font(R.font.ubuntu_regular)
    )
    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .components {
            add(SvgDecoder.Factory())
        }
        .build()

     var login = remember { mutableStateOf("") }
    var passwordState = remember { mutableStateOf("") }
    val context = LocalContext.current


    Column(
        modifier = Modifier
            .padding(0.dp)
            .fillMaxSize()
            .background(Color(0xFFFFFFFF)),
    ) {
        Box(modifier = Modifier
            .weight(2f)
            .fillMaxSize()
            .padding(20.dp)
            .offset(x = 15.dp, y = 10.dp),
        contentAlignment = Alignment.BottomCenter) {
            Image(
                painter = rememberAsyncImagePainter(R.raw.belka, imageLoader),
                contentDescription = null,
            )
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .align(Alignment.CenterHorizontally)
        ) {
                Text(text = "Итак, давай узнаем кто ты",
                    color = Color.Black,
                    fontSize = 22.sp,
                    fontFamily = ubuntuFontFamily,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(150.dp)
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 20.dp))
        }
        Box(
            modifier = Modifier
                .weight(7f)
                .fillMaxSize()
                .align(Alignment.CenterHorizontally)
                .background(
                    Color(0xFF65BAFC), RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp,
                        bottomEnd = 0.dp,
                        bottomStart = 0.dp
                    )
                )
        ) {
            Column(modifier = Modifier.align(Alignment.TopCenter))
            {
                Column(modifier = Modifier.align(Alignment.CenterHorizontally)) 
                {
                    TextField(
                        value = login.value,
                        onValueChange = { login.value = it },
                        label = { Text(text = "Логин") },
                        modifier = Modifier.padding(top = 50.dp)
                    )
                    PasswordTextField(passwordState = passwordState, label = "Пароль")

                    Box(
                        modifier = Modifier
                            .align(Alignment.End)
                            .padding(end = 16.dp, bottom = 16.dp)
                    )
                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .width(150.dp)
                                .height(45.dp)
                                .clip(RoundedCornerShape(20.dp))
                                .align(Alignment.End),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color(0xffE73E10)
                            )
                        ) {
                            Text(text = "Войти",
                                color = Color.White,
                                fontSize = 22.sp,
                                fontFamily = ubuntuFontFamily,
                                textAlign = TextAlign.Center)
                        }
                    Box(modifier = Modifier.align(Alignment.End).padding(top = 5.dp)){
                        Text(
                            text = "Забыли пароль?",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontFamily = ubuntuFontFamily,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.clickable(onClick = {
                                val uri = Uri.parse("https://users.sfu-kras.ru/?page=no_passw")
                                val intent = Intent(Intent.ACTION_VIEW, uri)
                                context.startActivity(intent)})
                        )
                    }
                    }
                }
            }
        }
    }
@Composable
fun PasswordTextField(
    passwordState: MutableState<String>,
    label: String,
    modifier: Modifier = Modifier
) {
    val passwordVisibility = remember { mutableStateOf(true) }
    TextField(
        value = passwordState.value,
        onValueChange = { passwordState.value = it },
        label = { Text(label) },
        trailingIcon = {
            val visibilityIcon = if (passwordVisibility.value) Icons.Filled.VisibilityOff
            else Icons.Filled.Visibility
            IconButton(onClick = { passwordVisibility.value = !passwordVisibility.value }) {
                Icon(
                    imageVector = visibilityIcon,
                    contentDescription = if (passwordVisibility.value) "Hide password" else "Show password"
                )
            }
        },
        visualTransformation = if (passwordVisibility.value) PasswordVisualTransformation()
        else VisualTransformation.None,
        modifier = modifier.padding(top = 30.dp)
    )
}