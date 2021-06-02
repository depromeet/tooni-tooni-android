package kr.tooni.tooni.features.search

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.tooni.tooni.R

class RecentAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_HEADER = 0
    private val TYPE_ITEM = 1

    private var data: ArrayList<RecentEntity> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_HEADER -> HeaderViewHolder(parent.inflate(R.layout.header_recent))
                else -> ItemViewHolder(parent.inflate(R.layout.item_recent_keyword))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is HeaderViewHolder -> {
                holder.itemView.setOnClickListener{

                }
            }
            else -> {
                val item = data[position -1]

                holder.itemView.apply{

                }
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size + 1
    }

    override fun getItemViewType(position: Int): Int {
        return when(position) {
            0 -> TYPE_HEADER
            else -> TYPE_ITEM
        }
    }

    class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


}