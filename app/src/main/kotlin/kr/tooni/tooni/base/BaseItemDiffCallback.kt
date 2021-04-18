/*
 * Created by Leo on 2021. 04. 17 ..
 */
package kr.tooni.tooni.base

import androidx.recyclerview.widget.DiffUtil

class BaseItemDiffCallback<T: DiffCallbackItem> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean = (oldItem.identifiedField == newItem.identifiedField)
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean = (oldItem.hashCode() == newItem.hashCode())
}
