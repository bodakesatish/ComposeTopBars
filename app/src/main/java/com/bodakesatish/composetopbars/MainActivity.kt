package com.bodakesatish.composetopbars

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.bodakesatish.composetopbars.ui.theme.ComposeTopBarsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTopBarsTheme {
                val fakeNavController = NavController(LocalContext.current)
                CenterAlignedTopAppBarDemo(fakeNavController)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StandardTopAppBarDemoPreview() {
    ComposeTopBarsTheme {
        val fakeNavController = NavController(LocalContext.current)
        StandardTopAppBarDemo(fakeNavController)
    }
}

@Preview(showBackground = true)
@Composable
fun CenterAlignedTopAppBarDemoPreview() {
    ComposeTopBarsTheme {
        val fakeNavController = NavController(LocalContext.current)
        CenterAlignedTopAppBarDemo(fakeNavController)
    }
}

@Preview(showBackground = true)
@Composable
fun MediumTopAppBarDemoPreview() {
    ComposeTopBarsTheme {
        val fakeNavController = NavController(LocalContext.current)
        MediumTopAppBarDemo(fakeNavController)
    }
}

@Preview(showBackground = true)
@Composable
fun LargeTopAppBarDemoPreview() {
    ComposeTopBarsTheme {
        val fakeNavController = NavController(LocalContext.current)
        LargeTopAppBarDemo(fakeNavController)
    }
}