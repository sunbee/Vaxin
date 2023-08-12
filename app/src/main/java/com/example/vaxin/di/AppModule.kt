package com.example.vaxin.di

import android.app.Application
import androidx.room.Room
import com.example.vaxin.data.VaxinDatabase
import com.example.vaxin.data.VaxinRepository
import com.example.vaxin.data.VaxinRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideVaxinDatabase(app: Application) : VaxinDatabase {
        return Room.databaseBuilder(
            app,
            VaxinDatabase::class.java,
            "vaxindb"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTodoRepository(db: VaxinDatabase) : VaxinRepository {
        return VaxinRepositoryImpl(db.vaxinDao())
    }
}