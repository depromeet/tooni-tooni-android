/*
 * Created by Leo on 2021. 05. 19 ..
 */
package kr.tooni.tooni.features.day

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import kr.tooni.tooni.R
import kr.tooni.tooni.base.BaseFragment
import kr.tooni.tooni.databinding.FragmentWebtoonWeekDayBinding
import kr.tooni.tooni.features.search.SearchActivity

class WebtoonWeekDayFragment :
    BaseFragment<FragmentWebtoonWeekDayBinding>(R.layout.fragment_webtoon_week_day) {
    
    private var mediator: TabLayoutMediator? = null
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        setupToolbar()
        initViewPager()
        return binding.root
    }
    
    private fun setupToolbar() {
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        val supportActionBar = (activity as AppCompatActivity).supportActionBar
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }
    
    private fun initViewPager() {
        val weekDay = resources.getStringArray(R.array.week_day)
        binding.vpWebtoon.adapter = WebtoonFragmentStateAdapter(childFragmentManager, viewLifecycleOwner.lifecycle)
        mediator = TabLayoutMediator(binding.tabLayout, binding.vpWebtoon) { tab, position ->
            tab.text = weekDay[position]
        }
        mediator?.attach()
    }
    
    override fun onDestroyView() {
        mediator?.detach()
        mediator = null
        binding.vpWebtoon.adapter = null
        super.onDestroyView()
    }
    
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        binding.toolbar.menu.clear()
        binding.toolbar.inflateMenu(R.menu.search)
        
        super.onCreateOptionsMenu(menu, inflater)
    }
    
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_search -> SearchActivity.start(requireContext())
        }
        return super.onOptionsItemSelected(item)
    }
    
    companion object {
        
        fun newInstance(): WebtoonWeekDayFragment {
            return WebtoonWeekDayFragment().apply {
                arguments = Bundle()
            }
        }
    }
}
