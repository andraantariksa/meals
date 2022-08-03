package io.github.andraantariksa.meals.ui.main

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavGraph
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import io.github.andraantariksa.meals.R
import io.github.andraantariksa.meals.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            binding.fragmentContainerViewMain.getFragment<NavHostFragment>()
        val navController = navHostFragment.navController
        binding.bottomNavigationViewMain.setupWithNavController(navController)
        binding.bottomNavigationViewMain.setOnItemReselectedListener { item ->
            val selectedMenuItemNavGraph = navController.graph.findNode(item.itemId) as NavGraph
            navController.popBackStack(selectedMenuItemNavGraph.startDestinationId, false)
        }

        setupActionBarWithNavController(
            navController,
            AppBarConfiguration(
                setOf(
                    R.id.navigation_home_main,
                    R.id.navigation_search_main,
                    R.id.navigation_settings_main
                )
            )
        )
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = binding.fragmentContainerViewMain.findNavController()
        return navController.popBackStack() || super.onSupportNavigateUp()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}