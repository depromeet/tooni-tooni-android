/*
 * Created by Leo on 2021. 06. 06 ..
 */
package kr.tooni.tooni.features.launcher

import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class LauncherRepositoryImpl @Inject constructor(
    private val localDataSource: LauncherLocalDataSource,
    private val remoteDataSource: LauncherRemoteDataSource
) : LauncherRepository {
    
    override fun signInAnonymously(): Single<String> {
        return getUserId().flatMap { uid ->
            remoteDataSource.signInAnonymously(uid)
                .doOnSuccess { nickname -> localDataSource.setUserNickname(nickname) }
        }.flatMap { nickname ->
            Single.create { emitter ->
                if (nickname.isBlank()) {
                    val errorMessage = "nickname is blank in signInAnonymously()"
                    return@create emitter.onError(Exception(errorMessage))
                }
                
                emitter.onSuccess(nickname)
            }
        }
    }
    
    override fun getUserId(): Single<String> {
        return localDataSource.getUserId()
            .flatMap { token ->
                if (token.isBlank()) {
                    return@flatMap remoteDataSource.getUserId()
                        .doOnSuccess { newId -> setUserId(newId) }
                }
                
                Single.just(token)
            }
    }
    
    override fun setUserId(uid: String) {
        return localDataSource.setUserId(uid)
    }
}
