package com.example.drawsmile

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import java.util.jar.Attributes
import android.graphics.Bitmap



class DrawSmileView(context:Context,attrs: AttributeSet):View(context,attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var faceColor = Color.YELLOW
    private var eyesColor = Color.BLACK
    private var mouthColor = Color.BLACK
    private var borderColor = Color.BLACK
    private var borderWidth = 4.0f
    private var size = 320
    private var sizeImage = 50
    private val mouthPath = Path()


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (canvas == null)return

        drawFaceBackground(canvas)
        drawEyes(canvas)
        drawMouth(canvas)
        addImage(canvas)

    }

    private  fun addImage(canvas: Canvas) {
        val image = BitmapFactory.decodeResource(resources,R.drawable.hollow)
        canvas.drawBitmap(image,0f,800f,null)
        sizeImage = Math.min(measuredWidth, measuredHeight)
        setMeasuredDimension(sizeImage, sizeImage)

    }


    private fun drawFaceBackground(canvas: Canvas) {

        paint.color = faceColor
        paint.style = Paint.Style.FILL

        val radius = size / 2f

        canvas.drawCircle(size / 2f, size / 2f, radius, paint)

        paint.color = borderColor
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = borderWidth
        paint.textSize = 60f
        canvas.drawCircle(size / 2f, size / 2f, radius - borderWidth / 2f, paint)
        canvas.drawText("Hello!!!",300f,300f,paint)
    }

    private fun drawEyes(canvas: Canvas) {

        paint.color = eyesColor
        paint.style = Paint.Style.FILL

        val leftEyeRect = RectF(size * 0.32f, size * 0.23f, size * 0.43f, size * 0.50f)
        canvas.drawOval(leftEyeRect, paint)
        val rightEyeRect = RectF(size * 0.57f, size * 0.23f, size * 0.68f, size * 0.50f)
        canvas.drawOval(rightEyeRect, paint)


    }

    private fun drawMouth(canvas: Canvas) {


        mouthPath.moveTo(size * 0.22f, size * 0.7f)
        mouthPath.quadTo(size * 0.50f, size * 0.80f, size * 0.78f, size * 0.70f)
        mouthPath.quadTo(size * 0.50f, size * 0.90f, size * 0.22f, size * 0.70f)
        paint.color = mouthColor
        paint.style = Paint.Style.FILL

        canvas.drawPath(mouthPath, paint)
    }

//    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
//        size = Math.min(measuredWidth, measuredHeight)
//        setMeasuredDimension(size, size)
//    }

}