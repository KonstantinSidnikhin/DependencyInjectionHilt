package com.example.dependencyinjectionhilt.data


import android.content.Context
import android.util.Log
import com.example.dependencyinjectionhilt.domain.Item

class Database (private val context: Context){
    fun exampleMethod(item: Item){
        Log.d("ExampleTest", "Database exampleMethod $item")
    }
}