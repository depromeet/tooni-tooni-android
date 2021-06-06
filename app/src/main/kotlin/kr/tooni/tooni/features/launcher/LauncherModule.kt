package kr.tooni.tooni.features.launcher

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kr.tooni.tooni.data.api.AccountApi
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object LauncherModule {
    
    @Provides
    fun provideLauncherRepository(
        localDataSource: LauncherLocalDataSource,
        remoteDataSource: LauncherRemoteDataSource
    ): LauncherRepository = LauncherRepositoryImpl(localDataSource, remoteDataSource)
    
    @Provides
    fun provideFirebaseAuth(): FirebaseAuth {
        return Firebase.auth
    }
    
    @Provides
    fun provideAccountApi(retrofit: Retrofit): AccountApi {
        return retrofit.create(AccountApi::class.java)
    }
}
