package prieto.fernando.darkpicker.domain

import dagger.Reusable
import javax.inject.Inject
import prieto.fernando.darkpicker.widget.ThemeApplier
import prieto.fernando.darkpicker.widget.ThemeMode

@Reusable
class ApplyThemeUseCase @Inject constructor(
    private val themeApplier: ThemeApplier
) {
    fun execute(themeMode: ThemeMode) = themeApplier.applyTheme(themeMode)
}
