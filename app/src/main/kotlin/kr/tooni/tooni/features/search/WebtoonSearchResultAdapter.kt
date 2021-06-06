package kr.tooni.tooni.features.search

import android.content.ClipData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.tooni.tooni.base.arch.Bindable
import kr.tooni.tooni.core.model.Webtoon
import kr.tooni.tooni.databinding.ItemSearchResultBinding

class WebtoonSearchResultAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
   
    private val item = arrayListOf<Bindable>()

    fun submitList(list: List<Webtoon>) {
        item.clear()
        item += WebtoonSearchResultAdapter.ViewHolder
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val mbinding: ItemSearchResultBinding = ItemSearchResultBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(mbinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class ViewHolder(binding: ItemSearchResultBinding) : RecyclerView.ViewHolder(binding.root) {
        val binding = binding

        fun bind(viewModel: WebtoonSearchViewModel) {

        }
    }

}