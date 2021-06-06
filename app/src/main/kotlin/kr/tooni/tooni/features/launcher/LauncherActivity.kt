/*
 * Created by Leo on 2021. 06. 06 ..
 */
package kr.tooni.tooni.features.launcher

import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.tooni.tooni.R
import kr.tooni.tooni.base.BaseActivity
import kr.tooni.tooni.core.extensions.showSnackbar
import kr.tooni.tooni.databinding.ActivityLauncherBinding
import kr.tooni.tooni.features.MainActivity
import kr.tooni.tooni.features.launcher.LauncherViewModel.State.Error
import kr.tooni.tooni.features.launcher.LauncherViewModel.State.Success

@AndroidEntryPoint
class LauncherActivity : BaseActivity<ActivityLauncherBinding>(R.layout.activity_launcher) {
    
    private val viewModel by viewModels<LauncherViewModel>()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        observe()
    }
    
    private fun observe() {
        viewModel.state.observe(this) { state ->
            when (state) {
                is Error -> showSnackbar(binding.root, state.errorMessage)
                Success -> handleSuccessState()
            }
        }
    }
    
    private fun handleSuccessState() {
        MainActivity.start(this) {
            finish()
        }
    }
}
