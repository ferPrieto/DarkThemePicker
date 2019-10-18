package prieto.fernando.darkpicker.util

import android.annotation.SuppressLint
import prieto.fernando.darkpicker.R
import prieto.fernando.darkpicker.model.Theme
import java.util.*

class ThemeProvider constructor(
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
    fun getThemeList(): ArrayList<Theme> {
        val themeArrayList = ArrayList<Theme>()
        themeArrayList.add(
            Theme(
                0,
                R.color.primaryColorRed,
                R.color.primaryDarkColorRed,
                R.color.secondaryColorRed
            )
        )
        themeArrayList.add(
            Theme(
                1,
                R.color.primaryColorPink,
                R.color.primaryDarkColorPink,
                R.color.secondaryColorPink
            )
        )
        themeArrayList.add(
            Theme(
                2,
                R.color.primaryColorPurple,
                R.color.primaryDarkColorPurple,
                R.color.secondaryColorPurple
            )
        )
        themeArrayList.add(
            Theme(
                3,
                R.color.primaryColorDeepPurple,
                R.color.primaryDarkColorDeepPurple,
                R.color.secondaryColorDeepPurple
            )
        )
        themeArrayList.add(
            Theme(
                4,
                R.color.primaryColorIndigo,
                R.color.primaryDarkColorIndigo,
                R.color.secondaryColorIndigo
            )
        )
        themeArrayList.add(
            Theme(
                5,
                R.color.primaryColorBlue,
                R.color.primaryDarkColorBlue,
                R.color.secondaryColorBlue
            )
        )
        themeArrayList.add(
            Theme(
                6,
                R.color.primaryColorLightBlue,
                R.color.primaryDarkColorLightBlue,
                R.color.secondaryColorLightBlue
            )
        )
        themeArrayList.add(
            Theme(
                7,
                R.color.primaryColorCyan,
                R.color.primaryDarkColorCyan,
                R.color.secondaryColorCyan
            )
        )
        themeArrayList.add(
            Theme(
                8,
                R.color.primaryColorTeal,
                R.color.primaryDarkColorTeal,
                R.color.secondaryColorTeal
            )
        )
        themeArrayList.add(
            Theme(
                9,
                R.color.primaryColorGreen,
                R.color.primaryDarkColorGreen,
                R.color.secondaryColorGreen
            )
        )
        themeArrayList.add(
            Theme(
                10,
                R.color.primaryColorLightGreen,
                R.color.primaryDarkColorLightGreen,
                R.color.secondaryColorLightGreen
            )
        )
        themeArrayList.add(
            Theme(
                11,
                R.color.primaryColorLime,
                R.color.primaryDarkColorLime,
                R.color.secondaryColorLime
            )
        )
        themeArrayList.add(
            Theme(
                12,
                R.color.primaryColorYellow,
                R.color.primaryDarkColorYellow,
                R.color.secondaryColorYellow
            )
        )
        themeArrayList.add(
            Theme(
                13,
                R.color.primaryColorAmber,
                R.color.primaryDarkColorAmber,
                R.color.secondaryColorAmber
            )
        )
        themeArrayList.add(
            Theme(
                14,
                R.color.primaryColorOrange,
                R.color.primaryDarkColorOrange,
                R.color.secondaryColorOrange
            )
        )
        themeArrayList.add(
            Theme(
                15,
                R.color.primaryColorDeepOrange,
                R.color.primaryDarkColorDeepOrange,
                R.color.secondaryColorDeepOrange
            )
        )
        themeArrayList.add(
            Theme(
                16,
                R.color.primaryColorBrown,
                R.color.primaryDarkColorBrown,
                R.color.secondaryColorBrown
            )
        )
        themeArrayList.add(
            Theme(
                17,
                R.color.primaryColorGray,
                R.color.primaryDarkColorGray,
                R.color.secondaryColorGray
            )
        )
        themeArrayList.add(
            Theme(
                18,
                R.color.primaryColorBlueGray,
                R.color.primaryDarkColorBlueGray,
                R.color.secondaryColorBlueGray
            )
        )
        return themeArrayList
    }

}

