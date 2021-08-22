package com.mobile.venky.meal.ui.meals.views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.mobile.venky.meal.model.response.MealResponse
import com.mobile.venky.meal.ui.theme.MealTheme
import com.mobile.venky.meal.viewmodel.MealsCategoriesViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun MealCategoriesScreen(
    viewModel: MealsCategoriesViewModel,
    navController: NavHostController?
) {

    LazyColumn() {
        items(viewModel.mealsState.value) { meal ->
            MealCategory(meal = meal) {
                navController?.navigate("meals_details/${meal.id}")
            }

        }
    }


}

@Preview(showBackground = true)
@Composable
fun MealCategoriesScreenPreview() {
    MealsDetailScreen(2, null, null)
}

