/*
 * Created by Leo on 2021. 04. 17 ..
 */
package kr.tooni.tooni.extensions

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import kr.tooni.tooni.R

object ImageViewBindingAdapter {

    @JvmStatic
    @BindingAdapter(value = ["app:setImageFromUrl"], requireAll = true)
    fun ImageView.setImageFromUrl(url: String?) =
        load(imageUrl = url) {
            override(400, 400)
            error(R.drawable.ic_vector_warning)
        }

    @JvmStatic
    @BindingAdapter(value = ["app:srcCompat"], requireAll = true)
    fun ImageView.setSrcCompat(drawable: Drawable?) = setImageDrawable(drawable)
}
