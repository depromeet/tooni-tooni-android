/*
 * Created by Leo on 2021. 05. 22 ..
 */
package kr.tooni.tooni.features.day

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import kr.tooni.tooni.R
import kr.tooni.tooni.base.BaseFragment
import kr.tooni.tooni.core.StringKeySet
import kr.tooni.tooni.core.extensions.observeEvent
import kr.tooni.tooni.core.extensions.showSnackbar
import kr.tooni.tooni.databinding.FragmentWebtoonByDayBinding
import kr.tooni.tooni.utils.ItemGridDecorator

class WebtoonByDayFragment :
    BaseFragment<FragmentWebtoonByDayBinding>(R.layout.fragment_webtoon_by_day) {
    
    private val viewModel by viewModels<WebtoonByDayViewModel> {
        WebtoonByDayViewModelFactory(this, arguments)
    }
    
    private val adapter by lazy { WebtoonByDayAdapter() }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        setupRecyclerView()
        binding.viewModel = viewModel
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        viewModel.webtoons.observe(viewLifecycleOwner, adapter::submitList)
        
        viewModel.snackBarMessage.observeEvent(viewLifecycleOwner) { message ->
            val anchor = requireActivity().findViewById<View>(R.id.anchor)
            showSnackbar(anchor, message)
        }
    }
    
    private fun setupRecyclerView() {
        val layoutManager = binding.recyclerView.layoutManager as GridLayoutManager
        val margin = ItemGridDecorator.Margin.Template.DEFAULT
        
        binding.recyclerView.addItemDecoration(ItemGridDecorator(layoutManager.spanCount, margin))
        binding.recyclerView.adapter = adapter
    }
    
    override fun onDestroyView() {
        binding.recyclerView.adapter = null
        super.onDestroyView()
    }
    
    companion object {
        
        fun newInstance(day: String): WebtoonByDayFragment {
            return WebtoonByDayFragment().apply {
                arguments = bundleOf(
                    StringKeySet.DAY to day
                )
            }
        }
    }
}
