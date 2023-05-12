package com.example.campuschats.Activity

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import com.example.campuschats.Navigations.NavigationActions
import com.example.campuschats.R
import com.example.campuschats.ui.theme.CampusChatsTheme

@Composable
fun initialActivityFun(navController: NavHostController) {
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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xffF8F8F8)),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Box(
            modifier = Modifier.padding(top = 40.dp, start = 20.dp, end = 20.dp)
                .width(300.dp)
                .height(119.dp),
            contentAlignment = Alignment.TopCenter
        )
        {
            Image(
                painter = rememberAsyncImagePainter(R.raw.logo_sfu, imageLoader),
                contentDescription = null
            )
        }

        Box(
            modifier = Modifier
                .width(150.dp)
                .height(150.dp)
                .offset(x = 20.dp, y = 0.dp),
            contentAlignment = Alignment.Center
        )
        {
            Image(
                painter = rememberAsyncImagePainter(R.raw.belka, imageLoader),
                contentDescription = null
            )
        }
        Box() {
            Canvas(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(20.dp))
            ) {
                drawRect(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color(0xff6EADDE), Color.White),
                        startY = 0f,
                        endY = size.height
                    )
                )
            }

            Column(modifier = Modifier
                .fillMaxSize()
                .align(Alignment.TopCenter)
                .fillMaxWidth())
            {
                Box(modifier = Modifier
                    .weight(4f)
                    .align(Alignment.CenterHorizontally))
                {
                    Column()
                    {
                        Text(
                            text = "Привет!",
                            color = Color.White,
                            fontSize = 30.sp,
                            fontFamily = ubuntuFontFamily,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .weight(1f)
                                .padding(top = 15.dp)
                        )
                        Text(
                            text = "Все тебя уже заждались",
                            color = Color.White,
                            fontSize = 24.sp,
                            fontFamily = ubuntuFontFamily,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .width(150.dp)
                                .align(Alignment.CenterHorizontally)
                                .weight(2f)
                                .padding(top = 15.dp))
                    }
                }
                Box(modifier = Modifier
                    .weight(4f)
                    .align(Alignment.CenterHorizontally)) {
                    Button(
                        onClick = {
                                navController.navigate(route = NavigationActions.Authorization.route)
                                  },
                        modifier = Modifier
                            .width(205.dp)
                            .height(55.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .align(Alignment.Center),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffE73E10))

                    ) {
                        Text(
                            text = "Начать",
                            color = Color.White,
                            fontSize = 22.sp,
                            fontFamily = ubuntuFontFamily,
                            textAlign = TextAlign.Center
                        )
                    }
                }
                Box(modifier = Modifier
                    .weight(2f)
                    .align(Alignment.CenterHorizontally)) {
                        Text(
                            text = "POWERED BY KWG",
                            color = Color(0xffE73E10),
                            fontSize = 16.sp,
                            fontFamily = bebasFontFamily,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .padding(bottom = 20.dp))
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CampusChatsTheme {
        initialActivityFun(navController = rememberNavController())
    }
}
