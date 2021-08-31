package com.mvproject.base.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.mvproject.base.R
import com.mvproject.base.databinding.ActivityMainBinding
import com.mvproject.base.navigation.NavigationFlow
import com.mvproject.base.navigation.Navigator
import com.mvproject.base.navigation.ToFlowNavigatable
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ToFlowNavigatable {
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var navigator: Navigator
    private val navHostFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    }
    private val navController get() = navHostFragment.navController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navigator.navController = navController
    }

    override fun navigateToFlow(flow: NavigationFlow) {
        navigator.navigateToFlow(flow)
    }
}
