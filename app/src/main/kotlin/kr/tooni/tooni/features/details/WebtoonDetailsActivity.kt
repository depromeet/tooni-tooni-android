/*
 * Created by Leo on 2021. 05. 23 ..
 */
package kr.tooni.tooni.features.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
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
        observe()
        binding.viewModel = viewModel
    }
    
    private fun initView() {
        binding.recyclerView.adapter
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
