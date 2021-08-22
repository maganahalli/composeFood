package com.mobile.venky.meal.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobile.venky.meal.model.repository.MealsRepository
import com.mobile.venky.meal.model.response.MealResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealsCategoriesViewModel(
    private val repository: MealsRepository = MealsRepository()
) : ViewModel() {


    init {

        viewModelScope.launch(Dispatchers.IO) {
            val meals = getMeals()
            if (meals != null) {
                mealsState.value = meals
            }
        }


    }


    val mealsState: MutableState<List<MealResponse>> = mutableStateOf(emptyList<MealResponse>())

    private suspend fun getMeals(): List<MealResponse>? {
        return repository.getMeals()?.categories
    }
}