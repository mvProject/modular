package com.mvproject.moduleskeleton.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mvproject.moduleskeleton.databinding.LoginFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private var _binding: LoginFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LoginFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val user = viewModel.checkUserLogged()

        if (user.isEmpty()) {
            Timber.d("MainActivity currentUserRepository UserLogged - empty")
            binding.buttonLogin.setOnClickListener {
                val pass = binding.passwordField.text.toString()
                if (pass.isNotEmpty()) {
                    viewModel.logUser(pass)
                    nextRoute(pass)
                }
            }
        } else {
            Timber.d("MainActivity currentUserRepository UserLogged - $user")
            nextRoute(user)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun nextRoute(pass: String) {
        Timber.d("MainActivity currentUserRepository UserLogged - $pass")
        when (pass) {
            "111" -> {
                findNavController().navigate(
                    LoginFragmentDirections.actionLoginFragmentToFirstMainFragment()
                )
            }
            "222" -> {
                findNavController().navigate(
                    LoginFragmentDirections.actionLoginFragmentToSecondMainFragment()
                )
            }
            else -> {
                Timber.d("user not logged")
            }
        }
    }
}
