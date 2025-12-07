package com.example.dessertclicker.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.dessertclicker.ui.components.DessertClickerAppBar
import com.example.dessertclicker.ui.components.DessertClickerScreen

@Composable
fun DessertClickerApp(
    uiState: DessertUiState,
    onDessertClicked: () -> Unit
) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            DessertClickerAppBar(
                onShareButtonClicked = {
                    shareSoldDessertsInformation(
                        context,
                        uiState.dessertsSold,
                        uiState.revenue
                    )
                }
            )
        }
    ) { padding ->
        DessertClickerScreen(
            revenue = uiState.revenue,
            dessertsSold = uiState.dessertsSold,
            dessertImageId = uiState.currentDessertImageId,
            onDessertClicked = onDessertClicked,
            modifier = Modifier.padding(padding)
        )
    }
}
