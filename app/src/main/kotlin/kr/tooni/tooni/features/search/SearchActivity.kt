package kr.tooni.tooni.features.search

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import kr.tooni.tooni.R
import kr.tooni.tooni.base.BaseActivity
import kr.tooni.tooni.databinding.ActivitySearchBinding

class SearchActivity: BaseActivity<ActivitySearchBinding>(R.layout.activity_search) {
    lateinit var mbinding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = DataBindingUtil.setContentView(this,R.layout.activity_search)
        mbinding.lifecycleOwner = this
    }

}