package org.example.project

import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController {
    val viewModel = BreachViewModel(IosApiClient())
    BreachListScreen(viewModel)
}