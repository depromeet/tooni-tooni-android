/*
 * Created by Leo on 2021. 06. 06 ..
 */
package kr.tooni.tooni.features.launcher

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface LauncherRepository {
    fun signInAnonymously(): Single<String> // do 파이어베이스 익명 로그인 -> 닉네임 반환
    fun getUserId(): Single<String>
    fun setUserId(token: String): Completable
}
