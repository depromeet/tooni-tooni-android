package kr.tooni.tooni.features.search

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kr.tooni.tooni.R
import kr.tooni.tooni.base.BaseActivity
import kr.tooni.tooni.databinding.ActivitySearchBinding

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
        binding.searchImg.setOnClickListener {
            vm.search(binding.searchHint.text.toString())
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
