package kr.tooni.tooni.features.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.tooni.tooni.base.BaseViewHolder
import kr.tooni.tooni.base.arch.Bindable
import kr.tooni.tooni.core.model.Webtoon
import kr.tooni.tooni.databinding.ItemSearchResultBinding

class WebtoonSearchResultAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    
    private enum class ViewType(val index: Int) {
        TYPE_ITEM(0)
    }
    
    private val item = arrayListOf<Bindable>()
    
    fun submitList(list: List<Webtoon>) {
        item.clear()
        item += list.map { list ->
            SearchResultViewHolder.Data(list)
        }
        notifyDataSetChanged()
    }
    
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SearchResultViewHolder.create(parent)
    }
    
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as BaseViewHolder<Bindable>).bind(item[position])
    }
    
    override fun getItemCount(): Int {
        return item.size
    }
    
    class SearchResultViewHolder(
        private val binding: ItemSearchResultBinding
    ) : BaseViewHolder<SearchResultViewHolder.Data>(binding.root) {
        
        data class Data(val webtoon: Webtoon) : Bindable(ViewType.TYPE_ITEM.index)
        
        override fun bind(data: Data) {
            binding.searchWebtoon = data.webtoon
            binding.executePendingBindings()
            
            
        }
        
        companion object {
            fun create(parent: ViewGroup): SearchResultViewHolder {
                return SearchResultViewHolder(
                    binding = ItemSearchResultBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
        
    }
    
    
}
