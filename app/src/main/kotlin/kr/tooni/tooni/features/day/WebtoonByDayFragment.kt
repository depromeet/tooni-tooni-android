/*
 * Created by Leo on 2021. 05. 19 ..
 */
package kr.tooni.tooni.features.day

import android.os.Bundle
import android.view.*
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import kr.tooni.tooni.R
import kr.tooni.tooni.base.BaseFragment
import kr.tooni.tooni.databinding.FragmentWebtoonByDayBinding
import kr.tooni.tooni.features.search.SearchActivity

class WebtoonByDayFragment :
    BaseFragment<FragmentWebtoonByDayBinding>(R.layout.fragment_webtoon_by_day) {
    
    private val viewModel by viewModels<WebtoonByDayViewModel>()
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        initViewPager()
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        
        return binding.root
    }
    
    private fun initViewPager() {
        val weekDay = resources.getStringArray(R.array.week_day)
        TabLayoutMediator(binding.tabLayout, binding.vpWebtoon) { tab, position ->
            tab.text = weekDay[position]
        }.attach()
    }
    
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_search -> SearchActivity.start(requireContext())
        }
        return super.onOptionsItemSelected(item)
    }
    
    companion object {
    
        fun newInstance(): WebtoonByDayFragment {
            return WebtoonByDayFragment().apply {
                arguments = Bundle()
            }
        }
    }
}
