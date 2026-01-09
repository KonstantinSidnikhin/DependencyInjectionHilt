package com.example.dependencyinjectionhilt.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.dependencyinjectionhilt.domain.ExampleUseCase
import com.example.dependencyinjectionhilt.domain.Item
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class ExampleViewModel2 @Inject constructor(
//AssistedInject потому что мы не можем заинжектить все, item не можем
    private val exampleUseCase: ExampleUseCase,

    ) : ViewModel() {
    fun exampleMethod(item: Item) {
        Log.d("ExampleTest", "ExampleViewModel exampleMethod $item")
        exampleUseCase(item)
    }

}

