package kr.tooni.tooni.features.watch.favorites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kr.tooni.tooni.R
import kr.tooni.tooni.databinding.FragmentFavoritesBinding
import kr.tooni.tooni.features.watch.adapter.FavoritesListAdapter

class FavoritesFragment : Fragment() {

    private lateinit var binding : FragmentFavoritesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)

        val favoritesData = loadFavoritesData()
        val adapter = FavoritesListAdapter()
        adapter.favoritesListData = favoritesData
        binding.rvFavorites.adapter = adapter
        binding.rvFavorites.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)

        return binding.root
    }

    private fun loadFavoritesData() : MutableList<Favorites>{
        val data: MutableList<Favorites> = mutableListOf()

        val favorites = Favorites(0,
            "naver",
            "",
            "급식아빠",
            "김재한",
            "액션",
            9.9,
            100
        )
        data.add(favorites)

        val favorites2 = Favorites(1,
            "naver",
            "",
            "랄랄라랄ㄹ라라",
            "최현정",
            "액션",
            9.9,
            100
        )
        data.add(favorites2)

        return data
    }


}
