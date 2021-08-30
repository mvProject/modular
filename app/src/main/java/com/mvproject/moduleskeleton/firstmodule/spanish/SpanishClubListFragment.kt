package com.mvproject.moduleskeleton.firstmodule.spanish

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.mvproject.moduleskeleton.databinding.ListFragmentBinding
import com.mvproject.moduleskeleton.firstmodule.TestListAdapter
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class SpanishClubListFragment : Fragment() {
    private var _binding: ListFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var firstAdapter: TestListAdapter
    private val viewModel: SpanishViewModel by viewModels()

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

        val firstClick = TestListAdapter.OnItemClickListener { club ->
            club?.let {
                Toast.makeText(requireContext(), "clicked - ${it.name}", Toast.LENGTH_LONG).show()
            }
        }
        firstAdapter = TestListAdapter(firstClick)

        with(binding) {
            clublist.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = firstAdapter
            }
        }

        viewModel.dataState.observe(viewLifecycleOwner, {
            if (it.isNotEmpty()) {
                firstAdapter.clubs = it
            } else {
                Timber.d("spanish clubs is empty")
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
