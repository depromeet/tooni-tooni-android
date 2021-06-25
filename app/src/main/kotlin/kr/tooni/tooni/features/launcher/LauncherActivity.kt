/*
 * Created by Leo on 2021. 06. 06 ..
 */
package kr.tooni.tooni.features.launcher

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
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
    lateinit var ani: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        ani = AnimationUtils.loadAnimation(this, R.anim.splash_stars)
        binding.ivSplashStar1.startAnimation(ani)
        binding.ivSplashStar2.startAnimation(ani)

        observe()
    }

    private fun observe() {
        viewModel.state.observe(this) { state ->
            when (state) {
                is Error -> showSnackbar(binding.root, state.errorMessage)
                Success -> {
                    if(ani.hasEnded()) {
                        handleSuccessState()
                    } else {
                        aniListener()
                    }
                }
            }
        }
    }

    private fun handleSuccessState() {
        MainActivity.start(this) {
            finish()
        }
    }

    private fun aniListener() {
        ani.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                MainActivity.start(this@LauncherActivity) {
                    finish()
                }
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })
    }
}
