package prieto.fernando.darkpicker.ui

import androidx.lifecycle.ViewModel

interface BaseView<T : ViewModel> {
    val viewModel: T
}
