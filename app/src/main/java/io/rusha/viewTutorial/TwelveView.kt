package io.rusha.viewTutorial

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.text.TextPaint
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View

class TwelveView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0, defStyleRes: Int = 0
) : View(context, attrs, defStyleAttr, defStyleRes) {

    private val digitPaint = TextPaint()

    private var side: Int

    init {
        val defaultSideDp = 40f
        val defaultSide = TypedValue.applyDimension( // конвертация dp -> px
            TypedValue.COMPLEX_UNIT_DIP,
            defaultSideDp,
            context.resources.displayMetrics
        ).toInt()
        val array = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CountdownView,
            defStyleAttr,
            defStyleRes
        )
        try {
            side = array.getDimensionPixelSize(
                R.styleable.CountdownView_side,
                defaultSide
            )
        } catch (e: Exception) {
            side = defaultSide
        } finally {
            array.recycle()
        }
        digitPaint.color = Color.RED
        digitPaint.textSize = side.toFloat()
        digitPaint.typeface = Typeface.DEFAULT
        digitPaint.style = Paint.Style.FILL
        digitPaint.textAlign = Paint.Align.RIGHT
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(
            MeasureSpec.makeMeasureSpec(
                side,
                MeasureSpec.EXACTLY
            ),
            MeasureSpec.makeMeasureSpec(
                side,
                MeasureSpec.EXACTLY
            )
        )
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawText(
            "12",
            width.toFloat(),
            height.toFloat(),
            digitPaint
        )
    }
}