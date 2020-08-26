package prieto.fernando.darkmodepicker.ui

import android.content.Context
import android.graphics.PorterDuff
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.TypedValue
import android.view.WindowManager
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.TranslateAnimation
import androidx.activity.viewModels
import androidx.annotation.AttrRes
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.draw_layout.*
import prieto.fernando.darkmodepicker.R
import prieto.fernando.darkmodepicker.model.Style
import prieto.fernando.darkmodepicker.presentation.MainViewModel
import prieto.fernando.darkmodepicker.presentation.ViewModelProviderFactory
import prieto.fernando.darkmodepicker.util.StyleProvider
import prieto.fernando.darkmodepicker.widget.ColorSeekBar
import prieto.fernando.darkmodepicker.widget.ThemeApplier
import prieto.fernando.darkmodepicker.widget.ThemeMode
import javax.inject.Inject
import kotlinx.android.synthetic.main.default_toolbar.default_toolbar as defautlToolbar
import kotlinx.android.synthetic.main.main_activity.color_seek_bar as colorSeekBar
import kotlinx.android.synthetic.main.main_activity.fab as floatingActionButton

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    protected lateinit var vmFactory: ViewModelProviderFactory<MainViewModel>

    @Inject
    protected lateinit var styleProvider: StyleProvider

    @Inject
    protected lateinit var themeApplier: ThemeApplier

    private val subscriptions = CompositeDisposable()

    private val viewModel: MainViewModel by viewModels { vmFactory }

    private val styles = mutableListOf<Style>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpTheme()
        setContentView(R.layout.main_activity)
        prepareStyleData()
        setUpViews()
    }

    private fun setUpViews() {
        val currentThemeMode = themeApplier.getCurrentMode().blockingGet()
        setFloatingActionButtonIcon(currentThemeMode)
        setupToolbar(currentThemeMode)
        setupStatusbar(currentThemeMode)
        setupDrawCardImage(currentThemeMode)
    }

    private fun setUpTheme() {
        viewModel.inputs.initTheme()
        val selectedStyle = styleProvider.getSelectedStyle()
        setTheme(selectedStyle)

        if (selectedStyle == R.style.AppTheme_GRAY) {
            showError(R.string.error_picked_colour)
        }
    }

    private fun setupToolbar(currentThemeMode: ThemeMode) {
        if (currentThemeMode == ThemeMode.DARK) {
            defautlToolbar.background =
                ColorDrawable(ContextCompat.getColor(this, R.color.darkToolbar))
            val colorPrimary = themeColor(R.attr.colorPrimary)
            defautlToolbar.setTitleTextColor(colorPrimary)
        }
    }

    private fun setupStatusbar(currentThemeMode: ThemeMode) {
        val window = window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = getStatusBarColorFromTheme(currentThemeMode)
    }

    private fun getStatusBarColorFromTheme(currentThemeMode: ThemeMode): Int {
        return if (currentThemeMode == ThemeMode.DARK) {
            ContextCompat.getColor(this, R.color.darkStatusBar)
        } else {
            themeColor(R.attr.colorPrimaryDark)
        }
    }

    private fun setupDrawCardImage(currentThemeMode: ThemeMode) {
        if (currentThemeMode == ThemeMode.DARK) {
            val colorPrimary = themeColor(R.attr.colorPrimary)
            draw_media_image.setColorFilter(colorPrimary, PorterDuff.Mode.SRC_IN)
        } else {
            draw_media_image.setColorFilter(
                ContextCompat.getColor(
                    this,
                    android.R.color.darker_gray
                ), PorterDuff.Mode.SRC_IN
            )
        }
    }

    override fun onResume() {
        super.onResume()
        animateFloatingButton()
        setupInputListeners()
        setupOutputListeners()
    }

    private fun setupOutputListeners() {
        viewModel.outputs.currentThemeModeRetrieved()
            .subscribe { themeMode ->
                setDarkLightMode(themeMode)
            }.also { subscriptions.add(it) }

        viewModel.outputs.error()
            .subscribe { errorResource ->
                showError(errorResource)
            }.also { subscriptions.add(it) }
    }

    private fun showError(errorResource: Int) {
        Snackbar.make(
            window.decorView.rootView,
            resources.getText(errorResource),
            Snackbar.LENGTH_SHORT
        ).show()
    }

    private fun setDarkLightMode(currentThemeMode: ThemeMode) {
        if (currentThemeMode == ThemeMode.DARK) {
            viewModel.inputs.applyTheme(ThemeMode.LIGHT)
        } else {
            viewModel.inputs.applyTheme(ThemeMode.DARK)
        }
    }

    private fun setFloatingActionButtonIcon(currentThemeMode: ThemeMode) {
        when (currentThemeMode) {
            ThemeMode.LIGHT -> floatingActionButton.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_dark
                )
            )
            else -> floatingActionButton.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_light
                )
            )
        }
    }

    private fun setupInputListeners() {
        colorSeekBar.setOnColorChangeListener(object : ColorSeekBar.OnColorChangeListener {
            override fun onColorChangeListener(color: String) {
                styleProvider.setSelectedColour(color)
                this@MainActivity.recreate()
            }
        })
        floatingActionButton.setOnClickListener {
            viewModel.getCurrentTheme()
        }
    }

    private fun animateFloatingButton() {
        val animation = TranslateAnimation(0f, 0f, 500f, 0f)
        animation.duration = 500
        val viewPropertyAnimator = floatingActionButton.animate()
        viewPropertyAnimator.interpolator = AccelerateDecelerateInterpolator()
        floatingActionButton.startAnimation(animation)
    }

    private fun prepareStyleData() {
        styles.clear()
        styles.addAll(styleProvider.getStyleList())
    }

    private fun Context.themeColor(@AttrRes attrRes: Int): Int {
        val typedValue = TypedValue()
        theme.resolveAttribute(attrRes, typedValue, true)
        return typedValue.data
    }

    override fun onDestroy() {
        subscriptions.clear()
        super.onDestroy()
    }
}
