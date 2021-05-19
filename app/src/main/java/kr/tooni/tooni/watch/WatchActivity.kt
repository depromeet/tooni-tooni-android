package kr.tooni.tooni.watch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import com.google.android.material.tabs.TabLayoutMediator
import kr.tooni.tooni.R
import kr.tooni.tooni.databinding.ActivityWatchBinding
import kr.tooni.tooni.databinding.FragmentFavoritesBinding
import kr.tooni.tooni.watch.adapter.WatchFragmentAdapter
import kr.tooni.tooni.watch.favorites.FavoritesFragment
import kr.tooni.tooni.watch.recent.RecentFragment

class WatchActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWatchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWatchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Toolbar
        setSupportActionBar(findViewById(R.id.toolbar_watch))

        binding.toolbarWatch.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.item_search -> {
                    Toast.makeText(this,"Search", Toast.LENGTH_SHORT).show()
                    // Handle search icon press
                    true
                }
                else -> false
            }
        }

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

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.watch_app_bar, menu)
        return super.onCreateOptionsMenu(menu)
    }
}