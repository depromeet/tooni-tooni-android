/*
 * Created by Leo on 2021. 05. 23 ..
 */
package kr.tooni.tooni.utils

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import kr.tooni.tooni.R
import kr.tooni.tooni.core.model.Site
import kr.tooni.tooni.core.model.Webtoon

object SiteLogoProvider {
    
    fun getDrawable(context: Context, webtoon: Webtoon): Drawable? {
        val resId = convert(webtoon.site).takeIf { it != -1 } ?: return null
        return ContextCompat.getDrawable(context, resId)
    }
    
    fun getDrawable(context: Context, site: Site): Drawable? {
        val resId = convert(site).takeIf { it != -1 } ?: return null
        return ContextCompat.getDrawable(context, resId)
    }
    
    fun getId(webtoon: Webtoon): Int? {
        return convert(webtoon.site).takeIf { it != -1 }
    }
    
    fun getId(site: Site): Int? {
        return convert(site).takeIf { it != -1 }
    }
    
    private fun convert(site: Site): Int {
        return when (site) {
            Site.NAVER -> R.drawable.icon_platform_naver
            Site.DAUM -> R.drawable.icon_platform_daum
            Site.KAKAO -> R.drawable.icon_platform_kakao
            Site.NONE -> -1
        }
    }
}
