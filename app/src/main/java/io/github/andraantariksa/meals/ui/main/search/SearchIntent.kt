package io.github.andraantariksa.meals.ui.main.search

sealed class SearchIntent {
    class Search(val query: String?) : SearchIntent()
}