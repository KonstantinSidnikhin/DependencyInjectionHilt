package com.example.dependencyinjectionhilt.data


import android.content.Context
import android.util.Log
import com.example.dependencyinjectionhilt.domain.Item
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton


class Database private constructor(
    private val context: Context
) {
init {
    Log.d("ExampleTest", "Database created")
}

    fun exampleMethod(item: Item) {
        Log.d("ExampleTest", "Database exampleMethod $item")
    }

    companion object {
        private val LOCK = Any()
        private var instance: Database? = null
        fun getInstance(context: Context): Database {
            instance?.let { return it }
            synchronized(LOCK) {
                instance?.let { return it }
                return Database(context).also {
                    instance = it
                }
            }
        }
    }
}