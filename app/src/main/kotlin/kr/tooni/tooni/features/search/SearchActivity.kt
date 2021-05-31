package kr.tooni.tooni.features.search

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
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
        mbinding = DataBindingUtil.setContentView(this, R.layout.activity_search)
        mbinding.lifecycleOwner = this

        val recentAdapter = RecentAdapter()
        mbinding.recentKeywordItem.adapter = recentAdapter
        mbinding.recentKeywordItem.layoutManager = LinearLayoutManager(this)

        imm = getSystemService(android.content.Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        
    }


    fun hideKeyboard(v: View) {
        imm?.hideSoftInputFromWindow(v.windowToken, 0 )
        showHide(mbinding.searchView2)
        showHide(mbinding.searchView1)
    }

    fun showKeyboard(v: View){
        imm?.showSoftInput(mbinding.searchHint,0)
        showHide(mbinding.searchView2)
        showHide(mbinding.searchView1)
    }

    fun showHide(view: View) {
        view.visibility = if(view.visibility == View.GONE){
            View.VISIBLE
        } else {
            View.GONE
        }
    }
}