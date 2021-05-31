package kr.tooni.tooni.features.watch.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.tooni.tooni.core.model.Author
import kr.tooni.tooni.databinding.ItemFavoritesBinding
import kr.tooni.tooni.features.watch.favorites.Favorites
import kr.tooni.tooni.generated.callback.OnClickListener
import java.util.concurrent.Flow

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

        binding.tvFavoritesTitle.text = favorites.title
        binding.tvFavoritesAuthors.text = getAuthors(favorites.authors)
        binding.tvFavoritesGenres.text = getGenres(favorites.genres)
        binding.tvFavoritesScore.text = favorites.score.toString()
        binding.btnFavoritesHeart.setOnClickListener {
            clickListener(favorites)
        }
    }

    fun getAuthors(authors: List<Author>): String {
        var authorsList = ""

        for(author in authors) {
            authorsList = authorsList + author.name + " "
        }
        return authorsList
    }

    fun getGenres(genres: List<String>): String {
        var genresList = ""

        for(genre in genres) {
            genresList += genre + " | "
        }

        genresList = genresList.substring(0, genresList.length - 3)

        return genresList
    }
}


