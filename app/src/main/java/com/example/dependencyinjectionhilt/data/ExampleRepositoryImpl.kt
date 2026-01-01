package com.example.dependencyinjectionhilt.data

import android.util.Log
import com.example.dependencyinjectionhilt.domain.ExampleRepository
import com.example.dependencyinjectionhilt.domain.Item
import javax.inject.Inject

class ExampleRepositoryImpl @Inject constructor(private val database: Database) : ExampleRepository {
    override fun exampleMethod(item: Item){
        Log.d("ExampleTest", "ExampleRepositoryImpl exampleMethod $item")
        database.exampleMethod(item)
    }
}