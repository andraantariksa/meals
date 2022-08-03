package io.github.andraantariksa.meal.core.di

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.andraantariksa.meal.core.data.data_source_store.local.data_source.MealsLocalDataSource
import io.github.andraantariksa.meal.core.data.data_source_store.local.data_source.MealsLocalDataSourceImpl
import io.github.andraantariksa.meal.core.data.data_source_store.local.data_source.MealsRemoteDataSource
import io.github.andraantariksa.meal.core.data.data_source_store.local.data_source.MealsRemoteDataSourceImpl
import io.github.andraantariksa.meal.core.data.data_source_store.remote.MealsService
import io.github.andraantariksa.meal.core.data.data_source_store.remote.MealsServiceConst
import io.github.andraantariksa.meal.core.data.repository.AppPreferenceRepositoryImpl
import io.github.andraantariksa.meal.core.data.repository.MealsRepositoryImpl
import io.github.andraantariksa.meal.core.domain.repository.AppPreferenceRepository
import io.github.andraantariksa.meal.core.domain.repository.MealsRepository
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
    fun provideMoshi() = Moshi.Builder().build()

    @Provides
    @Singleton
    fun provideMealsRepository(
        remoteDataSource: MealsRemoteDataSource,
        localDataSource: MealsLocalDataSource
    ): MealsRepository = MealsRepositoryImpl(remoteDataSource, localDataSource)

    @Provides
    @Singleton
    fun provideAppPreferenceRepository(): AppPreferenceRepository = AppPreferenceRepositoryImpl()

    @Provides
    @Singleton
    fun provideMealsService(moshi: Moshi): MealsService {
        val retrofit = Retrofit.Builder().baseUrl(MealsServiceConst.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
        return retrofit.create(MealsService::class.java)
    }
}