package kr.tooni.tooni.features.top20

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import kr.tooni.tooni.R
import kr.tooni.tooni.base.BaseActivity
import kr.tooni.tooni.databinding.ActivityTop20Binding
import kr.tooni.tooni.features.search.WebtoonSearchActivity

@AndroidEntryPoint
class Top20Activity : BaseActivity<ActivityTop20Binding>(R.layout.activity_top20) {

    private val viewModel by viewModels<Top20ViewModel>()
    private val adapter by lazy { Top20Adapter(viewModel) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_top20)
        setSupportActionBar(binding.toolbarTop20)
        initRecyclerView()
        binding.viewModel = viewModel

        viewModel.webtoons.observe(this) { webtoons ->
            adapter.submitList(webtoons)
        }

        // 뒤로가기 버튼
        binding.btnTop20Back.setOnClickListener {
            finish()
        }
    }

    private fun initRecyclerView() {
        binding.rvTop20.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false)
        binding.rvTop20.adapter = adapter
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