package kr.tooni.tooni.features.top20

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import kr.tooni.tooni.R
import kr.tooni.tooni.base.BaseActivity
import kr.tooni.tooni.databinding.ActivityTop20Binding
import kr.tooni.tooni.features.search.WebtoonSearchActivity

@AndroidEntryPoint
class Top20Activity : BaseActivity<ActivityTop20Binding>(R.layout.activity_top20) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_top20)
        setSupportActionBar(binding.toolbarTop20)

        // 뒤로가기 버튼
        binding.btnTop20Back.setOnClickListener {
            finish()
        }
    }

    override fun setSupportActionBar(toolbar: Toolbar?) {
        super.setSupportActionBar(toolbar)
        val supportActionBar = supportActionBar
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    // menu.search를 Toolbar에 적용
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        binding.toolbarTop20.menu.clear()
        binding.toolbarTop20.inflateMenu(R.menu.search)

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
            val intent = Intent(context, Top20Activity::class.java)
            context.startActivity(intent)
        }
    }
}