package kr.tooni.tooni.features.search

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import kr.tooni.tooni.R
import kr.tooni.tooni.base.BaseActivity
import kr.tooni.tooni.databinding.ActivitySearchBinding

class SearchActivity: BaseActivity<ActivitySearchBinding>(R.layout.activity_search) {
    lateinit var mbinding: ActivitySearchBinding
    var imm: InputMethodManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = DataBindingUtil.setContentView(this,R.layout.activity_search)
        mbinding.lifecycleOwner = this

        val recentAdapter = RecentAdapter()
        mbinding.recentKeywordItem.adapter = recentAdapter
        mbinding.recentKeywordItem.layoutManager = LinearLayoutManager(this)

        imm = getSystemService(android.content.Context.INPUT_METHOD_SERVICE) as InputMethodManager?

//        mbinding.searchHint.setOnClickListener{
//            searchHintOnClick()
//        }
    }

    fun searchHintOnClick() {
        mbinding.searchView1.visibility == View.GONE
        mbinding.searchView2.visibility == View.VISIBLE
    }

    fun hideKeyboard(v: View) {
        if(v!=null) {
            imm?.hideSoftInputFromWindow(v.windowToken, 0 )
        }
    }

    fun showKeyboard(v: View){
        imm?.showSoftInput(mbinding.searchHint,0)
    }
}