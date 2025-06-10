package com.bodakesatish.composetopbars

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainAppContent(innerPadding: PaddingValues) {
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