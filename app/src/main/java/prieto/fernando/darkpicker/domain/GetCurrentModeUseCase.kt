package prieto.fernando.darkpicker.domain

import dagger.Reusable
import javax.inject.Inject
import prieto.fernando.darkpicker.widget.ThemeApplier

@Reusable
class GetCurrentModeUseCase @Inject constructor(
    private val themeApplier: ThemeApplier
) {
    fun execute() = themeApplier.getCurrentMode()
}
