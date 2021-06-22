package kr.tooni.tooni.features.search

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.tooni.tooni.base.BaseViewHolder
import kr.tooni.tooni.base.arch.Bindable
import kr.tooni.tooni.databinding.ItemHeaderRecentBinding
import kr.tooni.tooni.databinding.ItemRecentKeywordBinding

class WebtoonRecentAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    
    private enum class ViewType(val index: Int) {
        TYPE_HEADER(0),
        TYPE_ITEM(1)
    }
    
    private val item = arrayListOf<Bindable>()
    
    fun submitList(list: List<WebtoonRecentEntity>) {
        item.clear()
        item += WebtoonHeaderViewHolder.Data("최근 검색어")
        item += list.map { entity ->
            WebtoonSearchItemViewHolder.Data(entity)
        }
        notifyDataSetChanged()
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (ViewType.values()[viewType]) {
            ViewType.TYPE_HEADER -> WebtoonHeaderViewHolder.create(parent)
            ViewType.TYPE_ITEM -> WebtoonSearchItemViewHolder.create(parent)
        }
    }
    
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = item[position]) {
            is WebtoonHeaderViewHolder.Data -> {
                (holder as WebtoonHeaderViewHolder).bind(item)
            }
            is WebtoonSearchItemViewHolder.Data -> {
                (holder as WebtoonSearchItemViewHolder).bind(item)
            }
        }
    }
    
    
    override fun getItemCount(): Int {
        return item.size
    }
    
    override fun getItemViewType(position: Int): Int {
        return item[position].viewType
    }
    
    class WebtoonHeaderViewHolder(private val binding: ItemHeaderRecentBinding) :
        BaseViewHolder<WebtoonHeaderViewHolder.Data>(binding.root) {
        
        data class Data(val title: String) : Bindable(ViewType.TYPE_HEADER.index)
        
        override fun bind(data: WebtoonHeaderViewHolder.Data) {
            binding.recentHeaderText.text = data.title
            binding.executePendingBindings()
        }
        
        companion object {
            fun create(parent: ViewGroup): WebtoonHeaderViewHolder {
                return WebtoonHeaderViewHolder(
                    binding = ItemHeaderRecentBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
        
        
    }
    
    class WebtoonSearchItemViewHolder(private val binding: ItemRecentKeywordBinding) :
        BaseViewHolder<WebtoonSearchItemViewHolder.Data>(binding.root) {
        data class Data(val item: WebtoonRecentEntity) : Bindable(ViewType.TYPE_ITEM.index)
        
        override fun bind(data: Data) {
            binding.recentEntity = data.item
            binding.executePendingBindings()
        }
        
        companion object {
            fun create(parent: ViewGroup): WebtoonSearchItemViewHolder {
                return WebtoonSearchItemViewHolder(
                    binding = ItemRecentKeywordBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
        
    }
    
    
}
