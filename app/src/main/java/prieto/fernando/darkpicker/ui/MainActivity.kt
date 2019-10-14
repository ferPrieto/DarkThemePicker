package prieto.fernando.darkpicker.ui

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.divyanshu.colorseekbar.ColorSeekBar
import kotlinx.android.synthetic.main.main_activity.*
import prieto.fernando.darkpicker.R
import prieto.fernando.darkpicker.model.Theme
import prieto.fernando.darkpicker.presentation.MainViewModel
import prieto.fernando.darkpicker.util.ThemeProvider
import prieto.fernando.darkpicker.widget.ThemeMode
import javax.inject.Inject

class MainActivity : BaseActivity<MainViewModel>() {
    @Inject
    protected lateinit var themeProvider: ThemeProvider

    private val themes = mutableListOf<Theme>()

    override fun onResume() {
        super.onResume()
        viewModel.inputs.applyTheme(ThemeMode.DARK)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTheme(themeProvider.getSelectedStyle())

        setContentView(R.layout.main_activity)
        prepareThemeData()
        theme_selected.setTheme(themes[1])

        color_seek_bar.setOnColorChangeListener(object : ColorSeekBar.OnColorChangeListener {
            override fun onColorChangeListener(color: Int) {
                val hexadecimalColour = getHexadecimalColour(color)
                themeProvider.setSelectedColour(hexadecimalColour)

                theme_selected.postDelayed({
                    this@MainActivity.recreate()
                }, 1000)
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
