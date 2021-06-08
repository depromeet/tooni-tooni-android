/*
 * Created by Leo on 2021. 06. 06 ..
 */
package kr.tooni.tooni.features.more

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.tooni.tooni.R
import kr.tooni.tooni.base.BaseFragment
import kr.tooni.tooni.databinding.FragmentMoreBinding
import kr.tooni.tooni.features.search.WebtoonSearchActivity

@AndroidEntryPoint
class MoreFragment : BaseFragment<FragmentMoreBinding>(R.layout.fragment_more) {
    
    private val viewModel by viewModels<MoreViewModel>()
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        setupToolbar()
        binding.viewModel = viewModel
        return binding.root
    }
    
    private fun setupToolbar() {
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        val supportActionBar = (activity as AppCompatActivity).supportActionBar
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }
    
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        binding.toolbar.menu.clear()
        binding.toolbar.inflateMenu(R.menu.search)
        
        super.onCreateOptionsMenu(menu, inflater)
    }
    
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_search -> WebtoonSearchActivity.start(requireContext())
        }
        return super.onOptionsItemSelected(item)
    }
    
    companion object {
        fun newInstance(): MoreFragment {
            val args = Bundle()
            return MoreFragment().apply {
                arguments = args
            }
        }
    }
}
