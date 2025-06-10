package com.bodakesatish.composetopbars

import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenterAlignedTopAppBarDemo(
    navController: NavController,
    context: android.content.Context,
    scrollBehavior: TopAppBarScrollBehavior?
) {
    // `CenterAlignedTopAppBar` places the title in the center of the app bar.
    CenterAlignedTopAppBar(
        title = { Text("Center-Aligned") },
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