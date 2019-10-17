package prieto.fernando.darkpicker.presentation

import android.app.Application
import android.util.Log
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import prieto.fernando.darkpicker.widget.ThemeApplier
import prieto.fernando.darkpicker.widget.ThemeMode
import prieto.fernando.presentation.BaseViewModel
import prieto.fernando.presentation.BaseViewModelInputs
import prieto.fernando.presentation.BaseViewModelOutputs
import javax.inject.Inject

interface MainViewModelInputs : BaseViewModelInputs {
    fun initTheme()
    fun applyTheme(themeMode: ThemeMode)
    fun getCurrentTheme()
}

interface MainViewModelOutputs : BaseViewModelOutputs {
    fun currentThemeModeRetrieved(): Observable<ThemeMode>
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

    private val currentThemeModeRetrieved = PublishSubject.create<ThemeMode>()

    override fun initTheme() {
        themeApplier.initTheme()
    }

    override fun applyTheme(themeMode: ThemeMode) {
        themeApplier.applyTheme(themeMode)
    }

    override fun getCurrentTheme() {
        themeApplier.getCurrentMode()
            .subscribe({ currentMode ->
                currentThemeModeRetrieved.onNext(currentMode)
            }, { throwable ->
                Log.d(
                    "themeApplier.getCurrentMode()",
                    "There was an issue getting current mode"
                )
            }).also { subscriptions.add(it) }
    }

    override fun currentThemeModeRetrieved(): Observable<ThemeMode> =
        currentThemeModeRetrieved.observeOn(schedulerProvider.ui()).hide()


}
