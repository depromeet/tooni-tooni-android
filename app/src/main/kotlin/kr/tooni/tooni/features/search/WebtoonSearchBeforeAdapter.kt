package kr.tooni.tooni.features.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.tooni.tooni.base.BaseViewHolder
import kr.tooni.tooni.base.arch.Bindable
import kr.tooni.tooni.core.model.Webtoon
import kr.tooni.tooni.core.model.Webtoons
import kr.tooni.tooni.databinding.ItemBeforeSearchBinding
import kr.tooni.tooni.databinding.ItemSearchRecommendBinding
import kr.tooni.tooni.databinding.ItemSearchResultBinding

class WebtoonSearchBeforeAdapter(private val viewModel: WebtoonSearchViewModel) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private enum class ViewType(val index: Int) {
        TYPE_ITEM(0)
    }
    private val item = arrayListOf<Bindable>()

    fun submitList(wetoons: List<Webtoon>) {
        item.clear()
        item += wetoons.map { list ->
            SearchBeforeViewHolder.Data(list)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SearchBeforeViewHolder.create(parent, viewModel)
    }
    
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as BaseViewHolder<Bindable>).bind(item[position])
    }
    
    override fun getItemCount(): Int {
        return item.size
    }

    class SearchBeforeViewHolder(
        private val binding: ItemSearchRecommendBinding,
        viewModel: WebtoonSearchViewModel
    ) : BaseViewHolder<SearchBeforeViewHolder.Data>(binding.root) {
        data class Data(val webtoon: Webtoon) : Bindable(ViewType.TYPE_ITEM.index)

        init {
            binding.viewModel = viewModel
        }

        override fun bind(data: SearchBeforeViewHolder.Data) {
            binding.randomWebtoon = data.webtoon
            binding.executePendingBindings()
        }

        companion object {
            fun create(
                parent: ViewGroup,
                viewModel: WebtoonSearchViewModel
            ): WebtoonSearchBeforeAdapter.SearchBeforeViewHolder {
                return WebtoonSearchBeforeAdapter.SearchBeforeViewHolder(
                    binding = ItemSearchRecommendBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ),
                    viewModel = viewModel
                )
            }
        }
    }




}
