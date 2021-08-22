package com.mobile.venky.meal.ui.meals.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mobile.venky.meal.viewmodel.MealsCategoriesViewModel

@Composable
fun MealsDetailScreen(
    mealId: Int,
    navController: NavHostController?,
    viewModel: MealsCategoriesViewModel?
) {
    val meal = viewModel?.mealsState?.value?.first { meal -> mealId == meal.id }

    Scaffold(topBar = {
        ToolbarWidget("Meal Details", Icons.Default.ArrowBack) {
            navController?.navigateUp()
        }
    }) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.LightGray
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                if (meal != null) {
                    MealPicture(meal.imageUrl, 150.dp)
                    MealContent(meal, Alignment.CenterHorizontally)
                }
            }

        }
    }

}


@Preview(showBackground = true)
@Composable
fun MealsDetailScreenPreview() {
    MealsDetailScreen(2, null, null)
}