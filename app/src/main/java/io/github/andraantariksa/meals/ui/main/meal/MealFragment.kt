package io.github.andraantariksa.meals.ui.main.meal

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
import coil.load
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import dagger.hilt.android.AndroidEntryPoint
import io.github.andraantariksa.meal.core.util.Resource
import io.github.andraantariksa.meals.databinding.MealFragmentBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MealFragment : Fragment() {
    private val mealViewModel by viewModels<MealViewModel>()

    private var _binding: MealFragmentBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<MealFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (mealViewModel.meal.value !is Resource.Success) {
            mealViewModel.onIntent(MealIntent.FetchMeal(args.mealId))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MealFragmentBinding.inflate(inflater, container, false)

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
            mealViewModel.meal.collectLatest { res ->
                when (res) {
                    is Resource.Error -> {
                        binding.apply {
                            lottieAnimationViewLoading.isVisible = false
                            linearLayoutError.isVisible = true
                            constraintLayoutContent.isVisible = false
                        }
                    }
                    is Resource.Idle -> throw IllegalStateException()
                    is Resource.Loading -> {
                        binding.apply {
                            lottieAnimationViewLoading.isVisible = true
                            linearLayoutError.isVisible = false
                            constraintLayoutContent.isVisible = false
                        }
                    }
                    is Resource.Success -> {
                        binding.apply {
                            lottieAnimationViewLoading.isVisible = false
                            linearLayoutError.isVisible = false
                            constraintLayoutContent.isVisible = true
                        }

                        binding.apply {
                            imageView.load(res.data.thumbnail)
                            textViewInstructions.text = res.data.instructions
                            textViewName.text = res.data.name
                            recyclerViewIngrendients.adapter =
                                IngredientsAdapter(res.data.ingredients)
                            res.data.youtubeId?.let { youtubeId ->
                                youtubePlayerView.initialize(object :
                                    AbstractYouTubePlayerListener() {
                                    override fun onReady(youTubePlayer: YouTubePlayer) {
                                        youTubePlayer.cueVideo(youtubeId, 0.0F)
                                    }
                                })
                            }
                        }
                    }
                }
            }
        }
    }
}