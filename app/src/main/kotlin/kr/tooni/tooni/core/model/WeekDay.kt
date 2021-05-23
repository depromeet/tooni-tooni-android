/*
 * Created by Leo on 2021. 05. 19 ..
 */
package kr.tooni.tooni.core.model

import com.google.gson.annotations.SerializedName
import kr.tooni.tooni.core.StringKeySet

enum class WeekDay(val value: String) {
    @SerializedName(StringKeySet.MON)
    MON("mon"),
    @SerializedName(StringKeySet.TUE)
    TUE("thu"),
    @SerializedName(StringKeySet.WED)
    WED("wed"),
    @SerializedName(StringKeySet.THU)
    THU("thu"),
    @SerializedName(StringKeySet.FRI)
    FRI("fri"),
    @SerializedName(StringKeySet.SAT)
    SAT("sat"),
    @SerializedName(StringKeySet.SUN)
    SUN("sun")
}
