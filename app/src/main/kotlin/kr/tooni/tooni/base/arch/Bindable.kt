/*
 * Created by Leo on 2021. 05. 28 ..
 */
package kr.tooni.tooni.base.arch

import java.lang.RuntimeException

abstract class Bindable(val viewType: Int) {
    
    override fun equals(other: Any?): Boolean {
        return this.hashCode() == other.hashCode()
    }
    
    override fun hashCode(): Int {
        throw RuntimeException("hashCode() is must be overridden in subclasses")
    }
}
