package io.github.andraantariksa.meals.ui.main.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import io.github.andraantariksa.meal.core.util.Resource
import io.github.andraantariksa.meals.databinding.CategoriesFragmentBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CategoriesFragment : Fragment() {
    private val categoriesViewModel by viewModels<CategoriesViewModel>()

    private var _binding: CategoriesFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CategoriesFragmentBinding.inflate(inflater, container, false)

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
            categoriesViewModel.category.collectLatest { res ->
                when (res) {
                    is Resource.Error -> {
                    }
                    is Resource.Idle -> throw IllegalStateException()
                    is Resource.Loading -> {
                    }
                    is Resource.Success -> {
                        binding.recyclerViewCategories.adapter = CategoriesAdapter(res.data)
                    }
                }
            }
        }
    }
}