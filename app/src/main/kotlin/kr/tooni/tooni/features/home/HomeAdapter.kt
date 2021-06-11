/*
 * Created by Leo on 2021. 06. 11 ..
 */
package kr.tooni.tooni.features.home

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kr.tooni.tooni.base.BaseViewHolder
import kr.tooni.tooni.base.arch.Bindable
import kr.tooni.tooni.features.home.HomeViewModel.State

class HomeAdapter(
    private val viewModel: HomeViewModel
) : ListAdapter<Bindable, BaseViewHolder<*>>(DIFF_CALLBACK) {
    
    fun submitList(state: State) {
        val bindables = arrayListOf<Bindable>()
        // TODO : convert state to Bindable data
        
        submitList(bindables)
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Bindable> {
        TODO("Not yet implemented")
    }
    
    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val item = getItem(position)
        (holder as BaseViewHolder<Bindable>).bind(item)
    }
    
    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Bindable>() {
            override fun areItemsTheSame(oldItem: Bindable, newItem: Bindable): Boolean {
                return oldItem.viewType == newItem.viewType
            }
            
            override fun areContentsTheSame(oldItem: Bindable, newItem: Bindable): Boolean {
                return oldItem == newItem
            }
        }
    }
}
