package prieto.fernando.darkmodepicker.domain

import dagger.Reusable
import javax.inject.Inject
import prieto.fernando.darkmodepicker.widget.ThemeApplier
import prieto.fernando.darkmodepicker.widget.ThemeMode

@Reusable
class ApplyThemeUseCase @Inject constructor(
    private val themeApplier: ThemeApplier
) {
    fun execute(themeMode: ThemeMode) = themeApplier.applyTheme(themeMode)
}
