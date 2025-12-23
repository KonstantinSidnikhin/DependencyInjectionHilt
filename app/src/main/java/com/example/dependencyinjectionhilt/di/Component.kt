package com.example.dependencyinjectionhilt.di

import android.content.Context
import com.example.dependencyinjectionhilt.data.Database
import com.example.dependencyinjectionhilt.data.ExampleRepositoryImpl
import com.example.dependencyinjectionhilt.domain.ExampleRepository
import com.example.dependencyinjectionhilt.domain.ExampleUseCase
import com.example.dependencyinjectionhilt.presentation.ExampleViewModel
import com.example.dependencyinjectionhilt.presentation.MainActivity

class Component(context: Context) {
    val database = Database(context)
    val repository = ExampleRepositoryImpl(database)
    val exampleUseCase = ExampleUseCase(repository)
    val exampleViewModel = ExampleViewModel(exampleUseCase)
    fun inject(mainActivity: MainActivity) {
        mainActivity.exampleViewModel = exampleViewModel
        //mainActivity.repository = repository// if needed
    }

}