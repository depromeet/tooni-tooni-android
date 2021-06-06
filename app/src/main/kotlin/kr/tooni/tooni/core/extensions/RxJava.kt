/*
 * Created by Leo on 2021. 06. 06 ..
 */
package kr.tooni.tooni.core.extensions

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.Executor

fun <T> Single<T>.applySchedulers(): Single<T> {
    return compose {
        subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}

fun <T> Single<T>.applySchedulers(workerExecutor: Executor): Single<T> {
    return compose {
        subscribeOn(Schedulers.from(workerExecutor))
            .observeOn(AndroidSchedulers.mainThread())
    }
}

fun <T> Maybe<T>.applySchedulers(): Maybe<T> {
    return compose {
        subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}

fun Completable.applySchedulers(): Completable {
    return compose {
        subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}
