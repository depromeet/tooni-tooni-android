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
import kr.tooni.tooni.core.extensions.observeEvent
import kr.tooni.tooni.core.extensions.showSnackbar
import kr.tooni.tooni.databinding.FragmentWebtoonByDayBinding
import timber.log.Timber

class WebtoonByDayFragment :
    BaseFragment<FragmentWebtoonByDayBinding>(R.layout.fragment_webtoon_by_day) {
    
    private val viewModel by viewModels<WebtoonByDayViewModel> {
        WebtoonByDayViewModelFactory(this, arguments)
    }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        viewModel.webtoons.observe(viewLifecycleOwner) {
            Timber.e("--- webtoons: $it")
        }
        
        viewModel.snackBarMessage.observeEvent(viewLifecycleOwner) { message ->
            val anchor = requireActivity().findViewById<View>(R.id.anchor)
            showSnackbar(anchor, message)
        }
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
