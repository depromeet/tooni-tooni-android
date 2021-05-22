package kr.tooni.tooni.features.watch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.tabs.TabLayoutMediator
import kr.tooni.tooni.R
import kr.tooni.tooni.base.BaseFragment
import kr.tooni.tooni.databinding.FragmentWatchBinding
import kr.tooni.tooni.features.watch.adapter.WatchFragmentAdapter
import kr.tooni.tooni.features.watch.favorites.FavoritesFragment
import kr.tooni.tooni.features.watch.recent.RecentFragment

class WatchFragment : BaseFragment<FragmentWatchBinding>(R.layout.fragment_watch) {

    companion object{
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
        // Fragments
        val fragmentsList = listOf(FavoritesFragment(), RecentFragment())
        val adapter = WatchFragmentAdapter(this)
        adapter.fragmentList = fragmentsList
        binding.vpWatch.adapter = adapter

        val tabTitles = listOf("즐겨찾기", "최근 본 작품")
        TabLayoutMediator(binding.tabWatch, binding.vpWatch){
                tab, position ->
            tab.text = tabTitles[position]
        }.attach()
        return binding.root
    }
}
