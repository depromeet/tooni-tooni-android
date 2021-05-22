/*
 * Created by Leo on 2021. 05. 19 ..
 */
package kr.tooni.tooni.features.day

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import kr.tooni.tooni.R
import kr.tooni.tooni.base.BaseFragment
import kr.tooni.tooni.databinding.FragmentWebtoonWeekDayBinding
import kr.tooni.tooni.features.search.SearchActivity

class WebtoonWeekDayFragment :
    BaseFragment<FragmentWebtoonWeekDayBinding>(R.layout.fragment_webtoon_week_day) {
    
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
        binding.viewPager.adapter =
            WebtoonFragmentPagerAdapter(childFragmentManager, requireContext())
        binding.tabLayout.setupWithViewPager(binding.viewPager)
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
