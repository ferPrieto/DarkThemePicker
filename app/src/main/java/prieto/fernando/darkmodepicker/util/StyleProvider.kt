package prieto.fernando.darkmodepicker.util

import android.annotation.SuppressLint
import prieto.fernando.darkmodepicker.R
import prieto.fernando.darkmodepicker.model.Style

class StyleProvider constructor(
    private val rangeEvaluator: RangeEvaluator
) {
    private var selectedColour = "#E04848"

    fun getSelectedStyle() = getThemeStyle(selectedColour)

    fun setSelectedColour(hexadecimalColour: String) {
        selectedColour = hexadecimalColour
    }

    private fun getThemeStyle(hexadecimalColour: String) = when {
        rangeEvaluator.isPinkRange(hexadecimalColour) -> R.style.AppTheme_PINK
        rangeEvaluator.isLightGreenRange(hexadecimalColour) -> R.style.AppTheme_LIGHTGREEN
        rangeEvaluator.isGreenRange(hexadecimalColour) -> R.style.AppTheme_GREEN
        rangeEvaluator.isRedRange(hexadecimalColour) -> R.style.AppTheme_RED
        rangeEvaluator.isDeepOrangeRange(hexadecimalColour) -> R.style.AppTheme_DEEPORANGE
        rangeEvaluator.isAmberRange(hexadecimalColour) -> R.style.AppTheme_AMBER
        rangeEvaluator.isOrangeRange(hexadecimalColour) -> R.style.AppTheme_ORANGE
        rangeEvaluator.isYellowRange(hexadecimalColour) -> R.style.AppTheme_YELLOW
        rangeEvaluator.isLimeRange(hexadecimalColour) -> R.style.AppTheme_LIME
        rangeEvaluator.isTealRange(hexadecimalColour) -> R.style.AppTheme_TEAL
        rangeEvaluator.isIndigoRange(hexadecimalColour) -> R.style.AppTheme_INDIGO
        rangeEvaluator.isLightBlueRange(hexadecimalColour) -> R.style.AppTheme_LIGHTBLUE
        rangeEvaluator.isCyanRange(hexadecimalColour) -> R.style.AppTheme_CYAN
        rangeEvaluator.isBlueRange(hexadecimalColour) -> R.style.AppTheme_BLUE
        else -> {
            R.style.AppTheme_GRAY
        }
    }

    @SuppressLint("ResourceAsColor")
    fun getStyleList(): ArrayList<Style> {
        val styleArrayList = ArrayList<Style>()
        styleArrayList.add(
            Style(
                0,
                R.color.primaryColorRed,
                R.color.primaryDarkColorRed,
                R.color.secondaryColorRed
            )
        )
        styleArrayList.add(
            Style(
                1,
                R.color.primaryColorPink,
                R.color.primaryDarkColorPink,
                R.color.secondaryColorPink
            )
        )
        styleArrayList.add(
            Style(
                2,
                R.color.primaryColorPurple,
                R.color.primaryDarkColorPurple,
                R.color.secondaryColorPurple
            )
        )
        styleArrayList.add(
            Style(
                3,
                R.color.primaryColorDeepPurple,
                R.color.primaryDarkColorDeepPurple,
                R.color.secondaryColorDeepPurple
            )
        )
        styleArrayList.add(
            Style(
                4,
                R.color.primaryColorIndigo,
                R.color.primaryDarkColorIndigo,
                R.color.secondaryColorIndigo
            )
        )
        styleArrayList.add(
            Style(
                5,
                R.color.primaryColorBlue,
                R.color.primaryDarkColorBlue,
                R.color.secondaryColorBlue
            )
        )
        styleArrayList.add(
            Style(
                6,
                R.color.primaryColorLightBlue,
                R.color.primaryDarkColorLightBlue,
                R.color.secondaryColorLightBlue
            )
        )
        styleArrayList.add(
            Style(
                7,
                R.color.primaryColorCyan,
                R.color.primaryDarkColorCyan,
                R.color.secondaryColorCyan
            )
        )
        styleArrayList.add(
            Style(
                8,
                R.color.primaryColorTeal,
                R.color.primaryDarkColorTeal,
                R.color.secondaryColorTeal
            )
        )
        styleArrayList.add(
            Style(
                9,
                R.color.primaryColorGreen,
                R.color.primaryDarkColorGreen,
                R.color.secondaryColorGreen
            )
        )
        styleArrayList.add(
            Style(
                10,
                R.color.primaryColorLightGreen,
                R.color.primaryDarkColorLightGreen,
                R.color.secondaryColorLightGreen
            )
        )
        styleArrayList.add(
            Style(
                11,
                R.color.primaryColorLime,
                R.color.primaryDarkColorLime,
                R.color.secondaryColorLime
            )
        )
        styleArrayList.add(
            Style(
                12,
                R.color.primaryColorYellow,
                R.color.primaryDarkColorYellow,
                R.color.secondaryColorYellow
            )
        )
        styleArrayList.add(
            Style(
                13,
                R.color.primaryColorAmber,
                R.color.primaryDarkColorAmber,
                R.color.secondaryColorAmber
            )
        )
        styleArrayList.add(
            Style(
                14,
                R.color.primaryColorOrange,
                R.color.primaryDarkColorOrange,
                R.color.secondaryColorOrange
            )
        )
        styleArrayList.add(
            Style(
                15,
                R.color.primaryColorDeepOrange,
                R.color.primaryDarkColorDeepOrange,
                R.color.secondaryColorDeepOrange
            )
        )
        styleArrayList.add(
            Style(
                16,
                R.color.primaryColorBrown,
                R.color.primaryDarkColorBrown,
                R.color.secondaryColorBrown
            )
        )
        styleArrayList.add(
            Style(
                17,
                R.color.primaryColorGray,
                R.color.primaryDarkColorGray,
                R.color.secondaryColorGray
            )
        )
        styleArrayList.add(
            Style(
                18,
                R.color.primaryColorBlueGray,
                R.color.primaryDarkColorBlueGray,
                R.color.secondaryColorBlueGray
            )
        )
        return styleArrayList
    }
}
