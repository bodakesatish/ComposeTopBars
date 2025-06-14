package com.bodakesatish.composetopbars

import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
fun CenterAlignedTopAppBarContent(
    navController: NavController,
    context: android.content.Context,
    scrollBehavior: TopAppBarScrollBehavior?
) {
    // `CenterAlignedTopAppBar` places the title in the center of the app bar.
    CenterAlignedTopAppBar(
        title = { Text("Center-Aligned-Title") },
        navigationIcon = {
            IconButton(onClick = { navController.navigateUp() }) { // Assuming back navigation for simplicity
                Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back")
            }
        },
        actions = {
            IconButton(onClick = { Toast.makeText(context, "Settings Clicked!", Toast.LENGTH_SHORT).show() }) {
                Icon(Icons.Filled.Settings, "Settings")
            }
        },
        scrollBehavior = scrollBehavior
        // Custom colors can be applied here too using TopAppBarDefaults.centerAlignedTopAppBarColors()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun CenterAlignedTopAppBarPreview() {
    val context = LocalContext.current
    val standardScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val fakeNavController = NavController(LocalContext.current)
    MaterialTheme {
        Surface {
            CenterAlignedTopAppBarContent(
                navController = fakeNavController,
                context = context,
                scrollBehavior = standardScrollBehavior
            )
        }
    }
}