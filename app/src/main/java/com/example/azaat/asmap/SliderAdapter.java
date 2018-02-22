package com.example.azaat.asmap;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by Azaat on 20.02.2018.
 */

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater inflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    public int []image = {R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4};

    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (RelativeLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slider_layout,container,false);

        ImageView imageView = (ImageView) view.findViewById(R.id.slider_image);
        imageView.setImageResource(image[position]);

        container.addView(view);
        return  view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)  object);
    }
}
