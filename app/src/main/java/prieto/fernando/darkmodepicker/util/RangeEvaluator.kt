package prieto.fernando.darkmodepicker.util

import java.lang.Long

class RangeEvaluator {

    fun isRedRange(red: String): Boolean {
        val range = "#5A1D1D".getColourLong().rangeTo("#E04848".getColourLong())
        return red.getColourLong() in range
    }

    fun isDeepOrangeRange(deepOrange: String): Boolean {
        val range = "#DC4747".getColourLong().rangeTo("#FF644F".getColourLong())
        return deepOrange.getColourLong() in range
    }

    fun isOrangeRange(orange: String): Boolean {
        val range = "#FF674F".getColourLong().rangeTo("#FF9648".getColourLong())
        return orange.getColourLong() in range
    }

    fun isAmberRange(amber: String): Boolean {
        val range = "#FF9649".getColourLong().rangeTo("#FFCF3F".getColourLong())
        return amber.getColourLong() in range
    }

    fun isYellowRange(yellow: String): Boolean {
        val range = "#FFCF40".getColourLong().rangeTo("#FFEA3B".getColourLong())
        return yellow.getColourLong() in range
    }

    fun isLimeRange(lime: String): Boolean {
        val range = "#C8E340".getColourLong().rangeTo("#DDE63E".getColourLong())
        return lime.getColourLong() in range
    }

    fun isLightGreenRange(lightGreen: String): Boolean {
        val range = "#80DA47".getColourLong().rangeTo("#C5E340".getColourLong())
        return lightGreen.getColourLong() in range
    }

    fun isGreenRange(green: String): Boolean {
        val range = "#3AD04E".getColourLong().rangeTo("#80DA46".getColourLong())
        return green.getColourLong() in range
    }

    fun isIndigoRange(indigo: String): Boolean {
        val range = "#3AD04E".getColourLong().rangeTo("#3882FD".getColourLong())
        return indigo.getColourLong() in range
    }

    fun isTealRange(teal: String) =
        listOf(
            "#35CF4E", "#35CF4E", "#30CF4E", "#2BCE4F", "#27CD4F", "#21CD50", "#1ACC51",
            "#17CB51", "#12CA51", "#0DCA52", "#08C952", "#02C853", "#00C856", "#00C75D",
            "#00C65E", "#00C662", "#00C665", "#00C568", "#00C46E", "#00C471", "#00C374",
            "#00C376", "#00C379", "#00C27F", "#00C186", "#00BF90", "#00BF97", "#00BE99",
            "#00BE9B", "#00BE97", "#00BF94", "#00BF90", "#00C08D"
        ).contains(teal)

    fun isLightBlueRange(lightBlue: String): Boolean {
        val range = "#00B4E4".getColourLong().rangeTo("#00B7CA".getColourLong())
        return lightBlue.getColourLong() in range
    }

    fun isCyanRange(cyan: String): Boolean {
        val range = "#00B8C7".getColourLong().rangeTo("#00BE9C".getColourLong())
        return cyan.getColourLong() in range
    }

    fun isBlueRange(blue: String): Boolean {
        val rangeFirst = "#00B0FD".getColourLong().rangeTo("#00B4E1".getColourLong())
        val rangeSecond = "#12A1FE".getColourLong().rangeTo("#199BFE".getColourLong())
        val otherBlues = listOf(
            "#03AEFF", "#05ACFF", "#08AAFF", "#0BA7FF"
        )

        return (blue.getColourLong() in rangeFirst) ||
                (blue.getColourLong() in rangeSecond) ||
                otherBlues.contains(blue)
    }

    fun isPinkRange(
        hexadecimalColour: String
    ) =
        listOf(
            "#A726FA", "#B31CFA", "#B61AFA", "#B917FA", "#BC15FA", "#C011FA", "#C30FFA",
            "#C60CF9", "#C90AF9", "#CC07F9", "#D500F9", "#D501F8", "#D303F5", "#D304F4",
            "#D107F0", "#D008EE", "#CF09ED", "#CE0BEB", "#CD0DE7", "#CC0EE6", "#CB10E4",
            "#CA11E1", "#C913DF", "#C814DD", "#C618D9", "#C518D8", "#C41AD6", "#C31BD4",
            "#C31BD4", "#C21ED1", "#C020CE", "#BF22CB", "#BE23C9", "#BD24C7", "#BD25C6",
            "#BB27C4", "#BA29C1", "#B82CBD", "#B72DBB", "#B72EBA", "#B630B8", "#B531B6",
            "#B433B4", "#B433B4", "#B334B2", "#B236B0"
        ).contains(hexadecimalColour)

    private fun String.getColourLong() =
        Long.parseLong(this.removePrefix("#"), 16)
}
