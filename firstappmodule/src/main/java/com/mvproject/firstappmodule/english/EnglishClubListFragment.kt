package com.mvproject.firstappmodule.english

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.mvproject.firstappmodule.TestListAdapter
import com.mvproject.firstappmodule.databinding.ListFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class EnglishClubListFragment : Fragment() {
    private var _binding: ListFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var secondAdapter: com.mvproject.firstappmodule.TestListAdapter
    private val viewModel: EnglishViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.obtainClubs()

        val secondClick = TestListAdapter.OnItemClickListener { club ->
            club?.let {
                Toast.makeText(requireContext(), "clicked - ${it.name}", Toast.LENGTH_LONG).show()
            }
        }
        secondAdapter = TestListAdapter(secondClick)

        with(binding) {
            clublist.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = secondAdapter
            }
        }

        viewModel.dataState.observe(viewLifecycleOwner, {
            if (it.isNotEmpty()) {
                secondAdapter.clubs = it
            } else {
                Timber.d("english clubs is empty")
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
