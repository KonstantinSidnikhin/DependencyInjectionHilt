package com.example.dependencyinjectionhilt.domain

import android.util.Log
import com.example.dependencyinjectionhilt.data.ExampleRepositoryImpl

class ExampleUseCase(private val repository: ExampleRepository) {
    operator fun invoke(item: Item){
        Log.d("ExampleTest", "ExampleUseCase invoke $item")
repository.exampleMethod(item)
    }
}