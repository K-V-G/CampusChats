package com.example.campuschats.Activity

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import com.example.campuschats.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun profileActivityFunc() {
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
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        )
        {
            Box(
                modifier = Modifier
                    .weight(2.5f)
                    .background(Color(0xffF2F1F5))
            ) {
                Canvas(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(
                            RoundedCornerShape(
                                bottomStartPercent = 15,
                                bottomEndPercent = 15
                            )
                        )
                )
                {
                    drawRect(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color(0xff308CC7), Color(0xff6EADDE)),
                            startY = 0f,
                            endY = size.height
                        )
                    )
                }

            }
            Box(
                modifier = Modifier
                    .background(Color(0xffF2F1F5))
                    .weight(6f)
                    .fillMaxSize()
            ) {

            }
            Box(modifier = Modifier
                .weight(1f)
                .background(Color(0xffF8F8F8))
                .fillMaxSize()
                .drawWithContent {
                    drawContent()
                    drawLine(
                        color = Color(0xffECECEC),
                        start = Offset(0f, 0f),
                        end = Offset(size.width, 0f),
                        strokeWidth = 10f
                    )
                }
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .background(Color(0xffF8F8F8))
                            .fillMaxSize()
                    )
                    {
                        Box(modifier = Modifier
                            .align(Alignment.Center)
                            .clickable {

                            }) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Image(
                                    painter = rememberAsyncImagePainter(R.raw.chats, imageLoader),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(top = 10.dp)
                                        .weight(3f)
                                )
                                Text(
                                    text = "Сообщения",
                                    color = Color(0xffBEBDC0),
                                    fontSize = 10.sp,
                                    fontFamily = ubuntuFontFamily,
                                    modifier = Modifier.weight(1f)
                                )
                            }
                        }
                    }
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .background(Color(0xffF8F8F8))
                            .fillMaxSize()
                    )
                    {
                        Box(modifier = Modifier
                            .align(Alignment.Center)
                            .clickable {

                            }) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Image(
                                    painter = rememberAsyncImagePainter(R.raw.profile, imageLoader),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(top = 10.dp)
                                        .weight(3f)
                                )
                                Text(
                                    text = "Профиль",
                                    color = Color(0xff6EADDE),
                                    fontSize = 10.sp,
                                    fontFamily = ubuntuFontFamily,
                                    modifier = Modifier.weight(1f)
                                )
                            }
                        }
                    }
                }

            }
        }
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier
                .weight(5f).padding(start = 40.dp, end = 40.dp).clip(RoundedCornerShape(30.dp))
        ) {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color(0xffFFFFFF).copy(0.5f))
                .align(Alignment.Center)) {

            }
        }
        Box(modifier = Modifier.weight(0.75f))
        Box(
            modifier = Modifier
                .weight(5f).padding(start = 40.dp, end = 40.dp).clip(RoundedCornerShape(30.dp))
        ) {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color(0xffFFFFFF))
                .align(Alignment.Center)) {

            }
        }
        Box(modifier = Modifier.weight(2f))
    }
}