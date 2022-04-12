package com.futuretech.pdfreaderconverter.ui.filter

import android.content.Context
import android.graphics.Bitmap
import android.renderscript.*

class ColorFilters {

    private var inputAllocation: Allocation? = null
    private var outBitmap: Bitmap? = null
    private var outputAllocation: Allocation? = null
    private var renderScript: RenderScript? = null

    fun filter1(context: Context?, bitmap: Bitmap): Bitmap? {
        renderScript = RenderScript.create(context)
        outBitmap = Bitmap.createBitmap(bitmap.width, bitmap.height, bitmap.config)
        inputAllocation = Allocation.createFromBitmap(renderScript, bitmap)
        outputAllocation = Allocation.createTyped(renderScript, inputAllocation!!.type)
        val renderScript2 = renderScript
        val create = ScriptIntrinsicColorMatrix.create(renderScript2, Element.U8_4(renderScript2))
        create.setGreyscale()
        create.forEach(inputAllocation, outputAllocation)
        outputAllocation!!.copyTo(outBitmap)
        return outBitmap
    }

    fun filter2(context: Context?, bitmap: Bitmap): Bitmap? {
        renderScript = RenderScript.create(context)
        outBitmap = Bitmap.createBitmap(bitmap.width, bitmap.height, bitmap.config)
        inputAllocation = Allocation.createFromBitmap(renderScript, bitmap)
        outputAllocation = Allocation.createTyped(renderScript, inputAllocation!!.type)
        val renderScript2 = renderScript
        val create = ScriptIntrinsicColorMatrix.create(renderScript2, Element.U8_4(renderScript2))
        create.setColorMatrix(Matrix4f(floatArrayOf(-0.3597053f,
            0.37725273f,
            0.66384166f,
            0.0f,
            1.5668082f,
            0.4566682f,
            1.1261392f,
            0.0f,
            -0.14710288f,
            0.22607906f,
            -0.7299808f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            1.0f)))
        create.forEach(inputAllocation, outputAllocation)
        outputAllocation!!.copyTo(outBitmap)
        return outBitmap
    }

    fun filter3(context: Context?, bitmap: Bitmap): Bitmap? {
        renderScript = RenderScript.create(context)
        outBitmap = Bitmap.createBitmap(bitmap.width, bitmap.height, bitmap.config)
        inputAllocation = Allocation.createFromBitmap(renderScript, bitmap)
        outputAllocation = Allocation.createTyped(renderScript, inputAllocation!!.type)
        val renderScript2 = renderScript
        val create = ScriptIntrinsicColorMatrix.create(renderScript2, Element.U8_4(renderScript2))
        create.setColorMatrix(Matrix4f(floatArrayOf(1.229946f,
            0.020952377f,
            0.38324407f,
            0.0f,
            0.4501389f,
            1.1873742f,
            -0.10693325f,
            -0.34008488f,
            0.13167344f,
            1.0636892f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            11.91f,
            11.91f,
            11.91f,
            0.0f)))
        create.forEach(inputAllocation, outputAllocation)
        outputAllocation!!.copyTo(outBitmap)
        return outBitmap
    }

    fun filter4(context: Context?, bitmap: Bitmap): Bitmap? {
        renderScript = RenderScript.create(context)
        outBitmap = Bitmap.createBitmap(bitmap.width, bitmap.height, bitmap.config)
        inputAllocation = Allocation.createFromBitmap(renderScript, bitmap)
        outputAllocation = Allocation.createTyped(renderScript, inputAllocation!!.type)
        val renderScript2 = renderScript
        val create = ScriptIntrinsicColorMatrix.create(renderScript2, Element.U8_4(renderScript2))
        create.setColorMatrix(Matrix4f(floatArrayOf(1.44f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            1.44f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            1.44f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            1.0f)))
        create.forEach(inputAllocation, outputAllocation)
        outputAllocation!!.copyTo(outBitmap)
        return outBitmap
    }

    fun filter5(context: Context?, bitmap: Bitmap): Bitmap? {
        renderScript = RenderScript.create(context)
        outBitmap = Bitmap.createBitmap(bitmap.width, bitmap.height, bitmap.config)
        inputAllocation = Allocation.createFromBitmap(renderScript, bitmap)
        outputAllocation = Allocation.createTyped(renderScript, inputAllocation!!.type)
        val renderScript2 = renderScript
        val create = ScriptIntrinsicColorMatrix.create(renderScript2, Element.U8_4(renderScript2))
        create.setColorMatrix(Matrix4f(floatArrayOf(1.0f,
            0.0f,
            0.1f,
            -0.1f,
            0.0f,
            1.0f,
            0.2f,
            0.0f,
            0.0f,
            0.0f,
            1.3f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            1.0f)))
        create.forEach(inputAllocation, outputAllocation)
        outputAllocation!!.copyTo(outBitmap)
        return outBitmap
    }

    fun filter6(context: Context?, bitmap: Bitmap): Bitmap? {
        renderScript = RenderScript.create(context)
        outBitmap = Bitmap.createBitmap(bitmap.width, bitmap.height, bitmap.config)
        inputAllocation = Allocation.createFromBitmap(renderScript, bitmap)
        outputAllocation = Allocation.createTyped(renderScript, inputAllocation!!.type)
        val renderScript2 = renderScript
        val create = ScriptIntrinsicColorMatrix.create(renderScript2, Element.U8_4(renderScript2))
        create.setColorMatrix(Matrix4f(floatArrayOf(1.728147f,
            -0.412105f,
            0.541145f,
            0.0f,
            0.28937826f,
            1.1883553f,
            -1.1763717f,
            0.0f,
            -1.0175253f,
            0.22374965f,
            1.6352267f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            1.0f)))
        create.forEach(inputAllocation, outputAllocation)
        outputAllocation!!.copyTo(outBitmap)
        return outBitmap
    }

    fun filter7(context: Context?, bitmap: Bitmap): Bitmap? {
        renderScript = RenderScript.create(context)
        outBitmap = Bitmap.createBitmap(bitmap.width, bitmap.height, bitmap.config)
        inputAllocation = Allocation.createFromBitmap(renderScript, bitmap)
        outputAllocation = Allocation.createTyped(renderScript, inputAllocation!!.type)
        val renderScript2 = renderScript
        val create = ScriptIntrinsicColorMatrix.create(renderScript2, Element.U8_4(renderScript2))
        create.setColorMatrix(Matrix4f(floatArrayOf(0.309f,
            0.409f,
            0.309f,
            0.0f,
            0.609f,
            0.309f,
            0.409f,
            0.0f,
            0.42f,
            0.42f,
            0.2f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            1.0f)))
        create.forEach(inputAllocation, outputAllocation)
        outputAllocation!!.copyTo(outBitmap)
        return outBitmap
    }

    fun filter8(context: Context?, bitmap: Bitmap): Bitmap? {
        renderScript = RenderScript.create(context)
        outBitmap = Bitmap.createBitmap(bitmap.width, bitmap.height, bitmap.config)
        inputAllocation = Allocation.createFromBitmap(renderScript, bitmap)
        outputAllocation = Allocation.createTyped(renderScript, inputAllocation!!.type)
        val renderScript2 = renderScript
        val create = ScriptIntrinsicConvolve3x3.create(renderScript2, Element.U8_4(renderScript2))
        create.setInput(inputAllocation)
        create.setCoefficients(floatArrayOf(-2.0f,
            -1.0f,
            0.0f,
            -1.0f,
            1.0f,
            1.0f,
            0.0f,
            1.0f,
            2.0f))
        create.forEach(outputAllocation)
        outputAllocation!!.copyTo(outBitmap)
        return outBitmap
    }

    fun filter9(context: Context?, bitmap: Bitmap): Bitmap? {
        renderScript = RenderScript.create(context)
        outBitmap = Bitmap.createBitmap(bitmap.width, bitmap.height, bitmap.config)
        inputAllocation = Allocation.createFromBitmap(renderScript, bitmap)
        outputAllocation = Allocation.createTyped(renderScript, inputAllocation!!.type)
        val renderScript2 = renderScript
        val create = ScriptIntrinsicConvolve3x3.create(renderScript2, Element.U8_4(renderScript2))
        create.setInput(inputAllocation)
        create.setCoefficients(floatArrayOf(0.2f, 0.3f, 0.2f, 0.1f, 0.1f, 0.1f, 0.2f, 0.3f, 0.2f))
        create.forEach(outputAllocation)
        outputAllocation!!.copyTo(outBitmap)
        return outBitmap
    }

    fun filter10(context: Context?, bitmap: Bitmap): Bitmap? {
        renderScript = RenderScript.create(context)
        outBitmap = Bitmap.createBitmap(bitmap.width, bitmap.height, bitmap.config)
        inputAllocation = Allocation.createFromBitmap(renderScript, bitmap)
        outputAllocation = Allocation.createTyped(renderScript, inputAllocation!!.type)
        val renderScript2 = renderScript
        val create = ScriptIntrinsicColorMatrix.create(renderScript2, Element.U8_4(renderScript2))
        create.setColorMatrix(Matrix4f(floatArrayOf(2.1027913f,
            -0.29821262f,
            0.42128146f,
            0.0f,
            0.22289757f,
            1.687012f,
            -0.8834213f,
            0.0f,
            -0.7656889f,
            0.17120072f,
            2.0221398f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            1.0f)))
        create.forEach(inputAllocation, outputAllocation)
        outputAllocation!!.copyTo(outBitmap)
        return outBitmap
    }

    fun filter11(context: Context?, bitmap: Bitmap): Bitmap? {
        renderScript = RenderScript.create(context)
        outBitmap = Bitmap.createBitmap(bitmap.width, bitmap.height, bitmap.config)
        inputAllocation = Allocation.createFromBitmap(renderScript, bitmap)
        outputAllocation = Allocation.createTyped(renderScript, inputAllocation!!.getType())
        val renderScript2 = renderScript
        val create = ScriptIntrinsicColorMatrix.create(renderScript2, Element.U8_4(renderScript2))
        create.setColorMatrix(Matrix4f(floatArrayOf(1.2748853f,
            -0.22851132f,
            0.44108868f,
            0.0f,
            0.32366425f,
            0.9551408f,
            -0.7059358f,
            0.0f,
            -0.6985495f,
            0.17337048f,
            1.164847f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            1.0f)))
        create.forEach(inputAllocation, outputAllocation)
        outputAllocation!!.copyTo(outBitmap)
        return outBitmap
    }
}