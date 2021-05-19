/*
 * Created by Leo on 2021. 04. 17 ..
 */
package kr.tooni.tooni.core.extensions

import android.content.Context
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.addItemDecorationIfFirst(itemDecorator: RecyclerView.ItemDecoration) {
    if (itemDecorationCount == 0) {
        addItemDecoration(itemDecorator)
    }
}

fun RecyclerView.scrollToTop(animated: Boolean = true) {
    if (animated) smoothScrollToPosition(0) else scrollToPosition(0)
}

val RecyclerView.ViewHolder.context: Context
    get() = this.itemView.context
