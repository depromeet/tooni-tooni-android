package kr.tooni.tooni.features.watch.recent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.tooni.tooni.R
import kr.tooni.tooni.features.watch.favorites.FavoritesFragment

class RecentFragment : Fragment() {

    companion object {
        fun newInstance(): RecentFragment {
            val args = Bundle()
            val fragment = RecentFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recent, container, false)
    }
}
