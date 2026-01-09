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
@HiltViewModel(assistedFactory = ExampleViewModel.Factory::class)
class ExampleViewModel @AssistedInject constructor(//AssistedInject потому что мы не можем заинжектить все, item не можем
    private val exampleUseCase: ExampleUseCase,
    @Assisted("item") private val item: Item//указываем Assisted потому что его мы не можем заинжектить сразу
) : ViewModel() {
    fun exampleMethod() {
        Log.d("ExampleTest", "ExampleViewModel exampleMethod $item")
        exampleUseCase(item)
    }
    @AssistedFactory
    interface Factory{
        fun create(
            @Assisted("item")item: Item): ExampleViewModel// для хилта мы указываем assisted тот компонент который надо добавить, его нет в графе зависимостей.
    }
}

class ExampleViewModelFactory @Inject constructor(//ручное создание фабрики. Можно вообще без этого класса.
    private val exampleUseCase: ExampleUseCase
) {
    fun create(item: Item): ExampleViewModel {// так как мы добавили item в конструктор вьюмодели, но мы не знаем его при старте приложения,
        // эта фабрика  принимает item и инжектит вьюмодель. Изначально она не могла инжектится.
        return ExampleViewModel(exampleUseCase, item)
    }
}