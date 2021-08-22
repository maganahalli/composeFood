package com.mobile.venky.meal.ui.meals.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.mobile.venky.meal.model.response.MealResponse
import com.mobile.venky.meal.ui.meals.views.MealCategoriesScreen
import com.mobile.venky.meal.ui.meals.views.MealsDetailScreen
import com.mobile.venky.meal.viewmodel.MealsCategoriesViewModel

@Composable
fun MealsApplication(viewModel: MealsCategoriesViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "meals_category_list") {
        composable("meals_category_list") {
            MealCategoriesScreen(viewModel,navController)
        }

        composable(
            route = "meals_details/{mealId}",
            arguments = listOf(navArgument("mealId") {
                type = NavType.IntType
            })
        ) { navBackStackENtry ->
            MealsDetailScreen(
                navBackStackENtry.arguments!!.getInt("mealId"),
                navController,
                viewModel
            )
        }
    }

}