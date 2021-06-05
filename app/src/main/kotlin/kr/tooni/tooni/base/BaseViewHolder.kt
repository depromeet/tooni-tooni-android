/*
 * Created by Leo on 2021. 05. 28 ..
 */
package kr.tooni.tooni.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kr.tooni.tooni.base.arch.Bindable

abstract class BaseViewHolder<T : Bindable>(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(data: T)
}
