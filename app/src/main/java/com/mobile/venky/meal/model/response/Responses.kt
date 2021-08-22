package com.mobile.venky.meal.model.response

import com.google.gson.annotations.SerializedName

data class MealsCategoryResponse(val categories: List<MealResponse>)

data class MealResponse(

    @SerializedName("idCategory")
    val id: Int,
    @SerializedName("strCategory")
    val category: String,
    @SerializedName("strCategoryThumb")
    val imageUrl: String,
    @SerializedName("strCategoryDescription")
    val description: String
)