package kr.tooni.tooni.features.search

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
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
    private val beforeAdapter by lazy { WebtoonSearchBeforeAdapter() }
    private val resultAdapter by lazy { WebtoonSearchResultAdapter() }
    private val recentAdapter by lazy { WebtoonRecentAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)







        binding.searchHint.setOnFocusChangeListener { view, focused ->
            if (focused) {
                showKeyboard()
                vm.getAllRecentEntity()
                binding.recentKeywordItem
            } else {
                hideKeyboard()
            }
        }
        vm.randomWebtoons.observe(this) {
            binding.searchRecommend.adapter = beforeAdapter
            binding.searchRecommend.layoutManager = GridLayoutManager(this, 3)
            beforeAdapter.submitList(it)
        }

        vm.keywords.observe(this, {
            binding.recentKeywordItem.adapter = recentAdapter
            binding.recentKeywordItem.layoutManager = LinearLayoutManager(this)
            recentAdapter.submitList(it)
        })

        vm.webtoons.observe(this, {
            binding.searchResult.adapter = resultAdapter
            binding.searchResult.layoutManager = LinearLayoutManager(this)
            resultAdapter.submitList(it)
        })

        binding.searchImg.setOnClickListener {
            vm.search(binding.searchHint.text.toString())
            // 키보드 내려가고 검색 결과 뜸
            hideKeyboard()
            // searchImg는 deleteImg로 바뀜
            binding.searchImg.visibility = View.GONE
            binding.deleteImg.visibility = View.VISIBLE
            // 검색결과에서 forward btn 누르면 이동
        }

        binding.deleteImg.setOnClickListener {
            // 검색하던 editText 사라지고 다시 searchHint 창이 떠야함
            binding.searchHint.setText("")
            // 키보드 올라옴
            showKeyboard()
            // deleteImg -> searchImg로 바뀜
            binding.deleteImg.visibility = View.GONE
            binding.searchImg.visibility = View.VISIBLE
            binding.searchResult.visibility = View.GONE

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
