package io.github.andraantariksa.meals.ui.main.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import io.github.andraantariksa.meal.core.util.Theme
import io.github.andraantariksa.meals.databinding.SettingsFragmentBinding

@AndroidEntryPoint
class SettingsFragment : Fragment() {
    private val settingsViewModel by viewModels<SettingsViewModel>()

    private var _binding: SettingsFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SettingsFragmentBinding.inflate(inflater, container, false)

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
        binding.apply {
            linearLayoutTheme.setOnClickListener {
                val dialog = AlertDialog.Builder(requireContext())
                    .setTitle("Select a theme")
                    .setSingleChoiceItems(
                        arrayOf("Default", "Light", "Dark"),
                        Theme.values().indexOf(settingsViewModel.theme.value)
                    ) { dialog, which ->
                        settingsViewModel.onIntent(SettingsIntent.SetTheme(Theme.values()[which]))
                        dialog.dismiss()
                    }
//                    .setPositiveButton("Select") { dialog, which ->
//
//                    }
                    .setNegativeButton("Cancel", null)
                    .create()
                dialog.show()
            }
        }
    }
}