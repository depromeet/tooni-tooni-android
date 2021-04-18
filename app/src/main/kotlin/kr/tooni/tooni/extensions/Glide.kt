/*
 * Created by Leo on 2021. 04. 17 ..
 */
package kr.tooni.tooni.extensions

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

internal fun ImageView.load(imageUrl: String?, action: RequestBuilder<Drawable>.() -> Unit) = loadInternals(imageUrl, action)
internal fun ImageView.load(imageUrl: String?) = loadInternals(imageUrl)
internal fun ImageView.load(@DrawableRes drawableRes: Int, action: RequestBuilder<Drawable>.() -> Unit) = loadInternals(drawableRes, action)

private fun ImageView.loadInternals(
    @DrawableRes drawableRes: Int,
    action: RequestBuilder<Drawable>.() -> Unit = {}
) = Glide.with(this)
    .load(drawableRes)
    .apply(action)
    .into(this)

private fun ImageView.loadInternals(
    imageUrl: String?,
    action: RequestBuilder<Drawable>.() -> Unit = {}
) = Glide.with(this)
    .load(imageUrl)
    .apply(action)
    .transition(DrawableTransitionOptions.withCrossFade())
    .into(this)
