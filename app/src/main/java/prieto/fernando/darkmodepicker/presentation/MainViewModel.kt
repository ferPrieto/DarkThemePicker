package prieto.fernando.darkmodepicker.presentation

import android.app.Application
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject
import prieto.fernando.darkmodepicker.R
import prieto.fernando.darkmodepicker.domain.ApplyThemeUseCase
import prieto.fernando.darkmodepicker.domain.GetCurrentModeUseCase
import prieto.fernando.darkmodepicker.domain.InitThemeApplierUseCase
import prieto.fernando.darkmodepicker.widget.ThemeMode

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
    private val getCurrentModeUseCase: GetCurrentModeUseCase,
    private val initThemeApplierUseCase: InitThemeApplierUseCase,
    private val applyThemeUseCase: ApplyThemeUseCase

) : BaseViewModel(application),
    MainViewModelInputs,
    MainViewModelOutputs {

    override val inputs: MainViewModelInputs
        get() = this

    override val outputs: MainViewModelOutputs
        get() = this

    private val currentThemeModeRetrieved = PublishSubject.create<ThemeMode>()

    override fun initTheme() {
        initThemeApplierUseCase.execute()
            .subscribe({
            }, {
                error.onNext(R.string.error_init_theme_mode)
            }).also { subscriptions.add(it) }
    }

    override fun applyTheme(themeMode: ThemeMode) {
        applyThemeUseCase.execute(themeMode)
            .subscribe({
            }, {
                error.onNext(R.string.error_current_mode)
            }).also { subscriptions.add(it) }
    }

    override fun getCurrentTheme() {
        getCurrentModeUseCase.execute()
            .subscribe({ currentMode ->
                currentThemeModeRetrieved.onNext(currentMode)
            }, {
                error.onNext(R.string.error_current_mode)
            }).also { subscriptions.add(it) }
    }

    override fun currentThemeModeRetrieved(): Observable<ThemeMode> =
        currentThemeModeRetrieved.observeOn(schedulerProvider.ui()).hide()
}
