package kr.tooni.tooni.features.search

import android.content.Context
import android.content.Intent
import kr.tooni.tooni.R
import kr.tooni.tooni.base.BaseActivity
import kr.tooni.tooni.databinding.ActivitySearchBinding

class SearchActivity: BaseActivity<ActivitySearchBinding>(R.layout.activity_search) {

    companion object {
        
        fun start(context: Context) {
            val intent = Intent(context, SearchActivity::class.java)
            context.startActivity(intent)
        }
    }
}
