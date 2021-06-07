package kr.tooni.tooni.features.watch.recent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kr.tooni.tooni.databinding.FragmentRecentBinding
import kr.tooni.tooni.features.watch.recent.db.RecentWebtoon
import kr.tooni.tooni.features.watch.recent.db.RecentWebtoonDatabase
import kr.tooni.tooni.features.watch.recent.db.RecentWebtoonRepository

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
    private lateinit var recentWebtoonViewModel: RecentWebtoonViewModel
    private lateinit var adapter: RecentWebtoonAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentRecentBinding.inflate(inflater, container, false)

        val dao = RecentWebtoonDatabase.getInstance(this.requireContext()).recentWebtoonDAO
        val repository = RecentWebtoonRepository(dao)
        val factory = RecentWebtoonViewModelFactory(repository)
        recentWebtoonViewModel = ViewModelProvider(this, factory).get(RecentWebtoonViewModel::class.java)
//        recentWebtoonViewModel.updateRecentWebtoons() // 임시 데이터 insert

        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView() {
        binding.rvRecent.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        adapter = RecentWebtoonAdapter { selectedItem: RecentWebtoon -> deleteBtnClicked(selectedItem) }
        binding.rvRecent.adapter = adapter

        displayRecyclerView()
    }

    private fun displayRecyclerView() {
        recentWebtoonViewModel.getAllRecentWebtoons().observe(
            viewLifecycleOwner, { list ->
                binding.rvRecent.isVisible = list.isNotEmpty()
                binding.tvRecentNone.isVisible = list.isEmpty()
                binding.ivRecentNone.isVisible = list.isEmpty()

                adapter.setList(list)
                adapter.notifyDataSetChanged()
            }
        )
    }

    fun deleteBtnClicked(recentWebtoon: RecentWebtoon) {
        Toast.makeText(context, "${recentWebtoon.webtoon.title} 삭제되었습니다.", Toast.LENGTH_SHORT).show()
        recentWebtoonViewModel.deleteRecentWebtoon(recentWebtoon)
    }

}
