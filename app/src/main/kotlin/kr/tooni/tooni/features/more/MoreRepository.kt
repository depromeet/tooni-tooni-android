/*
 * Created by Leo on 2021. 06. 06 ..
 */
package kr.tooni.tooni.features.more

import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.core.model.User

interface MoreRepository {
    fun getVersionInfo(): Single<String>
    fun getUser(): Single<User>
}
