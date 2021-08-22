package com.mobile.venky.meal.model.repository

import com.mobile.venky.meal.model.api.MealsWebService
import com.mobile.venky.meal.model.response.MealsCategoryResponse

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {

    suspend fun getMeals(): MealsCategoryResponse? {
        return webService.getMeals()
    }


}