package prieto.fernando.darkpicker.domain

import dagger.Reusable
import javax.inject.Inject
import prieto.fernando.darkpicker.widget.ThemeApplier

@Reusable
class InitThemeApplierUseCase @Inject constructor(
    private val themeApplier: ThemeApplier
) {
    fun execute() = themeApplier.initTheme()
}
