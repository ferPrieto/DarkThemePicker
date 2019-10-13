package prieto.fernando.darkpicker.util

import android.annotation.SuppressLint
import prieto.fernando.darkpicker.R
import prieto.fernando.darkpicker.model.Theme
import java.util.*

class ThemeProvider {
    var selectedTheme = "#000000"

    fun getThemeId(hexadecimalColour: String) = when {
        isBlackRange(hexadecimalColour) -> R.style.AppTheme_BLACK
        isRedRange(hexadecimalColour) -> R.style.AppTheme_RED
        isDeepOrangeRange(hexadecimalColour) -> R.style.AppTheme_DEEPORANGE
        isAmberRange(hexadecimalColour) -> R.style.AppTheme_AMBER
        isOrangeRange(hexadecimalColour) -> R.style.AppTheme_ORANGE
        isYellowRange(hexadecimalColour) -> R.style.AppTheme_YELLOW
        isLimeRange(hexadecimalColour) -> R.style.AppTheme_LIME
        isLightGreenRange(hexadecimalColour) -> R.style.AppTheme_LIGHTGREEN
        isGreenRange(hexadecimalColour) -> R.style.AppTheme_GREEN
        isTealRange(hexadecimalColour) -> R.style.AppTheme_TEAL
        isIndigoRange(hexadecimalColour) -> R.style.AppTheme_INDIGO
        isLightBlueRange(hexadecimalColour) -> R.style.AppTheme_LIGHTBLUE
        isCyanRange(hexadecimalColour) -> R.style.AppTheme_CYAN
        isBlueRange(hexadecimalColour) -> R.style.AppTheme_BLUE
        isPurpleRange(hexadecimalColour) -> R.style.AppTheme_PURPLE
        isDeepPurpleRange(hexadecimalColour) -> R.style.AppTheme_DEEPPURPLE
        isPinkRange(hexadecimalColour) -> R.style.AppTheme_PINK
        isBrownRange(hexadecimalColour) -> R.style.AppTheme_BROWN
        else -> {
            R.style.AppTheme_GRAY
        }
    }

    private fun isBlackRange(hexadecimalColour: String) =
        listOf(
            "#000000",
            "#060202", "#110606",
            "#180808", "#200A0A",
            "#270C0C", "#2B0E0E",
            "#300F0F", "#351111",
            "#371212", "#3C1313",
            "#461616", "#4A1818",
            "#4C1818", "#4C1818",
            "#511A1A", "#561C1C"
        ).contains(hexadecimalColour)

    private fun isRedRange(hexadecimalColour: String) =
        listOf(
            "#5A1D1D",
            "#5F1F1F", "#702424",
            "#7B2727", "#812A2A",
            "#852B2B", "#872B2B",
            "#872B2B", "#902E2E",
            "#932F2F", "#963030",
            "#9C3232", "#A03434",
            "#A83636", "#AA3737",
            "#AF3838", "#B63B3B",
            "#B93B3B", "#BD3D3D",
            "#C33F3F", "#C84040",
            "#CD4242", "#D44444",
            "#D94646", "#DE4747",
            "#E04848"
        ).contains(hexadecimalColour)

    private fun isDeepOrangeRange(hexadecimalColour: String) =
        listOf(
            "#DC4747",
            "#E54A4A",
            "#E54A4A",
            "#EB4C4C",
            "#F04D4D",
            "#F54F4F",
            "#FA5050",
            "#FA5050",
            "#FF5252",
            "#FF5552",
            "#FF5851",
            "#FF5A51",
            "#FF5D50",
            "#FF6150",
            "#FF644F"
        ).contains(hexadecimalColour)

    private fun isOrangeRange(hexadecimalColour: String) =
        listOf(
            "#FF674F",
            "#FF6A4E",
            "#FF6D4E",
            "#FF6F4E",
            "#FF774C",
            "#FF7A4C",
            "#FF7C4C",
            "#FF7F4B",
            "#FF824B",
            "#FF844A",
            "#FF874A",
            "#FF8A4A",
            "#FF8D49",
            "#FF9149",
            "#FF9448",
            "#FF9648"
        ).contains(hexadecimalColour)

    private fun isAmberRange(hexadecimalColour: String) =
        listOf(
            "#FF9947",
            "#FF9F46",
            "#FFA246",
            "#FFA546",
            "#FFA845",
            "#FFAB45",
            "#FFAE44",
            "#FFB144",
            "#FFB443",
            "#FFB743",
            "#FFB743",
            "#FFBA42",
            "#FFBD42",
            "#FFC341",
            "#FFC541",
            "#FFC641",
            "#FFC940",
            "#FFC940",
            "#FFCF3F"
        ).contains(hexadecimalColour)

    private fun isYellowRange(hexadecimalColour: String) =
        listOf(
            "#FFD23F",
            "#FFCF3F",
            "#FFD23F",
            "#FFD23F",
            "#FFD53E",
            "#FFD83E",
            "#FFDB3D",
            "#FFDE3D",
            "#FFE13C",
            "#FFE43C",
            "#FFE73C",
            "#FFEA3B",
            "#FCEB3B",
            "#F7EA3C",
            "#F3E93C"
        ).contains(hexadecimalColour)

    private fun isLimeRange(hexadecimalColour: String) =
        listOf(
            "#EDE83D",
            "#E8E83D",
            "#E3E73E",
            "#DDE63E",
            "#D9E63F",
            "#D4E53F",
            "#D0E43F",
            "#C8E340"
        ).contains(hexadecimalColour)

    private fun isLightGreenRange(hexadecimalColour: String) =
        listOf(
            "#C5E340",
            "#C5E340",
            "#C0E241",
            "#BBE241",
            "#B6E142",
            "#B1E042",
            "#ADE043",
            "#A8DF43",
            "#A3DE44",
            "#9EDE44",
            "#98DD45",
            "#93DC45",
            "#8EDC46",
            "#87DB46",
            "#85DA47",
            "#80DA47"
        ).contains(hexadecimalColour)

    private fun isGreenRange(hexadecimalColour: String) =
        listOf(
            "#80DA47",
            "#74D848",
            "#69D649",
            "#67D649",
            "#62D54A",
            "#5DD54A",
            "#58D44B",
            "#58D44B",
            "#53D34B",
            "#4ED34C",
            "#42D14D",
            "#3ED04D",
            "#3AD04E"
        ).contains(hexadecimalColour)

    private fun isIndigoRange(hexadecimalColour: String) =
        listOf(
            "#1B9AFE",
            "#2592FE",
            "#288FFE",
            "#2E8AFE",
            "#3386FE",
            "#3684FD",
            "#3882FD",
            "#3B7FFD",
            "#3E7DFD",
            "#4279FD",
            "#4776FD",
            "#4A73FD",
            "#4D71FD",
            "#4E6FFD"
        ).contains(hexadecimalColour)

    private fun isTealRange(hexadecimalColour: String) =
        listOf(
            "#35CF4E",
            "#35CF4E",
            "#30CF4E",
            "#2BCE4F",
            "#27CD4F",
            "#21CD50",
            "#1ACC51",
            "#17CB51",
            "#12CA51",
            "#0DCA52",
            "#08C952",
            "#02C853",
            "#00C856",
            "#00C75D",
            "#00C65E",
            "#00C662",
            "#00C665",
            "#00C568",
            "#00C46E",
            "#00C471",
            "#00C374",
            "#00C376",
            "#00C379",
            "#00C27F",
            "#00C186",
            "#00BF90",
            "#00BF97",
            "#00BE99",
            "#00BE9B",
            "#00BE97",
            "#00BF94",
            "#00BF90",
            "#00C08D"
        ).contains(hexadecimalColour)

    private fun isLightBlueRange(hexadecimalColour: String) =
        listOf(
            "#00B7CA",
            "#00B7D0",
            "#00B7D0",
            "#00B6D5",
            "#00B6D7",
            "#00B5DA",
            "#00B5DD",
            "#00B4E1",
            "#00B4E4"
        ).contains(hexadecimalColour)

    private fun isCyanRange(hexadecimalColour: String) =
        listOf(
            "#00BE9C",
            "#00BE9E",
            "#00BDA1",
            "#00BCA7",
            "#00BCAB",
            "#00BBAF",
            "#00BBB2",
            "#00BAB9",
            "#00B9BC",
            "#00B9BF",
            "#00B8C2",
            "#00B8C7"

        ).contains(hexadecimalColour)

    private fun isBlueRange(hexadecimalColour: String) =
        listOf(
            "#00B4E1",
            "#00B4E5",
            "#00B3E9",
            "#00B3EB",
            "#00B2EE",
            "#00B2F0",
            "#00B2F3",
            "#00B1F6",
            "#00B1F8",
            "#00B1FB",
            "#00B0FD",
            "#03AEFF",
            "#05ACFF",
            "#08AAFF",
            "#0BA7FF",
            "#0EA5FF",
            "#12A1FE",
            "#159FFE",
            "#199BFE"
        ).contains(hexadecimalColour)

    private fun isPurpleRange(hexadecimalColour: String) =
        listOf(
            "#7251FC",
            "#7F47FB",
            "#8344FB",
            "#8642FB",
            "#893FFB",
            "#8C3DFB",
            "#8F3AFB",
            "#9337FB",
            "#9634FB",
            "#9C2FFB",
            "#9F2CFB",
            "#A429FA",
            "#A329FA"
        ).contains(hexadecimalColour)

    private fun isDeepPurpleRange(hexadecimalColour: String) =
        listOf(
            "#526CFD",
            "#556AFD",
            "#5867FD",
            "#5B65FC",
            "#5E62FC",
            "#625FFC",
            "#655CFC",
            "#685AFC",
            "#6B57FC",
            "#6E55FC",
            "#7251FC",
            "#7251FC",
            "#764FFC"
        ).contains(hexadecimalColour)

    private fun isPinkRange(hexadecimalColour: String) =
        listOf(
            "#A726FA",
            "#B31CFA",
            "#B61AFA",
            "#B917FA",
            "#BC15FA",
            "#C011FA",
            "#C30FFA",
            "#C60CF9",
            "#C90AF9",
            "#CC07F9",
            "#D500F9",
            "#D501F8",
            "#D303F5",
            "#D304F4",
            "#D107F0",
            "#D008EE",
            "#CF09ED",
            "#CE0BEB",
            "#CD0DE7",
            "#CC0EE6",
            "#CB10E4",
            "#CA11E1",
            "#C913DF",
            "#C814DD",
            "#C618D9",
            "#C518D8",
            "#C41AD6",
            "#C31BD4",
            "#C31BD4",
            "#C21ED1",
            "#C020CE",
            "#BF22CB",
            "#BE23C9",
            "#BD24C7",
            "#BD25C6",
            "#BB27C4",
            "#BA29C1",
            "#B82CBD",
            "#B72DBB",
            "#B72EBA",
            "#B630B8",
            "#B531B6",
            "#B433B4",
            "#B433B4",
            "#B334B2",
            "#B236B0"
        ).contains(hexadecimalColour)

    private fun isBrownRange(hexadecimalColour: String) =
        listOf(
            "#B236B0",
            "#AD3DA6",
            "#A8449C",
            "#A54996",
            "#9E5585",
            "#985D7B",
            "#91686C",
            "#8D6E63"
        ).contains(hexadecimalColour)

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