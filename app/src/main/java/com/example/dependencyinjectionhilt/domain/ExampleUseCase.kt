package com.example.dependencyinjectionhilt.domain

import android.util.Log
import com.example.dependencyinjectionhilt.data.ExampleRepositoryImpl
import javax.inject.Inject

class ExampleUseCase @Inject constructor(
    private val repository: ExampleRepository) {//временное решение
    operator fun invoke(item: Item){
        Log.d("ExampleTest", "ExampleUseCase invoke $item")
repository.exampleMethod(item)
    }
}