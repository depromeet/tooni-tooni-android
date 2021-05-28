package kr.tooni.tooni.utils

import android.content.Context
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import kr.tooni.tooni.R
import kr.tooni.tooni.core.model.BackgroundColor

object BackgroundColorMapper {
    
    @ColorInt
    fun getColor(context: Context, backgroundColor: BackgroundColor): Int {
        val resId = convert(backgroundColor)
        return ContextCompat.getColor(context, resId)
    }
    
    @ColorRes
    private fun convert(backgroundColor: BackgroundColor): Int {
        return when (backgroundColor) {
            BackgroundColor.RED -> R.color.red_100
            BackgroundColor.BLUE -> R.color.blue_100
            BackgroundColor.NONE -> R.color.gray_90
        }
    }
}
