package com.bodakesatish.composetopbars

import android.content.Context
import android.graphics.drawable.Icon
import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LargeTopAppBarContent(
    navController: NavController,
    context: Context,
    scrollBehavior: TopAppBarScrollBehavior // Scroll behavior is typically required for Medium/Large.
) {
    // `MediumTopAppBar` has a larger collapsed height and expands further when content is scrolled up.
    // It requires a `scrollBehavior` to work correctly.
    LargeTopAppBar(
        title = { Text("Large TopAppBar", maxLines = 2, overflow = TextOverflow.Ellipsis) },
        navigationIcon = {
            IconButton(onClick = {navController.navigateUp()}) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back")
            }
        },
        actions = {
            OverflowMenuDemo(context)

        },
        scrollBehavior = scrollBehavior// This makes the app bar react to scrolling.
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun LargeTopAppBarPreview() {
    val context = LocalContext.current
    val fakeNavController = NavController(context)
    val largeScrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())
    MaterialTheme {
        Surface {
            LargeTopAppBarContent(
                navController = fakeNavController,
                context = context,
                scrollBehavior = largeScrollBehavior
            )
        }
    }
}