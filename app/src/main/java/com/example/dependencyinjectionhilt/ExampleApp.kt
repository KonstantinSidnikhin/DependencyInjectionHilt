package com.example.dependencyinjectionhilt

import android.app.Application
import com.example.dependencyinjectionhilt.di.Component

class ExampleApp: Application() {
    val component = Component(this)
}