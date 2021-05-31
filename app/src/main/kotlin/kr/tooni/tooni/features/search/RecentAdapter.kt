package kr.tooni.tooni.features.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.tooni.tooni.R
import kr.tooni.tooni.databinding.ItemRecentKeywordBinding

class RecentAdapter : RecyclerView.Adapter<RecentAdapter.ViewHolder>(){
    private var data = mutableListOf<RecentEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecentKeywordBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }


    class ViewHolder(private val binding: ItemRecentKeywordBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(recentEntity: RecentEntity){
            binding.recentEntity = recentEntity
            binding.executePendingBindings()
        }



    }


}