package com.example.viewpager_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.layout.Arrangement.End
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.viewpager_compose.ui.theme.ViewpagercomposeTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewpagercomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val listScreen = listOf(
                        "Pagina 1",
                        "Pagina 2",
                        "Pagina 3"

                    )
                    val state = rememberPagerState()
                    val scope = rememberCoroutineScope()
                    Box() {
                        HorizontalPager(pageCount = listScreen.size, state = state) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Center
                            ) {
                                Text(text = "Titulo de la pagina ${it + 1}")
                                Text(text = "lorepm impsum dolor")
                            }
                        }
                        Row(
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .padding(bottom = 10.dp),
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            repeat(listScreen.size) {
                                val color =
                                    if (state.currentPage == it) Color.Black else Color.Black.copy(
                                        alpha = 0.3f
                                    )
                                Box(
                                    modifier = Modifier
                                        .clip(CircleShape)
                                        .size(12.dp)
                                        .background(color)
                                ) {

                                }
                            }
                            if (state.currentPage != listScreen.size - 1){
                                Button(onClick = {
                                    scope.launch {
                                        state.scrollToPage(state.currentPage + 1)
                                    }
                                }, modifier = Modifier.padding(bottom = 10.dp)) {
                                    Text(text = "Next")
                                }
                            }

                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ViewpagercomposeTheme {
        Greeting("Android")
    }
}