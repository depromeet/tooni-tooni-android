/*
 * Created by Leo on 2021. 06. 06 ..
 */
package kr.tooni.tooni.features.more

import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.core.model.User
import javax.inject.Inject

class MoreRepositoryImpl @Inject constructor(
    private val localDataSource: MoreLocalDataSource
) : MoreRepository {
    
    override fun getVersionInfo(): Single<String> {
        return Single.fromCallable { localDataSource.getVersionName() }
    }
    
    override fun getUser(): Single<User> {
        return Single.fromCallable { localDataSource.getUser() }
    }
}
