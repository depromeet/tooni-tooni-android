package kr.tooni.tooni.features.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.tooni.tooni.base.BaseViewHolder
import kr.tooni.tooni.base.BaseViewModel
import kr.tooni.tooni.base.arch.Bindable
import kr.tooni.tooni.core.model.WebtoonDetails
import kr.tooni.tooni.databinding.ItemHeaderRecentBinding
import kr.tooni.tooni.databinding.ItemRecentKeywordBinding
import kr.tooni.tooni.features.details.WebtoonDetailsAdapter

class WebtoonRecentAdapter : RecyclerView.Adapter<BaseViewHolder<Bindable>>() {

    private enum class ViewType(val index: Int) {
        TYPE_HEADER(0),
        TYPE_ITEM(1)
    }

    private val item = arrayListOf<Bindable>()

    fun submitList(recentEntity: WebtoonRecentEntity) {
        item.clear()
        item += WebtoonRecentAdapter.WebtoonHeaderViewHolder.Data()
        item += WebtoonRecentAdapter.WebtoonSearchItemViewHolder.Data()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Bindable> {
        return when (ViewType.values()[viewType]) {
            ViewType.TYPE_HEADER -> WebtoonHeaderViewHolder.create(parent)
            ViewType.TYPE_ITEM -> WebtoonSearchItemViewHolder.create(parent)
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Bindable>, position: Int) {
        when () {

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