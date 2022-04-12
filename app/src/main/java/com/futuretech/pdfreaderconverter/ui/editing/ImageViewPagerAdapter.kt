package com.futuretech.pdfreaderconverter.ui.editing

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.futuretech.pdfreaderconverter.R
import com.futuretech.pdfreaderconverter.model.ImageQueue
import com.futuretech.pdfreaderconverter.utility.Logger

class ImageViewPagerAdapter(private val adapterList: ArrayList<ImageQueue>) : PagerAdapter() {
    override fun getCount(): Int = adapterList.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater =
            container.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.viewpager_image_layout, container, false)
        val mimageView: ImageView = view!!.findViewById(R.id.iVFullImage)

        try {
            if (adapterList.size >= position) {
                val image = adapterList[position]

                if (image.uriPath != null) {
                    try {
                        Logger.debug("URI_PATH=>", image.uriPath)
                        Glide.with(container.context)
                            .load(image.uriPath)
                            .diskCacheStrategy(DiskCacheStrategy.NONE)
                            .skipMemoryCache(true)
                            .into(mimageView)

                        container.addView(view)
                    } catch (e: Exception) {
                    }
                }
            }
            return view
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return view
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as View
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

        container.removeView(`object` as View)
    }

/*    override fun getItemPosition(`object`: Any): Int {
        return POSITION_NONE
    }*/
}