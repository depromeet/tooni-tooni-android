/*
 * Created by Leo on 2021. 04. 17 ..
 */
package kr.tooni.tooni.base

import java.io.Serializable

interface DiffCallbackItem : Serializable {
    val identifiedField: Any
}
