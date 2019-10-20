package prieto.fernando.darkmodepicker.domain

import dagger.Reusable
import javax.inject.Inject
import prieto.fernando.darkmodepicker.widget.ThemeApplier

@Reusable
class GetCurrentModeUseCase @Inject constructor(
    private val themeApplier: ThemeApplier
) {
    fun execute() = themeApplier.getCurrentMode()
}
