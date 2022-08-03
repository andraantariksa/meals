package io.github.andraantariksa.meals.ui.main.meals_category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import io.github.andraantariksa.meals.databinding.MealFragmentBinding
import io.github.andraantariksa.meals.databinding.MealsCategoryFragmentBinding

@AndroidEntryPoint
class MealsCategoryFragment: Fragment() {
    private val categorizedMealsViewModel by viewModels<MealsCategoryViewModel>()

    private var _binding: MealsCategoryFragmentBinding? = null
    private val binding get() = _binding!!

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

    }
}