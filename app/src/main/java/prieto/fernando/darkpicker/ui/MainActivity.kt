package prieto.fernando.darkpicker.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.divyanshu.colorseekbar.ColorSeekBar
import kotlinx.android.synthetic.main.main_activity.*
import prieto.fernando.darkpicker.R
import prieto.fernando.darkpicker.model.Theme
import prieto.fernando.darkpicker.util.ThemeProvider

class MainActivity : AppCompatActivity() {

    var selectedTheme = 4
    private val themes = mutableListOf<Theme>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        prepareThemeData()
        theme_selected.setTheme(themes[selectedTheme])
        val themeProvider =ThemeProvider()

        color_seek_bar.setOnColorChangeListener(object: ColorSeekBar.OnColorChangeListener{
            override fun onColorChangeListener(color: Int) {
                val colorGotten = themeProvider.getThemeId(color)
                Log.d("COLOR","$colorGotten")
            }
        })
    }

    private fun prepareThemeData() {
        themes.clear()
        themes.addAll(ThemeProvider().getThemeList())
    }
}
