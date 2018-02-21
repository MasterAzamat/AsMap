package com.example.azaat.asmap;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class BasketFragment extends Fragment {


    public BasketFragment() {
        // Required empty public constructor
    }
    ListView list;
    ImageButton close;
    TextView count;
    Button btDown,btUp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_basket, container, false);

        close = (ImageButton) view.findViewById(R.id.basket_item_image);
        count = (TextView) view.findViewById(R.id.basket_item_count);
        btDown = (Button) view.findViewById(R.id.basket_item_down);
        btUp = (Button) view.findViewById(R.id.basket_item_up);

        int []imageList = {R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image3};
        String []titleList = {"Clean","ShowLight","Pikupi","Shalala"};
        String []priseList = {"2000tg","7000tg","5000tg","8000tg"};

        ArrayList<Map<String,Object>> arr = new ArrayList<>();
        Map<String,Object> m;
        for(int  i = 0;i < imageList.length;i++){
            m = new HashMap<>();
            m.put("IMAGE",imageList[i]);
            m.put("TITLE",titleList[i]);
            m.put("PRICE",priseList[i]);
            arr.add(m);
        }

        String []from = {"IMAGE","TITLE","PRICE"};
        int []to = {R.id.basket_item_image,R.id.basket_item_title,R.id.basket_item_price};

        list = (ListView) view.findViewById(R.id.basket_list);
        SimpleAdapter adapter = new SimpleAdapter(getActivity(),arr,R.layout.basket_item,from,to);
        list.setAdapter(adapter);

        return view;
    }


}
