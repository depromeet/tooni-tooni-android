package kr.tooni.tooni.features.author

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import kr.tooni.tooni.R
import kr.tooni.tooni.base.BaseActivity
import kr.tooni.tooni.databinding.ActivityAuthorDetailBinding
import kr.tooni.tooni.features.top20.Top20Activity
import kr.tooni.tooni.features.top20.Top20ViewModel

class AuthorDetailActivity : BaseActivity<ActivityAuthorDetailBinding>(R.layout.activity_author_detail) {

    private val viewModel by viewModels<AuthorDetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding.viewModel= viewModel



    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, AuthorDetailActivity::class.java)
            context.startActivity(intent)
        }
    }
}