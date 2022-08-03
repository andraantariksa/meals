package io.github.andraantariksa.meal.core.di

import android.content.Context
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.github.andraantariksa.meal.core.data.data_source_store.local.MealsLocalDataSource
import io.github.andraantariksa.meal.core.data.data_source_store.local.MealsLocalDataSourceImpl
import io.github.andraantariksa.meal.core.data.data_source_store.remote.MealsRemoteDataSource
import io.github.andraantariksa.meal.core.data.data_source_store.remote.MealsRemoteDataSourceImpl
import io.github.andraantariksa.meal.core.data.data_source_store.remote.MealsService
import io.github.andraantariksa.meal.core.data.data_source_store.remote.MealsServiceConst
import io.github.andraantariksa.meal.core.data.repository.AppSettingsRepositoryImpl
import io.github.andraantariksa.meal.core.data.repository.MealsRepositoryImpl
import io.github.andraantariksa.meal.core.domain.repository.AppSettingsRepository
import io.github.andraantariksa.meal.core.domain.repository.MealsRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {
    @Provides
    @Singleton
    fun provideMealsRemoteDataSource(mealsService: MealsService): MealsRemoteDataSource =
        MealsRemoteDataSourceImpl(mealsService)

    @Provides
    @Singleton
    fun provideMealsLocalDataSource(): MealsLocalDataSource = MealsLocalDataSourceImpl()

    @Provides
    @Singleton
    fun provideOkHttpClient() =
        OkHttpClient.Builder().addInterceptor(
            HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BASIC)
            }
        ).build()

    @Provides
    @Singleton
    fun provideMoshi() = Moshi.Builder().build()

    @Provides
    @Singleton
    fun provideMealsRepository(
        remoteDataSource: MealsRemoteDataSource,
        localDataSource: MealsLocalDataSource
    ): MealsRepository = MealsRepositoryImpl(remoteDataSource, localDataSource)

    @Provides
    @Singleton
    fun provideAppSettingsRepository(@ApplicationContext context: Context): AppSettingsRepository =
        AppSettingsRepositoryImpl(context)

    @Provides
    @Singleton
    fun provideMealsService(moshi: Moshi, client: OkHttpClient): MealsService {
        val retrofit = Retrofit.Builder().baseUrl(MealsServiceConst.BASE_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
        return retrofit.create(MealsService::class.java)
    }
}