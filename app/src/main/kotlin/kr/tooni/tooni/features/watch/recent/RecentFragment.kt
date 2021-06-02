package kr.tooni.tooni.features.watch.recent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kr.tooni.tooni.core.model.Webtoon
import kr.tooni.tooni.databinding.FragmentRecentBinding
import kr.tooni.tooni.features.watch.recent.db.RecentWebtoon
import kr.tooni.tooni.features.watch.recent.db.RecentWebtoonDAO
import kr.tooni.tooni.features.watch.recent.db.RecentWebtoonDatabase

class RecentFragment : Fragment() {

    companion object {
        fun newInstance(): RecentFragment {
            val args = Bundle()
            val fragment = RecentFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var binding: FragmentRecentBinding
    private lateinit var recentWebtoonDAO: RecentWebtoonDAO

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentRecentBinding.inflate(inflater, container, false)

        val db = Room.databaseBuilder(
            this.requireContext(),
            RecentWebtoonDatabase::class.java,
            "recent_webtoon_database"
        ).build()

        recentWebtoonDAO = db.recentWebtoonDAO()
        testDB()

        return binding.root
    }

    private fun testDB() {
        lifecycleScope.launch(Dispatchers.IO) {
            // Insert
            recentWebtoonDAO.insertRecentWebtoon(RecentWebtoon(0, Webtoon.EMPTY))
            recentWebtoonDAO.insertRecentWebtoon(RecentWebtoon(0, Webtoon.EMPTY))
            recentWebtoonDAO.insertRecentWebtoon(RecentWebtoon(0, Webtoon.EMPTY))

            // Delete
            recentWebtoonDAO.deleteRecentWebtoon(RecentWebtoon(1, Webtoon.EMPTY))
        }
    }
}
