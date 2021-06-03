package kr.tooni.tooni.features.watch.recent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import kr.tooni.tooni.databinding.FragmentRecentBinding
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentRecentBinding.inflate(inflater, container, false)

        val dao = RecentWebtoonDatabase.getInstance(this.requireContext()).recentWebtoonDAO
        val repository = RecentWebtoonRepository(dao)
        val factory = RecentWebtoonViewModelFactory(repository)
        recentWebtoonViewModel = ViewModelProvider(this, factory).get(RecentWebtoonViewModel::class.java)

        return binding.root
    }

}
