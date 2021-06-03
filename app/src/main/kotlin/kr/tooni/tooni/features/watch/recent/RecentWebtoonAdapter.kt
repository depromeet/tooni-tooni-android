package kr.tooni.tooni.features.watch.recent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import kr.tooni.tooni.R
import kr.tooni.tooni.databinding.ItemRecentWebtoonBinding
import kr.tooni.tooni.features.watch.recent.db.RecentWebtoon

class RecentWebtoonAdapter(private val clickListner: (RecentWebtoon) -> Unit): RecyclerView.Adapter<Holder>() {

    private val recentWebtoonsList = mutableListOf<RecentWebtoon>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemRecentWebtoonBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_recent_webtoon ,parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(recentWebtoonsList[position], clickListner)
    }

    override fun getItemCount(): Int{
        return recentWebtoonsList.size
    }

    fun setList(recentWebtoons: List<RecentWebtoon>) {
        recentWebtoonsList.clear()
        recentWebtoonsList.addAll(recentWebtoons)
    }

}

class Holder(val binding: ItemRecentWebtoonBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(recentWebtoon: RecentWebtoon, clickListner: (RecentWebtoon) -> Unit) {
        binding.tvRecentTitle.text = recentWebtoon.webtoon.title
        binding.tvRecentAuthors.text = recentWebtoon.webtoon.authorFullName
        binding.tvRecentScore.text = String.format("%.1f", recentWebtoon.webtoon.score)

        binding.btnRecentDelete.setOnClickListener {
            clickListner(recentWebtoon)
        }
    }
}