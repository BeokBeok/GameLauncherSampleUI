package com.beok.gamelaunchersampleui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberImagePainter
import com.beok.gamelaunchersampleui.ui.theme.GameLauncherSampleUITheme

@ExperimentalComposeUiApi
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
                TopAppBar()
            },
            content = {
                Content()
            }
        )
    }

    @Composable
    private fun Content() {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            RecentGame()
            Advertising()
            NowHotGame()
            InstantGameCategory()
        }
    }

    @Composable
    private fun InstantGameCategory() {
        Text(
            text = "인스턴트 게임 카테고리",
            modifier = Modifier.padding(start = 16.dp)
        )
        repeat(2) {
            Row(
                modifier = Modifier
                    .padding(top = 12.dp)
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .height(100.dp)
            ) {
                GameCategory(
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp),
                    painterResource = painterResource(id = R.drawable.ic_tmp)
                )
                GameCategory(
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp),
                    painterResource = painterResource(id = R.drawable.ic_tmp)
                )
            }
        }
    }

    @Composable
    private fun GameCategory(
        modifier: Modifier = Modifier,
        painterResource: Painter
    ) {
        Card(
            modifier = modifier,
            shape = RoundedCornerShape(4.dp),
            border = BorderStroke(width = 1.dp, color = Color.Black)
        ) {
            Image(
                painter = painterResource,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }
    }

    @Composable
    private fun NowHotGame() {
        MoreText(
            modifier = Modifier
                .padding(top = 16.dp)
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .clickable { },
            text = "지금 뜨는 게임"
        )
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(vertical = 12.dp)
                .padding(start = 16.dp),
            contentPadding = PaddingValues(end = 0.dp)
        ) {
            repeat(5) {
                item {
                    Card(
                        modifier = Modifier
                            .width(350.dp)
                            .fillMaxHeight()
                            .padding(end = 12.dp),
                        shape = RoundedCornerShape(size = 20.dp),
                        elevation = 0.dp,
                        backgroundColor = Color.Red
                    ) {
                        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
                            val (thumbnail, more, icon, title, subtitle) = createRefs()
                            Image(
                                painter = rememberImagePainter(data = "https://frvr.com/i/g/golddigger.jpg"),
                                contentDescription = null,
                                modifier = Modifier
                                    .constrainAs(thumbnail) {
                                        top.linkTo(parent.top)
                                        start.linkTo(parent.start)
                                        end.linkTo(parent.end)
                                    }
                                    .fillMaxWidth()
                                    .height(200.dp),
                                contentScale = ContentScale.FillBounds
                            )
                            Image(
                                imageVector = Icons.Default.MoreVert,
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(top = 8.dp, end = 8.dp)
                                    .constrainAs(more) {
                                        top.linkTo(parent.top)
                                        end.linkTo(parent.end)
                                    }
                                    .clickable { }
                            )
                            Card(
                                modifier = Modifier
                                    .padding(start = 20.dp)
                                    .width(40.dp)
                                    .height(40.dp)
                                    .constrainAs(icon) {
                                        start.linkTo(parent.start)
                                        top.linkTo(thumbnail.bottom)
                                        bottom.linkTo(parent.bottom)
                                    },
                                shape = RoundedCornerShape(size = 4.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_tmp),
                                    contentDescription = null,
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.FillBounds
                                )
                            }
                            Text(
                                text = "Gold Digger FRVR",
                                modifier = Modifier
                                    .padding(start = 20.dp)
                                    .fillMaxWidth()
                                    .constrainAs(title) {
                                        start.linkTo(icon.end)
                                        top.linkTo(icon.top)
                                    },
                                color = Color.White,
                                style = MaterialTheme.typography.body1
                            )
                            Text(
                                text = "SSS",
                                modifier = Modifier
                                    .padding(start = 20.dp)
                                    .fillMaxWidth()
                                    .constrainAs(subtitle) {
                                        start.linkTo(icon.end)
                                        bottom.linkTo(icon.bottom)
                                    },
                                color = Color.White,
                                style = MaterialTheme.typography.body2
                            )
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun Advertising() {
        Divider(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
        )
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .clickable { }
                .padding(vertical = 4.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Card(
                modifier = Modifier.padding(4.dp),
                border = BorderStroke(width = 2.dp, color = Color.Gray),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(
                    text = "이벤트",
                    fontSize = 8.sp,
                    modifier = Modifier.padding(4.dp)
                )
            }
            Text(
                text = "지금 XXX 스토어에서 퀴즈 맞추고 스벅 상품권 받자",
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 4.dp)
            )
        }
        Divider(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
        )
    }

    @Composable
    private fun RecentGame() {
        RecentGameHeader()
        RecentGameContent()
    }

    @Composable
    private fun TopAppBar() {
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
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
        ) {
            MoreText(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(5F)
                    .clickable { },
                text = "최근 게임"
            )
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

    @Composable
    private fun MoreText(modifier: Modifier = Modifier, text: String) {
        Row(modifier = modifier) {
            Text(text = text)
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null
            )
        }
    }
}
