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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dependencyinjectionhilt.ExampleApp
import com.example.dependencyinjectionhilt.data.Database
import com.example.dependencyinjectionhilt.data.ExampleRepositoryImpl
import com.example.dependencyinjectionhilt.di.Component
import com.example.dependencyinjectionhilt.domain.ExampleRepository
import com.example.dependencyinjectionhilt.domain.ExampleUseCase
import com.example.dependencyinjectionhilt.domain.Item
import com.example.dependencyinjectionhilt.presentation.theme.DependencyInjectionHiltTheme

class MainActivity : ComponentActivity() {
  lateinit  var exampleViewModel: ExampleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       val component = (application as ExampleApp).component// мы создали экземпляр нашего Компонента
        // в классе ExampleApp которое унаследовалось от Application и поэтому наш компонент будет жить сколько живет прлиложение
        component.inject(this)

        enableEdgeToEdge()
        setContent {
            DependencyInjectionHiltTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ExampleScreen(
                        modifier = Modifier.padding(innerPadding),
                        exampleViewModel = viewModel {
                            exampleViewModel
                        }

                        )
                }
            }
        }
    }
}

@Composable
fun ExampleScreen(
    modifier: Modifier = Modifier,
    exampleViewModel: ExampleViewModel
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            onClick = {
                exampleViewModel.exampleMethod(Item(0))
            }
        ) {
            Text(
                text = "Click me!!"
            )
        }
    }
}