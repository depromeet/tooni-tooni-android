package kr.tooni.tooni

import androidx.activity.viewModels
import kr.tooni.tooni.core.base.BaseActivity
import kr.tooni.tooni.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    
    private val viewModel by viewModels<MainViewModel>()
    
    override fun initView() {
        binding.viewModel = viewModel
    }
}
