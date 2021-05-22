/*
 * Created by Leo on 2021. 05. 19 ..
 */
package kr.tooni.tooni.features.day

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import kr.tooni.tooni.R
import kr.tooni.tooni.base.BaseFragment
import kr.tooni.tooni.databinding.FragmentWebtoonByDayBinding

class WebtoonByDayFragment :
    BaseFragment<FragmentWebtoonByDayBinding>(R.layout.fragment_webtoon_by_day) {
    
    private val viewModel by viewModels<WebtoonByDayViewModel>()
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }
    
    companion object {
    
        fun newInstance(): WebtoonByDayFragment {
            return WebtoonByDayFragment().apply {
                arguments = Bundle()
            }
        }
    }
}
