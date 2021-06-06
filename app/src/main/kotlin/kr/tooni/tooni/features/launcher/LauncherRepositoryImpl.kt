/*
 * Created by Leo on 2021. 06. 06 ..
 */
package kr.tooni.tooni.features.launcher

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

class LauncherRepositoryImpl constructor(
    private val localDataSource: LauncherLocalDataSource,
    private val remoteDataSource: LauncherRemoteDataSource
): LauncherRepository {
    
    override fun signInAnonymously(): Single<String> {
        return getUserId().flatMap { uid ->
            remoteDataSource.signInAnonymously(uid)
        }
    }
    
    override fun getUserId(): Single<String> {
        return localDataSource.getUserId()
            .flatMap { token ->
                if (token.isBlank()) {
                    return@flatMap remoteDataSource.getUserToken()
                        .doOnSuccess { newToken -> setUserId(newToken) }
                }
                
                Single.just(token)
            }
    }
    
    override fun setUserId(token: String): Completable {
        return localDataSource.setUserId(token)
    }
}
