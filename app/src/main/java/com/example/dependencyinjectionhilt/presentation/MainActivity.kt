package com.example.dependencyinjectionhilt.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dependencyinjectionhilt.domain.Item
import com.example.dependencyinjectionhilt.presentation.theme.DependencyInjectionHiltTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint//что бы внутри активити можено было вызвать Inject
class MainActivity : ComponentActivity() {//тут будет получен экземпляр компонента из Aplication у
    // него будет вызван метод Inject и всем свойствам класса с анотацией @Inject будут установлены значения


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       //val component = (application as ExampleApp).component// мы создали экземпляр нашего Компонента
        // в классе ExampleApp которое унаследовалось от Application и поэтому наш компонент будет жить сколько живет прлиложение
       // component.inject(this)

        enableEdgeToEdge()
        setContent {
            DependencyInjectionHiltTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ExampleScreen(
                        modifier = Modifier.padding(innerPadding),

                        )
                }
            }
        }
    }
}

