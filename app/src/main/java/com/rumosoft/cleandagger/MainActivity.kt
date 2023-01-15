package com.rumosoft.cleandagger

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rumosoft.cleandagger.ui.theme.CleanDaggerTheme
import com.rumosoft.domain.entities.Item
import com.rumosoft.presentation.MainViewModel
import com.rumosoft.presentation.state.MainScreenState
import com.rumosoft.presentation.state.MainScreenState.Data
import com.rumosoft.presentation.state.MainScreenState.Loading
import javax.inject.Inject

class MainActivity : ComponentActivity() {
    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as MyApplication).appComponent
            .inject(this)
        viewModel.getItems()

        setContent {
            val uiState by viewModel.uiState.collectAsState()
            CleanDaggerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen(uiState)
                }
            }
        }
    }
}

@Composable
fun MainScreen(uiState: MainScreenState) {
    when (uiState) {
        Loading -> Loading()
        is Data -> DisplayData(uiState.data)
    }
}

@Composable
fun Loading() {
    Box(
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun DisplayData(data: List<Item>) {
    LazyColumn {
        items(data) {
            Text(text = "Item: ${it.id}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenLoadingPreview() {
    CleanDaggerTheme {
        MainScreen(Loading)
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenDataPreview() {
    CleanDaggerTheme {
        val itemsList = (1..4).map { Item(it) }
        MainScreen(Data(data = itemsList))
    }
}
