package kr.tooni.tooni.features.recommend

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.tooni.tooni.R

class FantasyFragment : Fragment() {

    companion object {
        fun newInstance(): FantasyFragment {
            val args = Bundle()
            val fragment = FantasyFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fantasy, container, false)
    }
}