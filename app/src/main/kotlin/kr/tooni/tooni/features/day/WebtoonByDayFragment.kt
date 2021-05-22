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
import kr.tooni.tooni.R
import kr.tooni.tooni.base.BaseFragment
import kr.tooni.tooni.core.StringKeySet
import kr.tooni.tooni.core.extensions.EMPTY
import kr.tooni.tooni.databinding.FragmentWebtoonByDayBinding

class WebtoonByDayFragment :
    BaseFragment<FragmentWebtoonByDayBinding>(R.layout.fragment_webtoon_by_day) {
    
    private val viewModel by viewModels<WebtoonByDayViewModel>()
    
    private val day: String by lazy {
        arguments?.getString(StringKeySet.DAY) ?: String.EMPTY
    }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        viewModel.getWebtoon(day)
        return binding.root
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
