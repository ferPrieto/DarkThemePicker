package prieto.fernando.darkmodepicker.model

import androidx.annotation.ColorInt

data class Style(
    val id: Int = 0,
    @ColorInt val primaryColor: Int = 0,
    @ColorInt val primaryDarkColor: Int = 0,
    @ColorInt val accentColor: Int = 0
)
