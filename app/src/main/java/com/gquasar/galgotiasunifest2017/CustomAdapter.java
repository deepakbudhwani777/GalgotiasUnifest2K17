package com.gquasar.galgotiasunifest2017;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by Prakhar on 1/7/2017.
 */

public class CustomAdapter extends PagerAdapter {
    int img[]={R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5};
    LayoutInflater inflater;
    Context context;

    public CustomAdapter(Context context) {
        this.context = context;
    }
    public CustomAdapter()
    {}

    @Override
    public int getCount() {
        return img.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v= inflater.inflate(R.layout.swipe,container,false);
        ImageView imageView=(ImageView)v.findViewById(R.id.imageView_slider);
        imageView.setImageResource(img[position]);
        container.addView(v);
        return  v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager)container).removeView((View)object);
    }

    @Override
    public float getPageWidth(int position) {
        return 1;
    }
}
