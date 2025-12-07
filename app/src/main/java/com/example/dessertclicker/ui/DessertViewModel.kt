package com.example.dessertclicker.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource
import com.example.dessertclicker.model.Dessert

class DessertViewModel : ViewModel() {

    private val desserts = Datasource.dessertList

    var uiState by mutableStateOf(
        DessertUiState(
            currentDessertImageId = desserts[0].imageId,
            currentDessertPrice = desserts[0].price
        )
    )
        private set

    fun onDessertClicked() {
        val newRevenue = uiState.revenue + uiState.currentDessertPrice
        val newDessertsSold = uiState.dessertsSold + 1

        val newDessert = determineDessertToShow(desserts, newDessertsSold)

        uiState = uiState.copy(
            revenue = newRevenue,
            dessertsSold = newDessertsSold,
            currentDessertImageId = newDessert.imageId,
            currentDessertPrice = newDessert.price
        )
    }

    fun determineDessertToShow(
        desserts: List<Dessert>,
        dessertsSold: Int
    ): Dessert {
        var dessertToShow = desserts.first()
        for (dessert in desserts) {
            if (dessertsSold >= dessert.startProductionAmount) {
                dessertToShow = dessert
            } else {
                break
            }
        }

        return dessertToShow
    }

}