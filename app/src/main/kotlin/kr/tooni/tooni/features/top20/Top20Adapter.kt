package kr.tooni.tooni.features.top20

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.tooni.tooni.R
import kr.tooni.tooni.core.extensions.context
import kr.tooni.tooni.core.model.Site
import kr.tooni.tooni.core.model.Webtoon
import kr.tooni.tooni.databinding.ItemTop20Binding

private const val TAG = "Top20Adapter"

class Top20Adapter(
    private val viewModel: Top20ViewModel
) : ListAdapter<Webtoon, Top20Adapter.Top20Holder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Top20Holder {
        return Top20Holder.create(parent, viewModel)
    }

    override fun onBindViewHolder(holder: Top20Holder, position: Int) {
        val item = getItem(position)
        holder.bind(item, position)
    }

    class Top20Holder(
        private val binding: ItemTop20Binding,
        private val viewModel: Top20ViewModel
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.btnTop20Direction.setOnClickListener {
                Toast.makeText(context, "버튼 클릭", Toast.LENGTH_SHORT).show()
            }
        }

        fun bind(top20Webtoon: Webtoon, position: Int) {
            binding.webtoon = top20Webtoon
            binding.viewModel = viewModel
            binding.executePendingBindings()

            if(top20Webtoon.site.equals(Site.NAVER)) {
                binding.ivTop20Site.setImageResource(R.drawable.icon_platform_naver)
            }
            if(top20Webtoon.site.equals(Site.DAUM)) {
                binding.ivTop20Site.setImageResource(R.drawable.icon_platform_daum)
            }
            if(top20Webtoon.site.equals(Site.KAKAO)) {
                binding.ivTop20Site.setImageResource(R.drawable.icon_platform_kakao)
            }

            binding.tvTop20Ranking.text = (position + 1).toString()
            binding.tvTop20Authors.text = top20Webtoon.authorFullName
            binding.tvTop20Score.text = top20Webtoon.roundedScore
            binding.tvTop20Genres.text = setGenresText(top20Webtoon.genres)
        }

        private fun setGenresText(genres: List<String>): String {
            var genresText = String()

            for(str in genres) {
                genresText += str + " | "
            }

            return genresText.substring(0, genresText.length - 3)
        }

        companion object {
            fun create(
                parent: ViewGroup,
                viewModel: Top20ViewModel
            ) : Top20Holder {
                return Top20Holder(
                    binding = ItemTop20Binding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ),
                    viewModel
                )
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Webtoon>() {
            override fun areItemsTheSame(oldItem: Webtoon, newItem: Webtoon): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Webtoon, newItem: Webtoon): Boolean {
                return oldItem == newItem
            }
        }
    }
}

