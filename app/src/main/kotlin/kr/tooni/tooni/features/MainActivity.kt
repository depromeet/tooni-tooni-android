package kr.tooni.tooni.features

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import kr.tooni.tooni.R
import kr.tooni.tooni.base.BaseActivity
import kr.tooni.tooni.databinding.ActivityMainBinding
import kr.tooni.tooni.features.day.DayWebtoonFragment
import kr.tooni.tooni.watch.WatchFragment

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    
    private val viewModel by viewModels<MainViewModel>()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        setInitialTab()
        setBottomNavigationItemSelectedListener()
    }
    
    private fun initView() {
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }
    
    private fun setInitialTab() {
        showPhotoFragment()
    }
    
    private fun setBottomNavigationItemSelectedListener() {
        binding.bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home_1 -> showPhotoFragment()
                R.id.home_2 -> showPhotoFragment()
                R.id.home_3 -> showPhotoFragment()
                R.id.home_4 -> showWatchFragment()
                else -> throw IllegalArgumentException("${menuItem.itemId} is invalid itemId")
            }
        
            return@setOnNavigationItemSelectedListener true
        }
    }
    
    private fun showPhotoFragment() {
        val tag = DayWebtoonFragment::class.java.name
        
        supportFragmentManager.findFragmentByTag(tag)
            ?.let { fragment ->
                showFragment(fragment)
            }
            ?: addFragment(
                fragment = DayWebtoonFragment.newInstance(),
                tag = tag
            )
    }

    private fun showWatchFragment() {
        val tag = WatchFragment::class.java.name

        supportFragmentManager.findFragmentByTag(tag)
            ?.let { fragment ->
                showFragment(fragment)
            }
            ?: addFragment(
                fragment = WatchFragment.newInstance(),
                tag = tag
            )
    }
    
    private fun addFragment(fragment: Fragment, tag: String) =
        supportFragmentManager
            .beginTransaction()
            .hideFragments()
            .add(R.id.container, fragment, tag)
            .commitAllowingStateLoss()
    
    private fun showFragment(fragment: Fragment) =
        supportFragmentManager
            .beginTransaction()
            .hideFragments()
            .show(fragment)
            .commitAllowingStateLoss()
    
    private fun FragmentTransaction.hideFragments(): FragmentTransaction =
        this.apply {
            supportFragmentManager
                .fragments
                .forEach { fragment -> hide(fragment) }
        }
}
