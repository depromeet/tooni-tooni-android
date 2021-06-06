package kr.tooni.tooni.features.watch.favorites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.tooni.tooni.R
import kr.tooni.tooni.core.model.Author
import kr.tooni.tooni.core.model.Site
import kr.tooni.tooni.databinding.ItemFavoritesBinding
import kr.tooni.tooni.features.watch.favorites.db.Favorites

class FavoritesListAdapter(private val clickListener: (Favorites) -> Unit) : RecyclerView.Adapter<Holder>() {

    var favoritesListData = mutableListOf<Favorites>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemFavoritesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(favoritesListData[position], clickListener)
    }

    override fun getItemCount(): Int {
        return favoritesListData.size
    }

    fun setList(favorites: List<Favorites>) {
        favoritesListData.clear()
        favoritesListData.addAll(favorites)
    }

}

class Holder(val binding: ItemFavoritesBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(favorites: Favorites, clickListener: (Favorites) -> Unit) {
        binding.favorites = favorites
        binding.executePendingBindings()

        if(favorites.webtoon.site.equals(Site.NAVER)) {
            binding.ivFavoritesSite.setImageResource(R.drawable.icon_platform_naver)
        }
        if(favorites.webtoon.site.equals(Site.DAUM)) {
            binding.ivFavoritesSite.setImageResource(R.drawable.icon_platform_daum)
        }
        if(favorites.webtoon.site.equals(Site.KAKAO)) {
            binding.ivFavoritesSite.setImageResource(R.drawable.icon_platform_kakao)
        }

        binding.tvFavoritesTitle.text = favorites.webtoon.title
        binding.tvFavoritesAuthors.text = favorites.webtoon.authorFullName
        binding.tvFavoritesGenres.text = setGenresText(favorites.webtoon.genres)
        binding.tvFavoritesScore.text = String.format("%.1f", favorites.webtoon.score)

        binding.btnFavoritesHeart.setOnClickListener {
            clickListener(favorites)
        }
    }

    private fun setGenresText(genres: List<String>): String {
        var genresText = String()

        for(str in genres) {
            genresText += str + " | "
        }

        return genresText.substring(0, genresText.length - 3)
    }
}


