package prieto.fernando.darkpicker.widget

import android.content.Context

import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.annotation.ArrayRes
import prieto.fernando.darkpicker.R
import kotlin.math.roundToInt

class ColorSeekBar(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {

    private val minThumbRadius = 16f
    private var colorSeeds = intArrayOf(
        Color.parseColor("#5A1D1D"),
        Color.parseColor("#E04848"),
        Color.parseColor("#DC4747"),
        Color.parseColor("#FF644F"),
        Color.parseColor("#FF9648"),
        Color.parseColor("#FF9649"),
        Color.parseColor("#FFCF3F"),
        Color.parseColor("#FFCF40"),
        Color.parseColor("#FFEA3B"),
        Color.parseColor("#C8E340"),
        Color.parseColor("#DDE63E"),
        Color.parseColor("#80DA47"),
        Color.parseColor("#C5E340"),
        Color.parseColor("#3AD04E"),
        Color.parseColor("#35CF4E"),
        Color.parseColor("#00C08D"),
        Color.parseColor("#00B4E4"),
        Color.parseColor("#00B7CA"),
        Color.parseColor("#00B8C7"),
        Color.parseColor("#00BE9C"),
        Color.parseColor("#00B0FD"),
        Color.parseColor("#00B4E1"),
        Color.parseColor("#3882FD"),
        Color.parseColor("#12A1FE"),
        Color.parseColor("#199BFE"),
        Color.parseColor("#03AEFF"),
        Color.parseColor("#05ACFF"),
        Color.parseColor("#08AAFF"),
        Color.parseColor("#0BA7FF"),
        Color.parseColor("#A726FA"),
        Color.parseColor("#B236B0"),
        Color.parseColor("#C90AF9"),
        Color.parseColor("#CC07F9")

    )
    private var canvasHeight: Int = 60
    private var barHeight: Int = 20
    private var rectf: RectF = RectF()
    private var rectPaint: Paint = Paint()
    private var thumbBorderPaint: Paint = Paint()
    private var thumbPaint: Paint = Paint()
    private lateinit var colorGradient: LinearGradient
    private var thumbX: Float = 24f
    private var thumbY: Float = (canvasHeight / 2).toFloat()
    private var thumbBorder: Float = 4f
    private var thumbRadius: Float = 16f
    private var thumbBorderRadius: Float = thumbRadius + thumbBorder
    private var thumbBorderColor = Color.BLACK
    private var paddingStart = 30f
    private var paddingEnd = 30f
    private var barCornerRadius: Float = 8f
    private var oldThumbRadius = thumbRadius
    private var oldThumbBorderRadius = thumbBorderRadius
    private var colorChangeListener: OnColorChangeListener? = null

    init {
        attributeSet.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.ColorSeekBar)
            val colorsId = typedArray.getResourceId(R.styleable.ColorSeekBar_colorSeeds, 0)
            if (colorsId != 0) colorSeeds = getColorsById(colorsId)
            barCornerRadius = typedArray.getDimension(R.styleable.ColorSeekBar_cornerRadius, 8f)
            barHeight = typedArray.getDimension(R.styleable.ColorSeekBar_barHeight, 20f).toInt()
            thumbBorder = typedArray.getDimension(R.styleable.ColorSeekBar_thumbBorder, 2f)
            thumbBorderColor =
                typedArray.getColor(R.styleable.ColorSeekBar_thumbBorderColor, Color.WHITE)
            typedArray.recycle()
        }
        rectPaint.isAntiAlias = true

        thumbBorderPaint.isAntiAlias = true
        thumbBorderPaint.color = thumbBorderColor

        thumbPaint.isAntiAlias = true

        thumbRadius = (barHeight / 2).toFloat().let {
            if (it < minThumbRadius) minThumbRadius else it
        }
        thumbBorderRadius = thumbRadius + thumbBorder
        canvasHeight = (thumbBorderRadius * 4).toInt()
        thumbY = (canvasHeight / 2).toFloat()

        oldThumbRadius = thumbRadius
        oldThumbBorderRadius = thumbBorderRadius
    }

    private fun getColorsById(@ArrayRes id: Int): IntArray {
        if (isInEditMode) {
            val s = context.resources.getStringArray(id)
            val colors = IntArray(s.size)
            for (j in s.indices) {
                colors[j] = Color.parseColor(s[j])
            }
            return colors
        } else {
            val typedArray = context.resources.obtainTypedArray(id)
            val colors = IntArray(typedArray.length())
            for (j in 0 until typedArray.length()) {
                colors[j] = typedArray.getColor(j, Color.BLACK)
            }
            typedArray.recycle()
            return colors
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        //color bar position
        val barLeft: Float = paddingStart
        val barRight: Float = width.toFloat() - paddingEnd
        val barTop: Float = ((canvasHeight / 2) - (barHeight / 2)).toFloat()
        val barBottom: Float = ((canvasHeight / 2) + (barHeight / 2)).toFloat()

        //draw color bar
        rectf.set(barLeft, barTop, barRight, barBottom)
        canvas?.drawRoundRect(rectf, barCornerRadius, barCornerRadius, rectPaint)

        if (thumbX < barLeft) {
            thumbX = barLeft
        } else if (thumbX > barRight) {
            thumbX = barRight
        }
        val color = pickColor(thumbX, width)
        thumbPaint.color = color

        // draw color bar thumb
        canvas?.drawCircle(thumbX, thumbY, thumbBorderRadius, thumbBorderPaint)
        canvas?.drawCircle(thumbX, thumbY, thumbRadius, thumbPaint)
    }

    private fun pickColor(position: Float, canvasWidth: Int): Int {
        val value = (position - paddingStart) / (canvasWidth - (paddingStart + paddingEnd))
        when {
            value <= 0.0 -> return colorSeeds[0]
            value >= 1 -> return colorSeeds[colorSeeds.size - 1]
            else -> {
                var colorPosition = value * (colorSeeds.size - 1)
                val i = colorPosition.toInt()
                colorPosition -= i
                val c0 = colorSeeds[i]
                val c1 = colorSeeds[i + 1]

                val red = mix(Color.red(c0), Color.red(c1), colorPosition)
                val green = mix(Color.green(c0), Color.green(c1), colorPosition)
                val blue = mix(Color.blue(c0), Color.blue(c1), colorPosition)
                return Color.rgb(red, green, blue)
            }
        }
    }

    private fun mix(start: Int, end: Int, position: Float): Int {
        return start + (position * (end - start)).roundToInt()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        colorGradient =
            LinearGradient(0f, 0f, w.toFloat(), 0f, colorSeeds, null, Shader.TileMode.CLAMP)
        rectPaint.shader = colorGradient
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(widthMeasureSpec, canvasHeight)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                thumbBorderRadius = (oldThumbBorderRadius * 2)
                thumbRadius = (oldThumbRadius * 2)
            }
            MotionEvent.ACTION_MOVE -> {
                parent.requestDisallowInterceptTouchEvent(true)
                event.x.let {
                    thumbX = it
                    invalidate()
                }
            }
            MotionEvent.ACTION_UP -> {
                thumbBorderRadius = oldThumbBorderRadius
                thumbRadius = oldThumbRadius
                invalidate()
                colorChangeListener?.onColorChangeListener(getHexadecimalColour())
            }
        }
        return true
    }

    fun setOnColorChangeListener(onColorChangeListener: OnColorChangeListener) {
        this.colorChangeListener = onColorChangeListener
    }

    private fun getHexadecimalColour() = String.format("#%06X", 0xFFFFFF and thumbPaint.color)

    interface OnColorChangeListener {

        fun onColorChangeListener(color: String)
    }
}
