package prieto.fernando.darkpicker.util

import android.annotation.SuppressLint
import prieto.fernando.darkpicker.R
import prieto.fernando.darkpicker.model.Theme
import java.util.*

class ThemeProvider {
    val THEME_RED = 0
    val THEME_PINK = 1
    val THEME_PURPLE = 2
    val THEME_DEEPPURPLE = 3
    val THEME_INDIGO = 4
    val THEME_BLUE = 5
    val THEME_LIGHTBLUE = 6
    val THEME_CYAN = 7
    val THEME_TEAL = 8
    val THEME_GREEN = 9
    val THEME_LIGHTGREEN = 10
    val THEME_LIME = 11
    val THEME_YELLOW = 12
    val THEME_AMBER = 13
    val THEME_ORANGE = 14
    val THEME_DEEPORANGE = 15
    val THEME_BROWN = 16
    val THEME_GRAY = 17
    val THEME_BLUEGRAY = 18

    fun getThemeId(theme: Int): Int {
        var themeId = 0
        when (theme) {
            THEME_RED -> themeId = R.style.AppTheme_RED
            THEME_PINK -> themeId = R.style.AppTheme_PINK
            THEME_PURPLE -> themeId = R.style.AppTheme_PURPLE
            THEME_DEEPPURPLE -> themeId = R.style.AppTheme_DEEPPURPLE
            THEME_INDIGO -> themeId = R.style.AppTheme_INDIGO
            THEME_BLUE -> themeId = R.style.AppTheme_BLUE
            THEME_LIGHTBLUE -> themeId = R.style.AppTheme_LIGHTBLUE
            THEME_CYAN -> themeId = R.style.AppTheme_CYAN
            THEME_TEAL -> themeId = R.style.AppTheme_TEAL
            THEME_GREEN -> themeId = R.style.AppTheme_GREEN
            THEME_LIGHTGREEN -> themeId = R.style.AppTheme_LIGHTGREEN
            THEME_LIME -> themeId = R.style.AppTheme_LIME
            THEME_YELLOW -> themeId = R.style.AppTheme_YELLOW
            THEME_AMBER -> themeId = R.style.AppTheme_AMBER
            THEME_ORANGE -> themeId = R.style.AppTheme_ORANGE
            THEME_DEEPORANGE -> themeId = R.style.AppTheme_DEEPORANGE
            THEME_BROWN -> themeId = R.style.AppTheme_BROWN
            THEME_GRAY -> themeId = R.style.AppTheme_GRAY
            THEME_BLUEGRAY -> themeId = R.style.AppTheme_BLUEGRAY
            else -> {
            }
        }
        return themeId
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