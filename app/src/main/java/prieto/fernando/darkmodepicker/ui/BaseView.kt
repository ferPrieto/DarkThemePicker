package prieto.fernando.darkmodepicker.ui

import androidx.lifecycle.ViewModel

interface BaseView<T : ViewModel> {
    val viewModel: T
}
