import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.tooni.tooni.base.BaseViewHolder
import kr.tooni.tooni.base.arch.Bindable
import kr.tooni.tooni.core.model.Webtoon
import kr.tooni.tooni.databinding.ItemAuthorDetailBinding
import kr.tooni.tooni.databinding.ItemAuthorGenreBinding
import kr.tooni.tooni.databinding.ItemAuthorNameBinding

class AuthorDetailAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private enum class ViewType(val index: Int) {
        TYPE_NAME(0),
        TYPE_GENRE(1),
        TYPE_LIST(2)
    }

    fun submitList() {
        item.clear()

    }

    private val item = arrayListOf<Bindable>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (ViewType.values()[viewType]) {
            ViewType.TYPE_NAME -> AuthorNameViewHolder.create(parent)
            ViewType.TYPE_GENRE -> AuthorGenreViewHolder.create(parent)
            else -> AuthorWebtoonListViewHolder.create(parent)

        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = item[position]) {
            is AuthorNameViewHolder.Data -> {
                (holder as AuthorNameViewHolder).bind(item)
            }
            is AuthorGenreViewHolder.Data -> {
                (holder as AuthorGenreViewHolder).bind(item)
            }
            is AuthorWebtoonListViewHolder.Data -> {
                (holder as AuthorWebtoonListViewHolder).bind(item)
            }

        }
    }


    override fun getItemCount(): Int {
        return item.size
    }

    override fun getItemViewType(position: Int): Int {
        return item[position].viewType
    }

    class AuthorNameViewHolder(private val binding: ItemAuthorNameBinding) :
        BaseViewHolder<AuthorNameViewHolder.Data>(binding.root) {

        data class Data(val name: String) : Bindable(ViewType.TYPE_NAME.index)

        override fun bind(data: Data) {
            binding.authorDetailName.text = data.name
            binding.executePendingBindings()
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

    class AuthorGenreViewHolder(private val binding: ItemAuthorGenreBinding) :
        BaseViewHolder<AuthorGenreViewHolder.Data>(binding.root) {

        data class Data(val genre: String) : Bindable(ViewType.TYPE_GENRE.index)

        override fun bind(data: Data) {
            binding.authorDetailTag.text = data.genre
            binding.authorDetailTag2.text = data.genre
            binding.executePendingBindings()
        }

        companion object {
            fun create(parent: ViewGroup): AuthorGenreViewHolder {
                return AuthorGenreViewHolder(
                    binding = ItemAuthorGenreBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }


    }

    class AuthorWebtoonListViewHolder(private val binding: ItemAuthorDetailBinding) :
        BaseViewHolder<AuthorWebtoonListViewHolder.Data>(binding.root) {

        data class Data(val webtoonList: Webtoon) : Bindable(ViewType.TYPE_LIST.index)

        override fun bind(data: Data) {
            TODO("Not yet implemented")
        }

        companion object {

            fun create(parent: ViewGroup): AuthorWebtoonListViewHolder {
                return AuthorWebtoonListViewHolder(
                    binding = ItemAuthorDetailBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

        }
    }
}