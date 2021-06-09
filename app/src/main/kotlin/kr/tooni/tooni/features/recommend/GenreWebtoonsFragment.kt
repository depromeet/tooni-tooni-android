package kr.tooni.tooni.features.recommend

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import kr.tooni.tooni.R
import kr.tooni.tooni.base.BaseFragment

class GenreWebtoonsFragment : BaseFragment<>() {
    
    private val viewModel by viewModels<GenreWebtoonsViewModel>()
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        
        // TODO :  recyclerView 설정
        initRecyclerView()
        
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    
        viewModel.webtoons.observe(viewLifecycleOwner) { webtoons ->
            // adapter.submitList(webtoons)
        }
    }
    
    companion object {
        fun newInstance(genre: String): GenreWebtoonsFragment {
            return GenreWebtoonsFragment().apply {
                arguments = bundleOf(
                    "Genre" to genre
                )
            }
        }
    }
}
