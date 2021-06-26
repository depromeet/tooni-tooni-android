package kr.tooni.tooni.features.author

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.tooni.tooni.base.BaseViewHolder
import kr.tooni.tooni.base.arch.Bindable
import kr.tooni.tooni.core.model.Webtoon
import kr.tooni.tooni.databinding.ItemAuthorNameBinding
import kr.tooni.tooni.databinding.ItemHeaderRecentBinding
import kr.tooni.tooni.features.search.WebtoonRecentAdapter

class AuthorDetailAdapter(
    private val viewModel: AuthorDetailViewModel
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private enum class ViewType(val index: Int) {
        TYPE_AUTHOR(0),
        TYPE_GENRE(1),
        TYPE_LIST(2)
    }

    private val items = arrayListOf<Bindable>()

    fun submitList(wetoons: List<Webtoon>) {
        items.clear()
//        items +=
//        items += wetoons.map {
//            it.genres
//        }.distinct()
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AuthorDetailHolder {
        return when (ViewType.values()[viewType]) {
//            ViewType.TYPE_AUTHOR -> AuthorNameViewHolder
//            ViewType.TYPE_GENRE -> AuthorGenreViewHolder
//            else -> AuthorWebtoonListViewHolder
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        ( holder as BaseViewHolder<Bindable>).bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].viewType
    }

    class AuthorNameViewHolder(private val binding : ItemAuthorNameBinding
        ): BaseViewHolder<AuthorNameViewHolder.Data>(binding.root) {

        data class Data(val name: String): Bindable(ViewType.TYPE_AUTHOR.index)

        override fun bind(data: AuthorNameViewHolder.Data) {
            binding.
        }

        companion object {
           fun create(parent: ViewGroup): AuthorNameViewHolder {
               return AuthorNameViewHolder(
                   binding = ItemAuthorNameBinding.inflate(
                       LayoutInflater.from(parent.context),
                       parent,
                       false
                   )
               )
        }
    }


    }

    class AuthorGenreViewHolder() {

    }

    class AuthorWebtoonListViewHolder() {

    }
}

}