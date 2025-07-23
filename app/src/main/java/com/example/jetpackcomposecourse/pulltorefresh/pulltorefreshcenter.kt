package com.example.jetpackcomposecourse.pulltorefresh // Or your desired package

// --- Essential Imports ---
import androidx.compose.foundation.layout.Box // Required for the defined Indicator
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size // Required for CircularProgressIndicator in Indicator
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator // Required for the defined Indicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme // For colorScheme
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults // Required for Indicator
import androidx.compose.material3.pulltorefresh.PullToRefreshState // Required for Indicator parameter
import androidx.compose.material3.pulltorefresh.pullToRefreshIndicator // Required for Indicator
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color // Required for Indicator parameters
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp // Required for .size() in Indicator

// --- Optional animation imports for Indicator if you add Crossfade ---
// import androidx.compose.animation.Crossfade
// import androidx.compose.animation.core.tween


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PullToRefreshCustomStyleSample(
    items: List<String>,
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier
) {
    val state = rememberPullToRefreshState() // Manages the state of the pull gesture

    PullToRefreshBox(
        isRefreshing = isRefreshing, // True when data is being fetched
        onRefresh = onRefresh,       // Callback when refresh is triggered
        modifier = modifier.fillMaxSize(), // Use the modifier passed, ensure it fills size if intended
        state = state,               // Links this Box to the pull-to-refresh state
        indicator = {
            // Call to your custom Indicator, which is now defined below
            Indicator(
                modifier = Modifier.align(Alignment.TopCenter), // Positions the Indicator's Box
                isRefreshing = isRefreshing,
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                state = state
            )
        },
    ) {
        // Content that users can pull down to refresh
        LazyColumn(Modifier.fillMaxSize()) {
            items(items) { itemText ->
                ListItem({ Text(text = itemText) })
            }
        }
    }
}

/**
 * Custom Indicator for PullToRefresh.
 * This indicator will show a CircularProgressIndicator centered within its bounds.
 * The Modifier.align(Alignment.TopCenter) applied by the caller to this Indicator's instance
 * will position this entire Indicator Box at the top center of the PullToRefreshBox's indicator area.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Indicator(
    state: PullToRefreshState,
    isRefreshing: Boolean,
    modifier: Modifier = Modifier, // This modifier comes from PullToRefreshBox (Modifier.align(Alignment.TopCenter))
    color: Color = MaterialTheme.colorScheme.primary, // Color for the CircularProgressIndicator
    containerColor: Color = MaterialTheme.colorScheme.surfaceVariant // Background for the indicator area
) {
    Box(
        modifier = modifier // This Modifier instance will carry Modifier.align(Alignment.TopCenter)
            .pullToRefreshIndicator( // Connects this Box to the pull-to-refresh mechanics
                state = state,
                isRefreshing = isRefreshing,
                containerColor = containerColor,
                threshold = PullToRefreshDefaults.PositionalThreshold // Default pull distance to trigger
            ),
        contentAlignment = Alignment.Center // This is crucial: centers the CircularProgressIndicator
    ) {
        if (isRefreshing) {
            CircularProgressIndicator(
                modifier = Modifier.size(24.dp), // Example size
                color = color,
                strokeWidth = 2.5.dp // Example stroke width
            )
        }
        // You could use Crossfade here as in previous examples for smoother transitions
        // Crossfade(targetState = isRefreshing, ...) { refreshing -> if (refreshing) { ... } }
    }
}


// --- Preview Functions ---

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, name = "PullToRefresh Centered Indicator")
@Composable
fun PullToRefreshCustomStyleSamplePreview() {
    MaterialTheme {
        PullToRefreshCustomStyleSample(
            items = listOf("Item 1", "Item 2", "Item 3", "Pull down to refresh"),
            isRefreshing = false,
            onRefresh = { /* No-op for preview */ }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, name = "PullToRefresh - Refreshing State")
@Composable
fun PullToRefreshCustomStyleSampleRefreshingPreview() {
    MaterialTheme {
        PullToRefreshCustomStyleSample(
            items = listOf("Item A", "Item B"),
            isRefreshing = true, // Shows the indicator in its refreshing state
            onRefresh = { }
        )
    }
}
