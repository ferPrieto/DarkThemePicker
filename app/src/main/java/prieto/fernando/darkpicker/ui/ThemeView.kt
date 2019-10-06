package prieto.fernando.darkpicker.ui

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import androidx.core.content.ContextCompat
import prieto.fernando.darkpicker.R
import prieto.fernando.darkpicker.model.Theme

const val EIGHTY_PERCENT = 8 / 100f
const val SIXTEEN_PERCENT = 16 / 100f
const val SEVENTY_TWO_PERCENT = 72 / 100f
const val TWENTY_PERCENT = 20 / 100f

class ThemeView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    @SuppressLint("ResourceAsColor")
    private var theme =
        Theme(R.color.primaryColorAmber, R.color.primaryDarkColorAmber, R.color.secondaryColorAmber)

    private lateinit var boarderPaint: Paint
    private lateinit var primaryPaint: Paint
    private lateinit var primaryDarkPaint: Paint
    private lateinit var accentPaint: Paint
    private lateinit var backgroundPaint: Paint
    private var stroke: Float = 0f

    fun setTheme(theme: Theme) {
        this.theme = theme
        init()
        invalidate()
    }

    private fun init() {
        try {
            setupBoarderPaint()
            setupBackgroundPaint()
            setupPrimaryDarkPaint()
            setupPrimaryPaint()
            setupAccentPaint()
        } catch (ex: Exception) {
            ex.printStackTrace()
        }

    }

    private fun setupBoarderPaint() {
        boarderPaint = Paint()
        boarderPaint.style = Paint.Style.STROKE
        boarderPaint.color = getBoarderPaintColor()
    }

    private fun setupBackgroundPaint() {
        backgroundPaint = Paint()
        backgroundPaint.style = Paint.Style.FILL
        val typedValue = TypedValue()
        context.theme.resolveAttribute(android.R.attr.windowBackground, typedValue, true)
        backgroundPaint.color = getBackgroundPaintColor(typedValue)
    }

    @SuppressLint("ResourceType")
    private fun setupPrimaryDarkPaint() {
        primaryDarkPaint = Paint()
        primaryDarkPaint.style = Paint.Style.FILL
        primaryDarkPaint.color = ContextCompat.getColor(
            context,
            theme.primaryDarkColor
        )
    }

    @SuppressLint("ResourceType")
    private fun setupPrimaryPaint() {
        primaryPaint = Paint()
        primaryPaint.style = Paint.Style.FILL
        primaryPaint.color = ContextCompat.getColor(context, theme.primaryColor)
    }

    @SuppressLint("ResourceType")
    private fun setupAccentPaint() {
        accentPaint = Paint()
        accentPaint.style = Paint.Style.FILL
        accentPaint.color = ContextCompat.getColor(context, theme.accentColor)
        accentPaint.isAntiAlias = true
        accentPaint.isDither = true
    }

    private fun getBoarderPaintColor() = if (isSelected) {
        Color.BLUE
    } else {
        Color.GRAY
    }

    private fun getBackgroundPaintColor(typedValue: TypedValue) =
        if (typedValue.type >= TypedValue.TYPE_FIRST_COLOR_INT && typedValue.type <= TypedValue.TYPE_LAST_COLOR_INT) {
            typedValue.data
        } else {
            android.R.color.background_light
        }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val height = height.toFloat()
        val width = width.toFloat()
        stroke = height * EIGHTY_PERCENT
        val statusBar = height * SIXTEEN_PERCENT
        val toolbar = height * SEVENTY_TWO_PERCENT

        boarderPaint.color = getBoarderPaintContextCompatColor()
        boarderPaint.strokeWidth = stroke
        canvas.drawRect(0f, 0f, width, height, backgroundPaint)
        canvas.drawRect(0f, 0f, width, statusBar, primaryDarkPaint)
        canvas.drawRect(0f, statusBar, width, toolbar, primaryPaint)
        canvas.drawCircle(
            width - stroke - height * TWENTY_PERCENT,
            toolbar,
            height * SIXTEEN_PERCENT,
            accentPaint
        )
        canvas.drawRect(0f, 0f, width, height, boarderPaint)
    }

    private fun getBoarderPaintContextCompatColor() = if (isActivated) {
        ContextCompat.getColor(context, R.color.themeSelected)
    } else {
        ContextCompat.getColor(context, R.color.themeDeselected)
    }
}
