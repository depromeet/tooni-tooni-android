package kr.tooni.tooni.features.recommend

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.tooni.tooni.R

class DramaFragment : Fragment() {

    companion object {
        fun newInstance(): DramaFragment {
            val args = Bundle()
            val fragment = DramaFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_drama, container, false)
    }
}