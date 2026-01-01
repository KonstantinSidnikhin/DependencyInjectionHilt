package com.example.dependencyinjectionhilt.di

import android.content.Context
import com.example.dependencyinjectionhilt.data.Database
import com.example.dependencyinjectionhilt.data.ExampleRepositoryImpl
import com.example.dependencyinjectionhilt.domain.ExampleRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)//это тот компонент который создается в классе Aplication
interface DataModule {
    @Singleton
    //@Provides  //позволяет предоставить реализацию какого то класса на конструктор нельзя навесить аннотацию @Inject
    @Binds
    abstract fun bindExampleRepository(
        impl: ExampleRepositoryImpl//если где то требуется интерфейс репозитория то надо взять
    // конкретную реализацию (RepositoryImpl)
    ): ExampleRepository

    companion object{
        @Singleton
        @Provides
        fun provideDatabase(@ApplicationContext context: Context): Database{
            return Database.getInstance(context)
        }
    }
}