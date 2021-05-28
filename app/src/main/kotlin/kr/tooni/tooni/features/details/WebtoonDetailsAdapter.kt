/*
 * Created by Leo on 2021. 05. 28 ..
 */
package kr.tooni.tooni.features.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.tooni.tooni.base.BaseViewHolder
import kr.tooni.tooni.base.arch.Bindable
import kr.tooni.tooni.core.model.Comment
import kr.tooni.tooni.core.model.WebtoonDetails
import kr.tooni.tooni.databinding.ItemWebtoonDetailsCommentBinding
import kr.tooni.tooni.databinding.ItemWebtoonDetailsHomeBinding

class WebtoonDetailsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    
    private enum class ViewType(val index: Int) {
        HOME(0),
        COMMENT(1)
    }
    
    private val items = arrayListOf<Bindable>()
    
    fun submitList(details: WebtoonDetails) {
        // TODO : map to Bindable
        items.clear()
        notifyDataSetChanged()
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (ViewType.values()[viewType]) {
            ViewType.HOME -> WebtoonDetailsHomeViewHolder.create(parent)
            ViewType.COMMENT -> WebtoonDetailsCommentViewHolder.create(parent)
        }
    }
    
    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? BaseViewHolder<Bindable>)?.bind(items[position])
    }
    
    override fun getItemCount(): Int {
        return items.size
    }
    
    override fun getItemViewType(position: Int): Int {
        return items[position].viewType
    }
    
    class WebtoonDetailsHomeViewHolder(
        private val binding: ItemWebtoonDetailsHomeBinding
    ) : BaseViewHolder<WebtoonDetailsHomeViewHolder.Data>(binding.root) {
    
        data class Data(val details: WebtoonDetails) : Bindable(ViewType.HOME.index)
    
        override fun bind(data: Data) {
            binding.executePendingBindings()
        }
        
        companion object {
            fun create(parent: ViewGroup): WebtoonDetailsHomeViewHolder {
                return WebtoonDetailsHomeViewHolder(
                    binding = ItemWebtoonDetailsHomeBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }
    
    class WebtoonDetailsCommentViewHolder(
        private val binding: ItemWebtoonDetailsCommentBinding
    ) : BaseViewHolder<WebtoonDetailsCommentViewHolder.Data>(binding.root) {
        
        data class Data(val comments: List<Comment>) : Bindable(ViewType.COMMENT.index)
    
        override fun bind(data: Data) {
            binding.executePendingBindings()
        }
    
        companion object {
            fun create(parent: ViewGroup): WebtoonDetailsCommentViewHolder {
                return WebtoonDetailsCommentViewHolder(
                    binding = ItemWebtoonDetailsCommentBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }
}
