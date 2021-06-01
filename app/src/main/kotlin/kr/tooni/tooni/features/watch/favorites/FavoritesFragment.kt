package kr.tooni.tooni.features.watch.favorites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kr.tooni.tooni.databinding.FragmentFavoritesBinding
import kr.tooni.tooni.features.watch.adapter.FavoritesListAdapter
import kr.tooni.tooni.features.watch.favorites.db.Favorites
import kr.tooni.tooni.features.watch.favorites.db.FavoritesDatabase
import kr.tooni.tooni.features.watch.favorites.db.FavoritesRepository

class FavoritesFragment : Fragment() {

    companion object {
        fun newInstance(): FavoritesFragment {
            val args = Bundle()
            val fragment = FavoritesFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var binding : FragmentFavoritesBinding
    private lateinit var favoritesListViewModel: FavoritesListViewModel
    private lateinit var adapter: FavoritesListAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)

        val dao = FavoritesDatabase.getInstance(this.requireContext()).favoritesDAO
        val repository = FavoritesRepository(dao)
        val factory = FavoritesListViewModelFactory(repository)
        favoritesListViewModel = ViewModelProvider(this, factory).get(FavoritesListViewModel::class.java)
//        favoritesListViewModel.updateFavorites() // 임시 데이터 insert

        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView() {
        binding.rvFavorites.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        adapter = FavoritesListAdapter { selectedItem: Favorites -> heartBtnClicked(selectedItem) }
        binding.rvFavorites.adapter = adapter

        displayFavoritesList()
    }

    private fun displayFavoritesList() {
        favoritesListViewModel.getSavedFavorites().observe(viewLifecycleOwner, { list ->
            binding.rvFavorites.isVisible = list.isNotEmpty()
            binding.tvFavoritesNone.isVisible = list.isEmpty()

            adapter.setList(list)
            adapter.notifyDataSetChanged()
        })
    }

    fun heartBtnClicked(favorites: Favorites) {
        Toast.makeText(context, "${favorites.title} 삭제되었습니다.", Toast.LENGTH_SHORT).show()
        favoritesListViewModel.delete(favorites)
    }

}
