/*
 * Created by Leo on 2021. 05. 23 ..
 */
package kr.tooni.tooni.features.day

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.tooni.tooni.core.model.Webtoon
import kr.tooni.tooni.databinding.ItemWebtoonBinding
import kr.tooni.tooni.utils.SiteLogoProvider

class WebtoonByDayAdapter :
    ListAdapter<Webtoon, WebtoonByDayAdapter.WebtoonByDayViewHolder>(DIFF_CALLBACK) {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WebtoonByDayViewHolder {
        return WebtoonByDayViewHolder.create(parent)
    }
    
    override fun onBindViewHolder(holder: WebtoonByDayViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
    
    class WebtoonByDayViewHolder(
        private val binding: ItemWebtoonBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        
        fun bind(webtoon: Webtoon) {
            binding.webtoon = webtoon
            binding.logoResId = SiteLogoProvider.getId(webtoon)
            binding.executePendingBindings()
        }
        
        companion object {
            fun create(parent: ViewGroup): WebtoonByDayViewHolder {
                return WebtoonByDayViewHolder(
                    binding = ItemWebtoonBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }
    
    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Webtoon>() {
            override fun areItemsTheSame(oldItem: Webtoon, newItem: Webtoon): Boolean {
                return oldItem.id == newItem.id
            }
            
            override fun areContentsTheSame(oldItem: Webtoon, newItem: Webtoon): Boolean {
                return oldItem == newItem
            }
        }
    }
}
