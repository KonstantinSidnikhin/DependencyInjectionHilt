package com.example.dependencyinjectionhilt

import android.app.Application
import com.example.dependencyinjectionhilt.di.Component
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ExampleApp: Application() {//здесь будет создан компонент и контекст будет установлен в граф зависимостей
    //val component = Component(this)// Application наследуется от Context поэтому
// передаем параметром this как контекст
}