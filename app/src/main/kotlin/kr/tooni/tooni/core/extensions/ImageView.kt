/*
 * Created by Leo on 2021. 04. 17 ..
 */
package kr.tooni.tooni.core.extensions

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import kr.tooni.tooni.R

object ImageViewBindingAdapter {

    @JvmStatic
    @BindingAdapter(value = ["app:setImage"], requireAll = true)
    fun ImageView.setImage(url: String?) =
        load(imageUrl = url) {
            error(R.drawable.ic_vector_warning)
        }

    @JvmStatic
    @BindingAdapter(value = ["app:setDrawable"], requireAll = true)
    fun ImageView.setDrawable(drawable: Drawable?) {
        setImageDrawable(drawable)
    }
}
