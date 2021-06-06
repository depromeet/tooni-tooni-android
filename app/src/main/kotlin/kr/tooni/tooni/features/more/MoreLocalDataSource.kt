/*
 * Created by Leo on 2021. 06. 06 ..
 */
package kr.tooni.tooni.features.more

import kr.tooni.tooni.core.StringKeySet
import kr.tooni.tooni.core.model.User
import kr.tooni.tooni.data.preference.Preference
import javax.inject.Inject
import javax.inject.Named

class MoreLocalDataSource @Inject constructor(
    @Named(StringKeySet.VERSION_NAME) private val versionName: String,
    private val preference: Preference
) {
    
    fun getVersionName(): String {
        return versionName
    }
    
    fun getUser(): User {
        return preference.user
    }
}
