package com.auth0.todolistapp.di

import com.plcoding.mvvmtodoapp.data.TodoDatabase
import com.plcoding.mvvmtodoapp.data.TodoRepository
import com.plcoding.mvvmtodoapp.data.TodoRepositoryImpl
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import android.app.Application
import androidx.room.Room
import com.auth0.todolistapp.data.TodoDatabase
import com.auth0.todolistapp.data.TodoRepository
import com.auth0.todolistapp.data.TodoRepositoryImpl
import com.google.android.datatransport.runtime.dagger.Module
import com.google.android.datatransport.runtime.dagger.Provides
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTodoDatabase(app: Application): TodoDatabase {
        return Room.databaseBuilder(
            app,
            TodoDatabase::class.java,
            "todo_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTodoRepository(db: TodoDatabase): TodoRepository {
        return TodoRepositoryImpl(db.dao)
    }
}


