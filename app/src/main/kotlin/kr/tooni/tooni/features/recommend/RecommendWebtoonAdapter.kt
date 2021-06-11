package kr.tooni.tooni.features.recommend

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
import kr.tooni.tooni.databinding.ItemRecommendWebtoonBinding

private const val TAG = "RecommendWebtoonAdapter"

class RecommendWebtoonAdapter(
    private val viewModel: GenreWebtoonsViewModel
) : ListAdapter<Webtoon, RecommendWebtoonAdapter.RecommendHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendHolder {
        return RecommendHolder.create(parent, viewModel)
    }

    override fun onBindViewHolder(holder: RecommendHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

//    private val recommendWebtoonList = mutableListOf<Webtoon>()
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendHolder {
//        val layoutInflater = LayoutInflater.from(parent.context)
//        val binding: ItemRecommendWebtoonBinding =
//            DataBindingUtil.inflate(layoutInflater, R.layout.item_recommend_webtoon, parent, false)
//        return RecommendHolder(binding)
//    }
//
//    override fun getItemCount(): Int {
//        return recommendWebtoonList.size
//    }
//
//    override fun onBindViewHolder(holder: RecommendHolder, position: Int) {
//        holder.bind(recommendWebtoonList[position])
//    }
//

    class RecommendHolder(
        private val binding: ItemRecommendWebtoonBinding,
        private val viewModel: GenreWebtoonsViewModel
        ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.btnRecommendArrow.setOnClickListener {
                Toast.makeText(context, "버튼 클릭", Toast.LENGTH_LONG).show()
            }
        }

        fun bind(recommendWebtoon: Webtoon) {
            binding.recommend = recommendWebtoon
            binding.viewModel = viewModel
            binding.executePendingBindings()

            if(recommendWebtoon.site.equals(Site.NAVER)) {
                binding.ivRecommendSite.setImageResource(R.drawable.icon_platform_naver)
            }
            if(recommendWebtoon.site.equals(Site.DAUM)) {
                binding.ivRecommendSite.setImageResource(R.drawable.icon_platform_daum)
            }
            if(recommendWebtoon.site.equals(Site.KAKAO)) {
                binding.ivRecommendSite.setImageResource(R.drawable.icon_platform_kakao)
            }

            binding.tvRecommendTitle.text = recommendWebtoon.title
            binding.tvRecommendAuthors.text = recommendWebtoon.authorFullName
            binding.tvRecommendScore.text = recommendWebtoon.roundedScore
            binding.tvRecommendGenres.text = setGenresText(recommendWebtoon.genres)
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
                viewModel: GenreWebtoonsViewModel
            ): RecommendHolder {
                return RecommendHolder(
                    binding = ItemRecommendWebtoonBinding.inflate(
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

