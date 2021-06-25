package kr.tooni.tooni.features.author

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import kr.tooni.tooni.R
import kr.tooni.tooni.base.BaseActivity
import kr.tooni.tooni.databinding.ActivityAuthorDetailBinding
import kr.tooni.tooni.features.top20.Top20ViewModel

class AuthorDetailActivity : BaseActivity<ActivityAuthorDetailBinding>(R.layout.activity_author_detail) {

    private val vm by viewModels<AuthorDetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding.viewModel= vm


    }
}