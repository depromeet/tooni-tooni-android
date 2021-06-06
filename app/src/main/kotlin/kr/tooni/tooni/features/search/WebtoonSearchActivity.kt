package kr.tooni.tooni.features.search

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kr.tooni.tooni.R
import kr.tooni.tooni.base.BaseActivity
import kr.tooni.tooni.databinding.ActivitySearchBinding

class WebtoonSearchActivity : BaseActivity<ActivitySearchBinding>(R.layout.activity_search) {
    lateinit var mbinding: ActivitySearchBinding
    lateinit var vm: WebtoonSearchViewModel
    var imm: InputMethodManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = DataBindingUtil.setContentView(this, R.layout.activity_search)
        vm = ViewModelProvider(this).get(WebtoonSearchViewModel::class.java)

        mbinding.lifecycleOwner = this

        val recentAdapter = WebtoonRecentAdapter()
        mbinding.recentKeywordItem.adapter = recentAdapter
        mbinding.recentKeywordItem.layoutManager = LinearLayoutManager(this)

        imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?

        binding.searchHint.setOnFocusChangeListener{ view, focused ->

            if(focused) {
                showKeyboard(view)
                binding.recentKeywordItem
            }else{
                //
                hideKeyboard(view)
            }

        }

    }


    fun hideKeyboard(v: View) {
        imm?.hideSoftInputFromWindow(v.windowToken, 0)
    }

    fun showKeyboard(v: View) {
        imm?.showSoftInput(mbinding.searchHint, 0)

    }

    
    companion object {
        
        fun start(context: Context) {
            val intent = Intent(context, WebtoonSearchActivity::class.java)
            context.startActivity(intent)
        }
    }
}
