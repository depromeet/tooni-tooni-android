/*
 * Created by Leo on 2021. 05. 23 ..
 */
package kr.tooni.tooni.features.details

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.view.forEach
import com.google.android.material.tabs.TabLayout
import kr.tooni.tooni.R
import kr.tooni.tooni.base.BaseActivity
import kr.tooni.tooni.core.StringKeySet
import kr.tooni.tooni.core.extensions.observeEvent
import kr.tooni.tooni.core.extensions.showSnackbar
import kr.tooni.tooni.databinding.ActivityWebtoonDetailsBinding

class WebtoonDetailsActivity :
    BaseActivity<ActivityWebtoonDetailsBinding>(R.layout.activity_webtoon_details) {
    
    private val viewModel by viewModels<WebtoonDetailsViewModel> {
        WebtoonDetailsViewModelFactory(this, intent.extras)
    }
    
    private val adapter by lazy { WebtoonDetailsAdapter() }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initTabLayout()
        observe()
        binding.viewModel = viewModel
    }
    
    private fun initView() {
        binding.recyclerView.adapter = adapter
    }
    
    private fun initTabLayout() = with(binding.tabLayout) {
        val homeTab = newTab().setText(R.string.common_tooni_home)
        val commentTab = newTab().setText(R.string.common_tooni_comment)
        
        addTab(homeTab)
        addTab(commentTab)
        
        addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                tab.view.forEach { childView ->
                    if (childView is TextView) {
                        childView.setTypeface(null, Typeface.BOLD)
                    }
                }
            }
            
            override fun onTabUnselected(tab: TabLayout.Tab) {
                tab.view.forEach { childView ->
                    if (childView is TextView) {
                        childView.setTypeface(null, Typeface.NORMAL)
                    }
                }
            }
            
            override fun onTabReselected(tab: TabLayout.Tab) {
                tab.view.forEach { childView ->
                    if (childView is TextView) {
                        childView.setTypeface(null, Typeface.BOLD)
                    }
                }
            }
        })
        binding.tabLayout.getTabAt(0)?.select()
    }
    
    private fun observe() {
        viewModel.webtoonDetails.observe(this, adapter::submitList)
        
        viewModel.snackBarMessage.observeEvent(this) { message ->
            showSnackbar(binding.root, message)
        }
    }
    
    companion object {
        
        fun start(context: Context, id: Long) {
            val intent = Intent(context, WebtoonDetailsActivity::class.java)
                .putExtra(StringKeySet.ID, id)
            context.startActivity(intent)
        }
    }
}
