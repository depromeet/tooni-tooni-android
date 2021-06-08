package kr.tooni.tooni.features.recommend

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.tooni.tooni.R

class RomanceFragment : Fragment() {

    companion object {
        fun newInstance(): RomanceFragment {
            val args = Bundle()
            val fragment = RomanceFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_romance, container, false)
    }
}