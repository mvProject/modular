package com.mvproject.loginmodule

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.mvproject.loginmodule.databinding.ActivityLoginBinding
import com.mvproject.base.navigation.NavigationFlow
import com.mvproject.base.navigation.Navigator
import com.mvproject.base.navigation.ToFlowNavigatable
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : AppCompatActivity(), ToFlowNavigatable {
    private lateinit var binding: ActivityLoginBinding

    @Inject
    lateinit var navigator: Navigator
    private val navHostFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    }
    private val navController get() = navHostFragment.navController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navigator.navController = navController
    }

    override fun navigateToFlow(flow: NavigationFlow) {
        navigator.navigateToFlow(flow)
    }
}
