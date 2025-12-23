package com.example.dependencyinjectionhilt.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.dependencyinjectionhilt.domain.ExampleUseCase
import com.example.dependencyinjectionhilt.domain.Item

class ExampleViewModel(
    private val exampleUseCase: ExampleUseCase
): ViewModel() {
    fun exampleMethod(item: Item){
        Log.d("ExampleTest", "ExampleViewModel exampleMethod $item")
        exampleUseCase(item)
    }
}