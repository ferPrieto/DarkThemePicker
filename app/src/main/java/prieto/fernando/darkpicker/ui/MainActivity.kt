package prieto.fernando.darkpicker.ui

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import prieto.fernando.darkpicker.R
import prieto.fernando.darkpicker.model.Theme
import prieto.fernando.darkpicker.presentation.MainViewModel
import prieto.fernando.darkpicker.util.ThemeProvider
import prieto.fernando.darkpicker.widget.ColorSeekBar
import prieto.fernando.darkpicker.widget.ThemeMode
import javax.inject.Inject
import kotlinx.android.synthetic.main.main_activity.color_seek_bar as colorSeekbar
import kotlinx.android.synthetic.main.main_activity.theme_selected as themeSelected

class MainActivity : BaseActivity<MainViewModel>() {
    @Inject
    protected lateinit var themeProvider: ThemeProvider

    private val themes = mutableListOf<Theme>()
    private var seekBarDragged = false

    override fun onResume() {
        super.onResume()
        viewModel.inputs.applyTheme(ThemeMode.DARK)
        seekBarDragged = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTheme(themeProvider.getSelectedStyle())

        setContentView(R.layout.main_activity)
        prepareThemeData()
        themeSelected.setTheme(themes[1])

        colorSeekbar.setOnColorChangeListener(object : ColorSeekBar.OnColorChangeListener {
            override fun onColorChangeListener(color: Int) {
                val hexadecimalColour = getHexadecimalColour(color)
                themeProvider.setSelectedColour(hexadecimalColour)
                this@MainActivity.recreate()
            }
        })
    }

    private fun getHexadecimalColour(colour: Int) = String.format("#%06X", 0xFFFFFF and colour)

    private fun prepareThemeData() {
        themes.clear()
        themes.addAll(themeProvider.getThemeList())
    }

    override val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this, vmFactory).get(MainViewModel::class.java)
    }
}
