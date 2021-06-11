package kr.tooni.tooni.features.recommend

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kr.tooni.tooni.R
import kr.tooni.tooni.base.BaseFragment
import kr.tooni.tooni.databinding.FragmentWebtoonGenreBinding

@AndroidEntryPoint
class GenreWebtoonsFragment :
    BaseFragment<FragmentWebtoonGenreBinding>(R.layout.fragment_webtoon_genre) {
    
    private val viewModel by viewModels<GenreWebtoonsViewModel>()
    private val adapter by lazy { RecommendWebtoonAdapter(viewModel) }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        initRecyclerView()
        binding.viewModel = viewModel
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        viewModel.webtoons.observe(viewLifecycleOwner) { webtoons ->
             adapter.submitList(webtoons)
        }
    }

    private fun initRecyclerView() {
        binding.rvWebtoons.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        binding.rvWebtoons.adapter = adapter
    }

    override fun onDestroyView() {
        binding.rvWebtoons.adapter = null
        super.onDestroyView()
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
