package com.bodakesatish.composetopbars

import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

// This annotation is often needed for TopAppBar variations and scroll behaviors.
@OptIn(ExperimentalMaterial3Api::class)
// Defines a Composable function for this screen.
@Composable
fun MediumTopAppBarDemo(navController: NavController) {
    // LocalContext provides access to the Android Context, used here for showing Toasts.
    val context = LocalContext.current

    val mediumScrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    // Scaffold provides the basic Material Design visual layout structure.
    // It has slots for TopAppBar, BottomAppBar, FloatingActionButton, Drawer, and the main content.
    Scaffold(
        modifier = Modifier.nestedScroll(mediumScrollBehavior.nestedScrollConnection), // Or NoOp if no scroll behavior needed
        // `topBar` lambda slot expects a Composable that defines the top app bar.
        topBar = {
            MediumTopAppBarContent(
                navController = navController,
                context = context,
                scrollBehavior = mediumScrollBehavior // Can be null if no scroll interaction desired
            )
        },
        // `floatingActionButton` slot for a FAB (optional).
        floatingActionButton = {
            FloatingActionButton(onClick = {
                Toast.makeText(context, "FAB Clicked!", Toast.LENGTH_SHORT).show()
            }) {
                Icon(Icons.Filled.Favorite, contentDescription = "Favorite")
            }
        }
        // Other Scaffold slots like `bottomBar`, `snackbarHost` can also be used.
    ) { innerPadding -> // `innerPadding` contains padding values for the main content area
        // to avoid being obscured by the TopAppBar or other Scaffold elements.

        // Main content of the screen.
        MainAppContent(innerPadding)

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMediumTopAppBarDemo() {
    MaterialTheme {
        // Option A: Simplest fake NavController (if you don't interact with it in the preview)
        val fakeNavController = NavController(LocalContext.current)
        // OR if you just need a NavController that doesn't crash and has some basic methods
        // val fakeNavController = remember { NavController(LocalContext.current) }

        MediumTopAppBarDemo(navController = fakeNavController)
    }
}