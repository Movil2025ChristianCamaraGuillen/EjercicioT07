package com.example.dessertclicker.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.dessertclicker.DessertClickerScreen

@Composable
fun DessertClickerApp(
    uiState: DessertUiState,
    onDessertClicked: () -> Unit
) {
    Scaffold(
        topBar = {

        }
    ) { contentPadding ->
        DessertClickerScreen(
            revenue = uiState.revenue,
            dessertsSold = uiState.dessertsSold,
            dessertImageId = uiState.currentDessertImageId,
            onDessertClicked = onDessertClicked,
            modifier = Modifier.padding(contentPadding)
        )
    }
}