/*
 * Created by Leo on 2021. 06. 06 ..
 */
package kr.tooni.tooni.features.launcher

import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.core.model.User
import kr.tooni.tooni.data.preference.Preference
import javax.inject.Inject

class LauncherLocalDataSource @Inject constructor(
    private val preference: Preference
) {
    
    fun getUserId(): Single<String> {
        return Single.fromCallable { preference.uid }
    }
    
    fun setUserId(uid: String) {
        preference.uid = uid
    }
    
    fun setUser(user: User) {
        preference.user = user
    }
}
