package io.github.andraantariksa.meals.ui.main.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import io.github.andraantariksa.meal.core.util.Resource
import io.github.andraantariksa.meals.databinding.SearchFragmentBinding
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class SearchFragment : Fragment() {
    private val searchViewModel by viewModels<SearchViewModel>()

    private var _binding: SearchFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SearchFragmentBinding.inflate(inflater, container, false)

        setupViewPrecreate()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupViewPrecreate() {
        binding.apply {
            editTextSearchQuery.apply {
                var userIsInteracted = false
                onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
                    userIsInteracted = true
                }
                doOnTextChanged { text, start, before, count ->
                    if (userIsInteracted) {
                        searchViewModel.onIntent(SearchIntent.Search(text?.toString()))
                    }
                }
            }
        }
    }

    private fun setupView() {
        val navController = findNavController()

        lifecycleScope.launchWhenResumed {
            searchViewModel.searchResult.collectLatest { res ->
                when (res) {
                    is Resource.Error -> {
                        binding.apply {
                            lottieAnimationViewLoading.isVisible = false
                            linearLayoutError.isVisible = true
                            recyclerViewSearchResult.isVisible = false
                        }
                    }
                    is Resource.Idle -> {
                        binding.apply {
                            lottieAnimationViewLoading.isVisible = false
                            linearLayoutError.isVisible = false
                            recyclerViewSearchResult.isVisible = false
                        }
                    }
                    is Resource.Loading -> {
                        binding.apply {
                            lottieAnimationViewLoading.isVisible = true
                            linearLayoutError.isVisible = false
                            recyclerViewSearchResult.isVisible = false
                        }
                    }
                    is Resource.Success -> {
                        binding.apply {
                            lottieAnimationViewLoading.isVisible = false
                            linearLayoutError.isVisible = false
                            recyclerViewSearchResult.isVisible = true
                        }
                        binding.recyclerViewSearchResult.adapter =
                            SearchedMealsAdapter(res.data) { meal ->
                                navController.navigate(
                                    SearchFragmentDirections.actionNavigationSearchToNavigationMeal(
                                        meal.id
                                    )
                                )
                            }
                    }
                }
            }
        }
    }
}