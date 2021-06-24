package kr.tooni.tooni.features.search

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kr.tooni.tooni.R
import kr.tooni.tooni.base.BaseActivity
import kr.tooni.tooni.core.extensions.observeEvent
import kr.tooni.tooni.databinding.ActivitySearchBinding
import kr.tooni.tooni.features.MainActivity
import kr.tooni.tooni.features.details.WebtoonDetailsActivity


@AndroidEntryPoint
class WebtoonSearchActivity : BaseActivity<ActivitySearchBinding>(R.layout.activity_search) {

    private val vm by viewModels<WebtoonSearchViewModel>()
    private val imm by lazy { getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager }
    private val beforeAdapter by lazy { WebtoonSearchBeforeAdapter(vm) }
    private val resultAdapter by lazy { WebtoonSearchResultAdapter(vm) }
    private val recentAdapter by lazy { WebtoonRecentAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.recentKeywordItem.adapter = recentAdapter
        binding.recentKeywordItem.layoutManager = LinearLayoutManager(this)

        binding.searchResult.adapter = resultAdapter
        binding.searchResult.layoutManager = LinearLayoutManager(this)

        vm.randomWebtoons.observe(this) {
            binding.searchRecommend.adapter = beforeAdapter
            binding.searchRecommend.layoutManager = GridLayoutManager(this, 3)
            beforeAdapter.submitList(it)
        }

        vm.keywords.observe(this, {
            recentAdapter.submitList(it)
        })

        vm.webtoons.observe(this, {
            if (it.isNotEmpty()) {
                resultAdapter.submitList(it)
            } else {
                binding.searchResult.visibility = View.GONE
                binding.searchNoResult.visibility = View.VISIBLE
            }

        })

        binding.searchHint.setOnFocusChangeListener { v, hasFocus ->
            showKeyboard()
            vm.getAllRecentEntity()
            binding.beforeSearch.visibility = View.GONE
            binding.recentKeywordItem.visibility = View.VISIBLE
        }

        binding.searchImg.setOnClickListener {
            searchEvent()
        }

        binding.deleteImg.setOnClickListener {
            deleteEvent()
        }

        binding.backBtn.setOnClickListener {
            MainActivity.start(this)
        }


        binding.searchRefresh.setOnClickListener {
            vm.random()
        }


        binding.searchHint.setOnEditorActionListener(object : TextView.OnEditorActionListener {
            override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    searchEvent()
                    return true
                }
                return false
            }
        })

        vm.action.observeEvent(this) { action ->
            when (action) {
                is WebtoonSearchViewModel.Action.OnClick -> WebtoonDetailsActivity.start(
                    this,
                    action.id
                )
            }

        }
    }

    private fun hideKeyboard() {
        imm.hideSoftInputFromWindow(binding.root.windowToken, 0)
    }

    private fun showKeyboard() {
        imm.showSoftInput(binding.searchHint, 0)
    }


    private fun searchEvent() {
        vm.search(binding.searchHint.text.toString())
        binding.beforeSearch.visibility = View.GONE
        binding.searchResult.visibility = View.VISIBLE
        hideKeyboard()
        binding.searchImg.visibility = View.GONE
        binding.deleteImg.visibility = View.VISIBLE
    }

    private fun deleteEvent() {
        // 검색하던 editText 사라지고 다시 searchHint 창이 떠야함
        binding.searchHint.setText("")
        // deleteImg -> searchImg로 바뀜
        binding.deleteImg.visibility = View.GONE
        binding.searchImg.visibility = View.VISIBLE
        // 최근검색어 view gone
        binding.recentKeywordItem.visibility = View.GONE
        // 결과 view gone
        binding.searchResult.visibility = View.GONE
        // 추천 view visible
        binding.beforeSearch.visibility = View.VISIBLE
        vm.random()
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, WebtoonSearchActivity::class.java)
            context.startActivity(intent)
        }
    }
}
