package kr.tooni.tooni.watch.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.tooni.tooni.databinding.ItemFavoritesBinding
import kr.tooni.tooni.watch.favorites.db.Favorites

class FavoritesListAdapter : RecyclerView.Adapter<Holder>() {

    var favoritesListData = mutableListOf<Favorites>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemFavoritesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val favorite = favoritesListData.get(position)
        holder.setFavorites(favorite)
    }

    override fun getItemCount(): Int {
        return favoritesListData.size
    }


}

class Holder(val binding: ItemFavoritesBinding) : RecyclerView.ViewHolder(binding.root){

    fun setFavorites(favorite : Favorites){
        favorite.no = 0
        favorite.platform = "naver"
        binding.tvFavoritesTitle.text = favorite.title
        binding.tvFavoritesWriter.text = favorite.writer
        binding.tvFavoritesGenre.text = favorite.genre

        binding.tvFavoritesRate.text = favorite.rate.toString()

        binding.tvFavoritesCount.text = "(${favorite.count})"
    }
}