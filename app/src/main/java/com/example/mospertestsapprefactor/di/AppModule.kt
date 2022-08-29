package com.example.mospertestsapprefactor.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.example.mospertestsapprefactor.data.local.EmployeeDao
import com.example.mospertestsapprefactor.data.local.EmployeeDatabase
import com.example.mospertestsapprefactor.data.remote.EmployeeApi
import com.example.mospertestsapprefactor.data.repository.EmployeeRepositoryImplementation
import com.example.mospertestsapprefactor.domain.respository.EmployeeRepository
import com.example.mospertestsapprefactor.utils.Constanst
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideEmployeeDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context,EmployeeDatabase::class.java,Constanst.db_name)

    @Provides
    @Singleton
    fun provideEmployeeDao(db: EmployeeDatabase) = db.employeeDao()

    @Provides
    @Singleton
    fun provideEmployeeApi(): EmployeeApi{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constanst.BASE_URL)
            .build()
            .create(EmployeeApi::class.java)
    }

    @Singleton
    @Provides
    fun provideEmployeeRepository(
        dao:EmployeeDao,
        api: EmployeeApi
    ): EmployeeRepository{
        return  EmployeeRepositoryImplementation(dao,api)
    }

    @Singleton
    @Provides
    fun provideSaharedPreferences(
        @ApplicationContext context: Context
    ):SharedPreferences{
        val masterKey = MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()
        return EncryptedSharedPreferences.create(
            context,
            Constanst.ENCRYPTED_SHARED_PREF_NAME,
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

}