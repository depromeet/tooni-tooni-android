package kr.tooni.tooni.features.recommend

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import com.google.android.material.tabs.TabLayoutMediator
import kr.tooni.tooni.R
import kr.tooni.tooni.base.BaseActivity
import kr.tooni.tooni.databinding.ActivityRecommendBinding
import kr.tooni.tooni.features.search.WebtoonSearchActivity

class RecommendActivity : BaseActivity<ActivityRecommendBinding>(R.layout.activity_recommend) {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recommend)
        setSupportActionBar(binding.toolbarRecommend)
        
        // Fragments
        val fragmentList = listOf(
            GenreWebtoonsFragment.newInstance(genre = "일상"),
            GenreWebtoonsFragment.newInstance(genre = "판타지"),
            GenreWebtoonsFragment.newInstance(genre = "액션"),
            GenreWebtoonsFragment.newInstance(genre = "드라마"),
            GenreWebtoonsFragment.newInstance(genre = "순정")
        )
        
        val adapter = RecommendFragmentAdapter(this)
        adapter.fragmentList = fragmentList
        binding.vpRecommend.adapter = adapter
        
        val tabTitles = listOf(" 일상 ", " 판타지 ", " 액션 ", " 드라마 ", " 순정 ")
        TabLayoutMediator(binding.tabRecommend, binding.vpRecommend) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }
    
    override fun setSupportActionBar(toolbar: Toolbar?) {
        super.setSupportActionBar(toolbar)
        val supportActionBar = supportActionBar
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }
    
    // menu.search를 Toolbar에 적용
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        binding.toolbarRecommend.menu.clear()
        binding.toolbarRecommend.inflateMenu(R.menu.search)
        
        return super.onCreateOptionsMenu(menu)
    }
    
    // SearchActivity로 이동
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_search -> WebtoonSearchActivity.start(this)
        }
        return super.onOptionsItemSelected(item)
    }
    
    companion object {
        fun start(context: Context) {
            val intent = Intent(context, RecommendActivity::class.java)
            context.startActivity(intent)
        }
    }
}
