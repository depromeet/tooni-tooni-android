package kr.tooni.tooni

import android.os.Bundle
import androidx.activity.viewModels
import kr.tooni.tooni.base.BaseActivity
import kr.tooni.tooni.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    
    private val viewModel by viewModels<MainViewModel>()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        subscribe()
    }
    
    private fun initView() {
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }
    
    private fun subscribe() {
    }
}
