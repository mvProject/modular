package com.mvproject.secondappmoodule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mvproject.navigation.NavigationFlow
import com.mvproject.navigation.ToFlowNavigatable
import com.mvproject.secondappmoodule.databinding.SecondMainFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondMainFragment : Fragment() {
    private var _binding: SecondMainFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SecondMainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SecondMainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonLogoutSecond.setOnClickListener {
            viewModel.logUser("")
            (requireActivity() as ToFlowNavigatable).navigateToFlow(NavigationFlow.LoginFlow)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
