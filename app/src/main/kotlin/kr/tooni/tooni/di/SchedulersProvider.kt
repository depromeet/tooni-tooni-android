/*
 * Created by Leo on 2021. 06. 12 ..
 */
package kr.tooni.tooni.di

import io.reactivex.rxjava3.core.Scheduler

interface SchedulersProvider {
    fun new(): Scheduler
    fun io(): Scheduler
    fun computation(): Scheduler
    fun main(): Scheduler
}
