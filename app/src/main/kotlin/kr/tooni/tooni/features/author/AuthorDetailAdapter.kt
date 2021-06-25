package kr.tooni.tooni.features.author

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.tooni.tooni.core.model.Authors
import kr.tooni.tooni.databinding.ActivityAuthorDetailBinding

class AuthorDetailAdapter(
    private val viewModel: AuthorDetailViewModel
): ListAdapter<Authors, AuthorDetailAdapter.AuthorDetailHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AuthorDetailHolder {

    }

    override fun onBindViewHolder(holder: AuthorDetailHolder, position: Int) {
        val item = getItem(position)
    }

    class AuthorDetailHolder(
        private val binding: ActivityAuthorDetailBinding,
        private val viewModel: AuthorDetailViewModel
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            binding.viewModel = viewModel
            binding.executePendingBindings()
        }
    }




}