package com.bodakesatish.composetopbars

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

// This annotation is often needed for TopAppBar variations and scroll behaviors.
@OptIn(ExperimentalMaterial3Api::class)
// Defines a Composable function for this screen.
@Composable
fun CenterAlignedTopAppBarDemo(navController: NavController) {
    // LocalContext provides access to the Android Context, used here for showing Toasts.
    val context = LocalContext.current

    val standardScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior() // For Small/Center, often pinned.

    // Scaffold provides the basic Material Design visual layout structure.
    // It has slots for TopAppBar, BottomAppBar, FloatingActionButton, Drawer, and the main content.
    Scaffold(
        modifier = Modifier.nestedScroll(standardScrollBehavior.nestedScrollConnection), // Or NoOp if no scroll behavior needed
        // `topBar` lambda slot expects a Composable that defines the top app bar.
        topBar = {
            CenterAlignedTopAppBarDemo(
                navController = navController,
                context = context,
                scrollBehavior = standardScrollBehavior // Can be null if no scroll interaction desired
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
        Column(
            modifier = Modifier
                .padding(innerPadding) // Apply the padding from Scaffold.
                .fillMaxSize()
                .padding(16.dp), // Additional padding for the content itself.
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // LazyColumn provides a scrollable list of items.
            // This is important to demonstrate how scrollable TopAppBars behave.
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(50) { index ->
                    Text(
                        text = "Scrollable Item #$index",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                    if (index < 49) { // Don't add divider after the last item
                        HorizontalDivider()
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewScaffoldAndTopAppBarExampleScreen() {
    MaterialTheme {
        // Option A: Simplest fake NavController (if you don't interact with it in the preview)
        val fakeNavController = NavController(LocalContext.current)
        // OR if you just need a NavController that doesn't crash and has some basic methods
        // val fakeNavController = remember { NavController(LocalContext.current) }

        CenterAlignedTopAppBarDemo(navController = fakeNavController)
        // Or if simple is enough:
        // StandardTopAppBarDemo(navController = NavController(LocalContext.current))
    }
}