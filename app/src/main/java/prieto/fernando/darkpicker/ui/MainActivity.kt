package prieto.fernando.darkpicker.ui

import android.os.Bundle
import com.divyanshu.colorseekbar.ColorSeekBar
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.main_activity.*
import prieto.fernando.darkpicker.R
import prieto.fernando.darkpicker.model.Theme
import prieto.fernando.darkpicker.util.ThemeProvider
import javax.inject.Inject


class MainActivity : DaggerAppCompatActivity() {
    @Inject
    protected lateinit var themeProvider: ThemeProvider

    private val themes = mutableListOf<Theme>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTheme(themeProvider.getThemeId(themeProvider.selectedTheme))

        setContentView(R.layout.main_activity)
        prepareThemeData()
        theme_selected.setTheme(themes[1])

        color_seek_bar.setOnColorChangeListener(object : ColorSeekBar.OnColorChangeListener {
            override fun onColorChangeListener(color: Int) {
                themeProvider.selectedTheme = getHexadecimalColour(color)

                theme_selected.postDelayed({
                    this@MainActivity.recreate()
                }, 1000)
            }
        })
    }

    private fun getHexadecimalColour(colour: Int) = String.format("#%06X", 0xFFFFFF and colour)

    private fun prepareThemeData() {
        themes.clear()
        themes.addAll(ThemeProvider().getThemeList())
    }
}
