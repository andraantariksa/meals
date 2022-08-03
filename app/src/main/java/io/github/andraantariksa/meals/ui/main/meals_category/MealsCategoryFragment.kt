package io.github.andraantariksa.meals.ui.main.meals_category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import io.github.andraantariksa.meal.core.util.Resource
import io.github.andraantariksa.meals.databinding.MealsCategoryFragmentBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MealsCategoryFragment : Fragment() {
    private val mealsCategoryViewModel by viewModels<MealsCategoryViewModel>()

    private var _binding: MealsCategoryFragmentBinding? = null
    private val binding get() = _binding!!

    private val args: MealsCategoryFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mealsCategoryViewModel.onIntent(MealsCategoryIntent.FetchMeals(args.categoryId))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MealsCategoryFragmentBinding.inflate(inflater, container, false)

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

    private fun setupView() {
        val navController = findNavController()

        lifecycleScope.launch {
            mealsCategoryViewModel.meals.collectLatest { res ->
                when (res) {
                    is Resource.Error -> {
                        binding.apply {
                            lottieAnimationViewLoading.isVisible = false
                            linearLayoutError.isVisible = true
                            recyclerViewMeals.isVisible = false
                        }
                    }
                    is Resource.Idle -> throw IllegalStateException()
                    is Resource.Loading -> {
                        binding.apply {
                            lottieAnimationViewLoading.isVisible = true
                            linearLayoutError.isVisible = false
                            recyclerViewMeals.isVisible = false
                        }
                    }
                    is Resource.Success -> {
                        binding.apply {
                            lottieAnimationViewLoading.isVisible = false
                            linearLayoutError.isVisible = false
                            recyclerViewMeals.isVisible = true
                        }
                        binding.recyclerViewMeals.adapter = MealsCategoryAdapter(res.data) { meal ->
                            navController.navigate(
                                MealsCategoryFragmentDirections.actionNavigationCategoriesToNavigationMeal(
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