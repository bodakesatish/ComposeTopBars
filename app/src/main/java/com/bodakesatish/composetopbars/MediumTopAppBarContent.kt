package com.bodakesatish.composetopbars

import android.graphics.drawable.Icon
import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MediumTopAppBarContent(
    navController: NavController,
    context: android.content.Context,
    scrollBehavior: TopAppBarScrollBehavior // Scroll behavior is typically required for Medium/Large.
) {
    // `MediumTopAppBar` has a larger collapsed height and expands further when content is scrolled up.
    // It requires a `scrollBehavior` to work correctly.
    MediumTopAppBar(
        title = { Text("Medium TopAppBar") },
        navigationIcon = {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back")
            }
        },
        actions = {
            IconButton(onClick = {
                Toast.makeText(context, "Favorite Clicked!", Toast.LENGTH_SHORT).show()
            }) {
                Icon(Icons.Filled.Favorite, "Favorite")
            }
        },
        scrollBehavior = scrollBehavior,// This makes the app bar react to scrolling.
        // `colors` can be used to customize background, title, and icon colors.
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun MediumTopAppBarPreview() {
    val context = LocalContext.current
    val fakeNavController = NavController(context)
    val mediumScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    MaterialTheme {
        Surface {
            MediumTopAppBarContent(
                navController = fakeNavController,
                context = context,
                scrollBehavior = mediumScrollBehavior
            )
        }
    }
}