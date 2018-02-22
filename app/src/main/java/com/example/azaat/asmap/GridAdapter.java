package com.example.azaat.asmap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Azaat on 22.02.2018.
 */

public class GridAdapter extends BaseAdapter {

    Context context;
    int []image;
    View view;
    LayoutInflater layoutInflater;

    public GridAdapter(Context context, int[] image) {
        this.context = context;
        this.image = image;
    }

    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null){
            view = layoutInflater.inflate(R.layout.card_item,null);
            ImageView imageView = (ImageView) view.findViewById(R.id.home_item_image);
            imageView.setImageResource(image[i]);
        }
        return view;
    }
}
