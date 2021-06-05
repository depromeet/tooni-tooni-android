/*
 * Created by Leo on 2021. 05. 19 ..
 */
package kr.tooni.tooni.features.day

import android.graphics.Typeface
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.forEach
import com.google.android.material.tabs.TabLayout
import kr.tooni.tooni.R
import kr.tooni.tooni.base.BaseFragment
import kr.tooni.tooni.databinding.FragmentWebtoonWeekDayBinding
import kr.tooni.tooni.features.search.WebtoonSearchActivity

class WebtoonWeekDayFragment :
    BaseFragment<FragmentWebtoonWeekDayBinding>(R.layout.fragment_webtoon_week_day) {
    
    private val pagerAdapter by lazy { WebtoonWeekDayFragmentPagerAdapter(this) }
    
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
        binding.viewPager.adapter = pagerAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                tab.view.forEach { childView ->
                    if (childView is TextView) {
                        childView.setTypeface(null, Typeface.BOLD)
                    }
                }
            }
            
            override fun onTabUnselected(tab: TabLayout.Tab) {
                tab.view.forEach { childView ->
                    if (childView is TextView) {
                        childView.setTypeface(null, Typeface.NORMAL)
                    }
                }
            }
            
            override fun onTabReselected(tab: TabLayout.Tab) {
                tab.view.forEach { childView ->
                    if (childView is TextView) {
                        childView.setTypeface(null, Typeface.BOLD)
                    }
                }
            }
        })
        binding.tabLayout.getTabAt(0)?.select()
    }
    
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        binding.toolbar.menu.clear()
        binding.toolbar.inflateMenu(R.menu.search)
        
        super.onCreateOptionsMenu(menu, inflater)
    }
    
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_search -> WebtoonSearchActivity.start(requireContext())
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
