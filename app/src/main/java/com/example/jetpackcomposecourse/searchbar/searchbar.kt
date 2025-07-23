package com.example.jetpackcomposecourse.searchbar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults.InputField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Main screen Composable that hosts the search bar
@Composable
fun SearchScreen() {

    // State for the text field within the search bar.
    val textFieldState = remember { TextFieldState() } // Manages search input text

    // State for holding the list of search results.
    var searchResults by remember { mutableStateOf(listOf<String>()) } // Holds search results

    // Lambda function to be executed when a search is performed.
    val onSearch: (String) -> Unit = { query -> // Search action
        // Simulates fetching search results.
        searchResults = listOf( // Update results based on query
            "result 1 for $query",
            "result 2 for $query",
            "result 3 for $query"
        )
    }

    // Calls the SimpleSearchBar composable, passing the necessary state and callbacks.
    SimpleSearchBar( // Display the search bar UI
        tetextFieldState = textFieldState, // Typo: should be textFieldState
        onSearch = onSearch,
        searchResults = searchResults
    )
}

// Composable function for the SearchBar UI and its behavior.
@OptIn(ExperimentalMaterial3Api::class) // Using experimental Material 3 SearchBar
@Composable
fun SimpleSearchBar(
    tetextFieldState: TextFieldState, // Typo: textFieldState. Manages input text.
    onSearch: (String) -> Unit,       // Callback for when search is triggered.
    searchResults: List<String>,      // List of results to display.
    modifier: Modifier = Modifier     // Optional modifier for customization.
) {
    // State for search results visibility (expanded or collapsed). Persists config changes.
    var expanded by rememberSaveable { mutableStateOf(false) }

    // Container for layout, applies padding and accessibility grouping.
    Box(
        modifier
            .fillMaxSize() // Fill available screen space.
            .padding(16.dp) // Add padding around the search bar.
            .semantics { isTraversalGroup = true } // Group for accessibility traversal.
    ) {
        // Material 3 SearchBar component.
        SearchBar(
            modifier = Modifier
                .align(Alignment.TopCenter) // Position SearchBar at the top center.
                .semantics { isTraversalGroup = true }, // Accessibility for the SearchBar itself.
            inputField = { // Defines the text input area of the SearchBar.
                InputField(
                    query = tetextFieldState.text.toString(), // Current text in search field. Typo: textFieldState.
                    onQueryChange = { newText -> // Called when text changes.
                        tetextFieldState.edit { // Update TextFieldState.
                            replace(0, length, newText) // Replace current text with new text.
                        }
                    },
                    onSearch = { // Called when search action (e.g., enter key) is performed.
                        onSearch(tetextFieldState.text.toString()) // Execute search. Typo: textFieldState.
                        expanded = false // Hide search results.
                    },
                    expanded = expanded, // Link to the expanded state of results.
                    onExpandedChange = { expanded = it }, // Update expanded state.
                    placeholder = { Text("Search") } // Placeholder text.
                )
            },
            expanded = expanded, // Controls visibility of the results area.
            onExpandedChange = { expanded = it } // Update expanded state if SearchBar handles it directly.
        ) {
            // Content displayed when 'expanded' is true (search results area).
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState()) // Make results scrollable.
            ) {
                // Display each search result.
                searchResults.forEach { result ->
                    ListItem(
                        headlineContent = { Text(result) }, // Text of the result.
                        modifier = Modifier
                            .clickable { // Make item selectable.
                                tetextFieldState.edit { // Typo: textFieldState.
                                    replace(0, length, result) // Set search bar text to selected result.
                                }
                                expanded = false // Hide search results.
                            }
                            .fillMaxWidth() // Item takes full width.
                    )
                }
            }
        }
    }
}

// Preview function to display the SearchScreen in Android Studio's design view.
@Preview(showSystemUi = true) // Shows system UI (status bar, etc.) in preview.
@Composable
fun ExamplePreview() {
    SearchScreen() // Preview the main SearchScreen.
}

//https://developer.android.com/develop/ui/compose/components/search-bar
