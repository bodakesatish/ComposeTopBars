package com.bodakesatish.composetopbars

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavController

// 1. Small TopAppBar (default type)
@OptIn(ExperimentalMaterial3Api::class) // Needed for TopAppBar and its scrollBehavior
@Composable
fun StandardTopAppBarDemo(
    navController: NavController,
    context: android.content.Context,
    scrollBehavior: TopAppBarScrollBehavior? // Nullable if the bar should not react to scroll
) {
    // `TopAppBar` is the standard, small top app bar.
    TopAppBar(
        title = {
            Text(
                "Small TopAppBar",
                maxLines = 1, // Ensure title doesn't wrap to multiple lines unexpectedly.
                overflow = TextOverflow.Ellipsis // Add ellipsis if title is too long.
            )
        },
        navigationIcon = { // Icon at the start of the TopAppBar.
            if (navController.previousBackStackEntry != null) {
                // Standard back button pattern.
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            } else {
                // Example: Menu icon if no back navigation is possible.
                IconButton(onClick = { Toast.makeText(context, "Menu Clicked!", Toast.LENGTH_SHORT).show() }) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Menu"
                    )
                }
            }
        },
        actions = { // Composable slot for action items at the end of the TopAppBar.
            IconButton(onClick = { Toast.makeText(context, "Search Clicked!", Toast.LENGTH_SHORT).show() }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search"
                )
            }
            OverflowMenuDemo(context) // Example of an overflow menu.
        },
        scrollBehavior = scrollBehavior, // Connects the TopAppBar's appearance to scroll events.
        // `colors` can be used to customize background, title, and icon colors.
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    )
}

// Helper composable for a simple Overflow Menu in TopAppBar actions.
@Composable
fun OverflowMenuDemo(context: android.content.Context) {
    // State to control the visibility of the DropdownMenu.
    var showMenu by remember { mutableStateOf(false) }

    Box { // Box is used to anchor the DropdownMenu to the IconButton.
        IconButton(onClick = { showMenu = !showMenu }) {
            Icon(
                imageVector = Icons.Filled.MoreVert,
                contentDescription = "More options"
            )
        }
        // `DropdownMenu` provides a list of options that appears when `showMenu` is true.
        DropdownMenu(
            expanded = showMenu,
            onDismissRequest = { showMenu = false } // Called when the menu should be dismissed (e.g., click outside).
        ) {
            // `DropdownMenuItem` represents a single item in the menu.
            DropdownMenuItem(
                text = { Text("Option 1") },
                onClick = {
                    Toast.makeText(context, "Option 1 Selected", Toast.LENGTH_SHORT).show()
                    showMenu = false // Dismiss the menu after selection.
                }
            )
            DropdownMenuItem(
                text = { Text("Option 2") },
                onClick = {
                    Toast.makeText(context, "Option 2 Selected", Toast.LENGTH_SHORT).show()
                    showMenu = false
                }
            )
            HorizontalDivider() // Visually separates menu items.
            DropdownMenuItem(
                text = { Text("About") },
                onClick = {
                    Toast.makeText(context, "About Clicked", Toast.LENGTH_SHORT).show()
                    showMenu = false
                }
            )
        }
    }
}