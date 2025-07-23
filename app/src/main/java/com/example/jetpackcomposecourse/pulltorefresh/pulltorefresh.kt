package com.example.jetpackcomposecourse.pulltorefresh

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material3.pulltorefresh.PullToRefreshBox // Core component for pull-to-refresh
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults // Defaults for indicator behavior
import androidx.compose.material3.pulltorefresh.PullToRefreshState // State object for the indicator
import androidx.compose.material3.pulltorefresh.pullToRefreshIndicator // Modifier for custom indicator
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState // Remembers the indicator's state
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// Main screen composable demonstrating pull-to-refresh
@Composable
fun PulltoRefreshScreen() {

    val scope = rememberCoroutineScope() // Scope for launching the refresh coroutine
    var isRefreshing by remember { mutableStateOf(false) } // State to track if refresh is in progress
    var items by remember { mutableStateOf(List(20) { "item $it" }) } // State for the list of items

    // Function to simulate a refresh operation
    fun refreshItems() {
        scope.launch { // Launch a coroutine for the async refresh
            isRefreshing = true // Set refreshing state to true to show indicator
            delay(2000) // Simulate network delay or data fetching
            items = List(20) { "item #${(0..100).random()}" } // Update items with new "random" data
            isRefreshing = false // Set refreshing state to false to hide indicator
        }
    }

    // Use the custom pull-to-refresh component
    PulltoRefreshCustomIndicatorSample(
        items = items,
        isRefreshing = isRefreshing,
        onRefresh = { refreshItems() } // Pass the refresh function
    )
}

// Composable that encapsulates the PullToRefreshBox with a custom indicator
@OptIn(ExperimentalMaterial3Api::class) // Indicates use of experimental Material 3 APIs
@Composable
fun PulltoRefreshCustomIndicatorSample(
    items: List<String>,       // List of items to display
    isRefreshing: Boolean,     // Whether a refresh is currently active
    onRefresh: () -> Unit,     // Callback to trigger when a refresh is requested
    modifier: Modifier = Modifier
) {
    // Remember the state for the pull-to-refresh indicator,
    // this allows the indicator to respond to pull gestures.
    val state = rememberPullToRefreshState()

    PullToRefreshBox(
        isRefreshing = isRefreshing, // Controls the visibility of the indicator based on refresh status
        onRefresh = onRefresh,         // Function to call when user pulls to refresh
        state = state,                 // The state object that links the gesture to the indicator
        modifier = modifier.fillMaxSize(), // Fill the available screen space
        indicator = {
            // Provide a custom composable for the refresh indicator
            MyCustomIndicator(
                state = state,          // Pass the state to the custom indicator
                isRefreshing = isRefreshing // Pass the refreshing status
            )
        }
    ) {
        // Content that will be scrollable and trigger the pull-to-refresh
        Box(
            modifier = Modifier.fillMaxSize(), // Content box fills the screen
            contentAlignment = Alignment.Center // Center the LazyColumn within this Box
        ) {
            LazyColumn(
                modifier = Modifier, // Modifier for the LazyColumn itself
                horizontalAlignment = Alignment.CenterHorizontally // Center items within the LazyColumn
            ) {
                items(items) { itemText -> // Iterate over the list of items
                    ListItem({ Text(text = itemText) }) // Display each item using ListItem
                }
            }
        }
    }
}

// Custom composable for the pull-to-refresh indicator
@OptIn(ExperimentalMaterial3Api::class) // Indicates use of experimental Material 3 APIs
@Composable
fun MyCustomIndicator(
    state: PullToRefreshState, // The state from PullToRefreshBox
    isRefreshing: Boolean,     // Current refreshing status
    modifier: Modifier = Modifier
) {
    Box(
        // This modifier connects the Box to the pull-to-refresh gesture and state.
        // It handles the positioning and visibility of the indicator based on the pull distance.
        modifier = modifier.pullToRefreshIndicator(
            state = state,
            isRefreshing = isRefreshing,
            containerColor = PullToRefreshDefaults.containerColor, // Default background color
            threshold = PullToRefreshDefaults.PositionalThreshold  // Default pull distance to trigger refresh
        ),
        contentAlignment = Alignment.Center // Center the actual progress indicator within this Box
    ) {
        // Use Crossfade to animate the appearance/disappearance of the progress indicator
        Crossfade(
            targetState = isRefreshing, // Animate based on the isRefreshing state
            animationSpec = tween(durationMillis = 100), // Quick fade animation (was 1000, 100 is quicker)
            modifier = Modifier.align(Alignment.Center) // Align the Crossfade content
        ) { refreshing -> // Content of the Crossfade, 'refreshing' is the targetState value
            if (refreshing) {
                // Show a CircularProgressIndicator when isRefreshing is true
                CircularProgressIndicator(Modifier.size(20.dp))
            }
            // Optionally, you could show something else here when not refreshing,
            // but for a pull-to-refresh indicator, it's common to show nothing.
        }
    }
}

// Preview for Android Studio
@Preview(showSystemUi = true)
@Composable
fun Preview() {
    // Optional: Wrap with your app's theme for more accurate preview
    // YourAppTheme {
    PulltoRefreshScreen()
    // }
}
