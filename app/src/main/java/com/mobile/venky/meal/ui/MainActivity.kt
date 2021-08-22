package com.mobile.venky.meal.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mobile.venky.meal.ui.meals.navigation.MealsApplication
import com.mobile.venky.meal.ui.theme.MealTheme
import com.mobile.venky.meal.viewmodel.MealsCategoriesViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealTheme {
                Text(text = "Hello Compose!!!!!!")
                val viewModel: MealsCategoriesViewModel = viewModel()
                MealsApplication(viewModel)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealTheme {
        //MealCategoriesScreen()
    }
}