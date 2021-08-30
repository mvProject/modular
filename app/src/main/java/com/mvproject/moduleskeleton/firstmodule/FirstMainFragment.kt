package com.mvproject.moduleskeleton.firstmodule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mvproject.moduleskeleton.databinding.FirstMainFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstMainFragment : Fragment() {
    private var _binding: FirstMainFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FirstMainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FirstMainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            buttonLogoutFirst.setOnClickListener {
                viewModel.logUser("")
                findNavController().navigate(
                    FirstMainFragmentDirections.actionFirstMainFragmentToLoginFragment()
                )
            }

            buttonEnglish.setOnClickListener {
                findNavController().navigate(
                    FirstMainFragmentDirections.actionFirstMainFragmentToFirstListFragment()
                )
            }

            buttonSpanish.setOnClickListener {
                findNavController().navigate(
                    FirstMainFragmentDirections.actionFirstMainFragmentToSecondListFragment()
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
