package com.mobile.venky.meal.ui.meals.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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


    Scaffold(topBar = {
        ToolbarWidget("Meal Categories", Icons.Default.Home) {
            navController?.navigateUp()
        }
    }) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.LightGray
        ) {
            LazyColumn() {
                items(viewModel.mealsState.value) { meal ->
                    MealCategory(meal = meal) {
                        navController?.navigate("meals_details/${meal.id}")
                    }

                }
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun MealCategoriesScreenPreview() {
    MealsDetailScreen(2, null, null)
}

