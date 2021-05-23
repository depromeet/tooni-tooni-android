/*
 * Created by Leo on 2021. 05. 23 ..
 */
package kr.tooni.tooni.core.model

import com.google.gson.annotations.SerializedName
import kr.tooni.tooni.core.StringKeySet

enum class BackgroundColor {
    @SerializedName(StringKeySet.RED)
    RED,
    @SerializedName(StringKeySet.BLUE)
    BLUE,
    @SerializedName(StringKeySet.NONE)
    NONE
}
