package kr.tooni.tooni.features.watch

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import kr.tooni.tooni.R
import kr.tooni.tooni.base.BaseFragment
import kr.tooni.tooni.databinding.FragmentWatchBinding
import kr.tooni.tooni.features.search.SearchActivity
import kr.tooni.tooni.features.watch.adapter.WatchFragmentAdapter
import kr.tooni.tooni.features.watch.favorites.FavoritesFragment
import kr.tooni.tooni.features.watch.recent.RecentFragment

class WatchFragment : BaseFragment<FragmentWatchBinding>(R.layout.fragment_watch) {
    
    companion object {
        fun newInstance(): WatchFragment {
            val args = Bundle()
            
            val fragment = WatchFragment()
            fragment.arguments = args
            return fragment
        }
    }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        setupToolbar()

        // Fragments
        val fragmentsList = listOf(RecentFragment.newInstance(), FavoritesFragment.newInstance())
        val adapter = WatchFragmentAdapter(this)
        adapter.fragmentList = fragmentsList
        binding.vpWatch.adapter = adapter
        
        val tabTitles = listOf(" 최근 본 작품 ", " 즐겨찾기 ")
        TabLayoutMediator(binding.tabWatch, binding.vpWatch) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
        return binding.root
    }

    private fun setupToolbar() {
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarWatch)
        val supportActionBar = (activity as AppCompatActivity).supportActionBar
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    // menu.search를 Toolbar에 적용
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        binding.toolbarWatch.menu.clear()
        binding.toolbarWatch.inflateMenu(R.menu.search)

        super.onCreateOptionsMenu(menu, inflater)
    }

    // SearchActivity로 이동
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_search -> SearchActivity.start(requireContext())
        }
        return super.onOptionsItemSelected(item)
    }
}
