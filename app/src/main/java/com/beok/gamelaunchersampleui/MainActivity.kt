package com.beok.gamelaunchersampleui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.beok.gamelaunchersampleui.ui.theme.GameLauncherSampleUITheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GameLauncherSampleUITheme {
                MainContent()
            }
        }
    }

    @Composable
    fun MainContent() {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "게임 런처") },
                    backgroundColor = Color.Transparent,
                    navigationIcon = {
                        IconButton(onClick = { }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = null
                            )
                        }
                    }
                )
            },
            content = {
                Column(
                    modifier = Modifier.verticalScroll(rememberScrollState())
                ) {
                    RecentGameHeader()
                    RecentGameContent()
                }
            }
        )
    }

    @Composable
    private fun RecentGameContent() {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(vertical = 12.dp)
                .padding(start = 16.dp),
            contentPadding = PaddingValues(end = 0.dp)
        ) {
            repeat(5) {
                item {
                    Card(
                        modifier = Modifier
                            .width(140.dp)
                            .padding(end = 16.dp)
                            .fillMaxHeight(),
                        shape = RoundedCornerShape(20.dp),
                        elevation = 0.dp,
                        backgroundColor = Color.LightGray
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(all = 12.dp)
                        ) {
                            Image(
                                painter = rememberImagePainter(
                                    data = "https://play-lh.googleusercontent.com/DpN3DRIsAyYQB_URf7PEmvgLdse51tM_ddRyL7a0MS2gjfl30cBheFmx8Uc8W9qU6sWT=s180-rw"
                                ),
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(bottom = 4.dp)
                                    .width(72.dp)
                                    .height(72.dp)
                                    .clip(shape = RoundedCornerShape(20.dp))
                            )
                            Text(text = "냥코 대전쟁", color = Color.White)
                            Text(text = "33:19", color = Color.White)
                            Text(text = "1시간 전", color = Color.White)
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun RecentGameHeader() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(5F)
                    .clickable { }
            ) {
                Text(text = "최근 게임")
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null
                )
            }
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1F)
                    .clickable { }
            )
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1F)
                    .clickable { }
            )
        }
    }
}
