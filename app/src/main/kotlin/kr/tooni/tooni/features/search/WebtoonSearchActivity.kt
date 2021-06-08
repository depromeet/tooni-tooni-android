package kr.tooni.tooni.features.search

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kr.tooni.tooni.R
import kr.tooni.tooni.base.BaseActivity
import kr.tooni.tooni.databinding.ActivitySearchBinding
import kr.tooni.tooni.features.MainActivity

@AndroidEntryPoint
class WebtoonSearchActivity : BaseActivity<ActivitySearchBinding>(R.layout.activity_search) {
    
    private val vm by viewModels<WebtoonSearchViewModel>()
    private val imm by lazy { getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val recentAdapter = WebtoonRecentAdapter()
        binding.recentKeywordItem.adapter = recentAdapter
        binding.recentKeywordItem.layoutManager = LinearLayoutManager(this)
        
        val resultAdapter = WebtoonSearchResultAdapter()
        
        binding.searchHint.setOnFocusChangeListener { view, focused ->
            if (focused) {
                showKeyboard()
                vm.getAllRecentEntity()
                binding.recentKeywordItem
            } else {
                hideKeyboard()
            }
        }
        
        vm.webtoons.observe(this, {
            resultAdapter.submitList(it)
        })
        
        vm.keywords.observe(this, {
            recentAdapter.submitList(it)
        })
        
        vm.randomWebtoons.observe(this) { webtoons ->
            // TODO : WebtoonSearchBeforeAdapter 에 submitList 만들고 데이터 설정 하면 됩니다.
        }
        
        binding.searchImg.setOnClickListener {
            vm.search(binding.searchHint.text.toString())
            binding.searchImg.visibility = View.GONE
            binding.deleteImg.visibility = View.VISIBLE
        }
        
        binding.deleteImg.setOnClickListener {
            // 검색창이 사라지고 다시 searchHint 창이 떠야함
            binding.searchImg.visibility = View.VISIBLE
            binding.deleteImg.visibility = View.GONE
        }
        
        binding.backBtn.setOnClickListener {
            MainActivity.start(this)
        }
    }
    
    
    private fun hideKeyboard() {
        imm.hideSoftInputFromWindow(binding.root.windowToken, 0)
    }
    
    private fun showKeyboard() {
        imm.showSoftInput(binding.searchHint, 0)
    }
    
    
    companion object {
        fun start(context: Context) {
            val intent = Intent(context, WebtoonSearchActivity::class.java)
            context.startActivity(intent)
        }
    }
}
