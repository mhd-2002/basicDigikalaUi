package com.example.digikala.adaptor.category

import android.graphics.*
import kotlin.math.min

class CircleTransform:com.squareup.picasso.Transformation {

    override fun transform(source:Bitmap):Bitmap{
        val size=min(source.width , source.height)
        val x = (source.width-size)/2
        val y = (source.height-size)/2
        val squareBitmap= Bitmap.createBitmap(source,x,y,size,size)
        if (squareBitmap!=source){
            source.recycle()
        }

        val bitmap=Bitmap.createBitmap(size,size,source.config)
        val canvas=Canvas(bitmap)
        val paint = Paint()
        val shader= BitmapShader(squareBitmap, Shader.TileMode.CLAMP,Shader.TileMode.CLAMP )
        paint.shader=shader
        paint.isAntiAlias= true
        val r = size/2f
        canvas.drawCircle(r,r,r,paint)
        squareBitmap.recycle()

        return bitmap
    }

   override  fun key():String{
        return "circle"
    }
}