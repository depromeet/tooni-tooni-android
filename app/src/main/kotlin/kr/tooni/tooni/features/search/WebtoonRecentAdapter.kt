package kr.tooni.tooni.features.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.tooni.tooni.base.BaseViewModel
import kr.tooni.tooni.base.arch.Bindable
import kr.tooni.tooni.databinding.ItemHeaderRecentBinding
import kr.tooni.tooni.databinding.ItemRecentKeywordBinding

class WebtoonRecentAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private enum class ViewType(val index: Int) {
        TYPE_HEADER(0),
        TYPE_ITEM(1)
    }

    private val item = arrayListOf<Bindable>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (ViewType.values()[viewType]) {
            ViewType.TYPE_HEADER -> WebtoonHeaderViewHolder.create(parent)
            ViewType.TYPE_ITEM -> WebtoonSearchItemViewHolder.create(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun getItemViewType(position: Int): Int {
        return item[position].viewType
    }

    class WebtoonHeaderViewHolder(private val binding: ItemHeaderRecentBinding) :
        RecyclerView.ViewHolder(binding.root) {

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
        RecyclerView.ViewHolder(binding.root) {
        data class Data(val item: List<WebtoonRecentEntity>) : Bindable(ViewType.TYPE_ITEM.index)

        override fun bind(data: Data) {
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