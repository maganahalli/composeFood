package com.mobile.venky.meal.model.network

class WebServiceConfig {
    companion object {
        private const val baseUrl = "https://www.themealdb.com/api/json/v1/1/"
        private const val apiKey = "1"
        fun getBaseUrl(): String {
            return baseUrl
        }

        fun getApiKey(): String {
            return apiKey
        }
    }
}