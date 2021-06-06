/*
 * Created by Leo on 2021. 06. 06 ..
 */
package kr.tooni.tooni.features.launcher

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.data.ApiProvider
import kr.tooni.tooni.data.api.AccountApi
import kr.tooni.tooni.data.request.LoginRequest

class LauncherRemoteDataSource constructor(
    private val apiProvider: ApiProvider = ApiProvider,
    private val auth: FirebaseAuth = Firebase.auth
) {
    
    fun signInAnonymously(uid: String): Single<String> {
        val request = LoginRequest(loginToken = uid)
        return apiProvider.create(AccountApi::class.java).login(request)
            .map { it.data.user.nickname }
    }
    
    fun getUserToken(): Single<String> {
        return Single.create { emitter ->
            val exist = auth.currentUser?.uid
            if (!exist.isNullOrBlank()) {
                emitter.onSuccess(exist)
            }
            
            auth.signInAnonymously().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val uid = auth.currentUser?.uid
                    if (uid != null) {
                        emitter.onSuccess(uid)
                    } else {
                        val errorMessage = "task is success but, uid is not exist"
                        emitter.onError(IllegalStateException(errorMessage))
                    }
                } else {
                    if (task.exception != null) {
                        emitter.onError(task.exception)
                    } else {
                        val errorMessage = "task is not success but, exception is also not exist"
                        emitter.onError(IllegalStateException(errorMessage))
                    }
                }
            }.addOnFailureListener { exception ->
                emitter.onError(exception)
            }
        }
    }
}
