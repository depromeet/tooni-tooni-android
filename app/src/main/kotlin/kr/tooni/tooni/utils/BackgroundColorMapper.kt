package kr.tooni.tooni.utils

import android.content.Context
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import kr.tooni.tooni.R
import kr.tooni.tooni.core.model.BackgroundColor
import kr.tooni.tooni.core.model.Site

object BackgroundColorMapper {
    
    @ColorInt
    fun getColor(context: Context, backgroundColor: BackgroundColor): Int {
        val colorRes = convert(backgroundColor)
        return ContextCompat.getColor(context, colorRes)
    }
    
    @ColorInt
    fun getColor(context: Context, site: Site): Int {
        val colorRes = convert(site)
        return ContextCompat.getColor(context, colorRes)
    }
    
    @ColorRes
    private fun convert(backgroundColor: BackgroundColor): Int {
        return when (backgroundColor) {
            BackgroundColor.RED -> R.color.red_100
            BackgroundColor.BLUE -> R.color.blue_100
            BackgroundColor.NONE -> R.color.gray_90
        }
    }
    
    @ColorRes
    private fun convert(site: Site): Int {
        return when (site) {
            Site.NAVER -> R.color.green_100
            Site.DAUM -> R.color.red_100
            Site.KAKAO -> R.color.yellow_100
            Site.NONE -> R.color.gray_90
        }
    }
}
