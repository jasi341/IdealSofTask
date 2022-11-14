package com.jasmeet.myapplication_1.models

data class Movies1(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)