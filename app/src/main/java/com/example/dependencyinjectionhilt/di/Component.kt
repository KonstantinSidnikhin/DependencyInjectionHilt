package com.example.dependencyinjectionhilt.di

import android.content.Context
import com.example.dependencyinjectionhilt.data.Database
import com.example.dependencyinjectionhilt.data.ExampleRepositoryImpl
import com.example.dependencyinjectionhilt.domain.ExampleUseCase
import com.example.dependencyinjectionhilt.domain.Item
import com.example.dependencyinjectionhilt.presentation.ExampleViewModel
import com.example.dependencyinjectionhilt.presentation.MainActivity

class Component(context: Context) {// мы передаем параметр в конструктор потому что не можем создать экземпляр класса Контекст сразу, только  после запуска приложения можно
    val database = Database.getInstance(context)
    val repository = ExampleRepositoryImpl(database)
    val exampleUseCase = ExampleUseCase(repository)
    val exampleViewModel
        get() = ExampleViewModel(exampleUseCase, Item(0))// так уже не будет синглтон и будет создаваться каждый раз при обращении к переменной
    fun inject(mainActivity: MainActivity) {
        //mainActivity.exampleViewModelFactory = exampleViewModel
        //mainActivity.repository = repository// if needed
    }

}