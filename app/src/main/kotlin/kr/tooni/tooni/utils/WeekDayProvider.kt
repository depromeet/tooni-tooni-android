package kr.tooni.tooni.utils

import android.content.Context
import kr.tooni.tooni.R
import kr.tooni.tooni.core.extensions.WHITE_SPACE
import kr.tooni.tooni.core.model.WeekDay

object WeekDayProvider {
    
    fun getArray(context: Context): Array<String> {
        return context.resources.getStringArray(R.array.week_day)
    }
    
    fun getName(context: Context, day: WeekDay): String {
        return context.resources.getStringArray(R.array.week_day)[day.ordinal]
    }
    
    fun getName(context: Context, weekDay: List<WeekDay>): String {
        return weekDay.joinToString(String.WHITE_SPACE) { day ->
            context.resources.getStringArray(R.array.week_day)[day.ordinal]
        }
    }
}
