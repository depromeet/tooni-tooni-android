/*
 * Created by Leo on 2021. 06. 11 ..
 */
package kr.tooni.tooni.features.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.tooni.tooni.R
import kr.tooni.tooni.base.BaseFragment
import kr.tooni.tooni.core.extensions.observeEvent
import kr.tooni.tooni.core.extensions.showSnackbar
import kr.tooni.tooni.databinding.FragmentHomeBinding

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    
    private val viewModel by viewModels<HomeViewModel>()
    private val homeAdapter by lazy { HomeAdapter(viewModel) }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        initRecyclerView()
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    
        viewModel.state.observe(viewLifecycleOwner) { state ->
            homeAdapter.submitList(state)
        }
    
        viewModel.snackBarMessage.observeEvent(viewLifecycleOwner) { message ->
            val anchor = requireActivity().findViewById<View>(R.id.anchor)
            showSnackbar(anchor, message)
        }
    }
    
    private fun initRecyclerView() {
        binding.recyclerView.adapter = homeAdapter
    }
    
    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment().apply {
                arguments = bundleOf()
            }
        }
    }
}
