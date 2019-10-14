package prieto.fernando.darkpicker.presentation

import android.app.Application
import prieto.fernando.darkpicker.util.ThemeProvider
import prieto.fernando.darkpicker.widget.ThemeApplier
import prieto.fernando.darkpicker.widget.ThemeMode
import prieto.fernando.presentation.BaseViewModel
import prieto.fernando.presentation.BaseViewModelInputs
import prieto.fernando.presentation.BaseViewModelOutputs
import javax.inject.Inject

interface MainViewModelInputs : BaseViewModelInputs{
   fun applyTheme( themeMode: ThemeMode)
}

interface MainViewModelOutputs : BaseViewModelOutputs
{

}
open class MainViewModel @Inject constructor(
    application: Application,
    private val themeApplier: ThemeApplier
) : BaseViewModel(application),
    MainViewModelInputs,
    MainViewModelOutputs {

    override val inputs: MainViewModelInputs
        get() = this

    override val outputs: MainViewModelOutputs
        get() = this

    override fun applyTheme(themeMode: ThemeMode) {
        themeApplier.applyTheme(themeMode)
    }
}
