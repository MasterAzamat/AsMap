package com.example.azaat.asmap;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class HistoryFragment extends Fragment {

    public HistoryFragment() {
        // Required empty public constructor
    }

    String NAME = "historyFragment",LOG = "myLogs";
    ListView list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        list = (ListView) view.findViewById(R.id.history_list);


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
        int []to = {R.id.history_item_image,R.id.history_item_title,R.id.history_item_price};

        list = (ListView) view.findViewById(R.id.history_list);
        SimpleAdapter adapter = new SimpleAdapter(getActivity(),arr,R.layout.history_list_item,from,to);
        list.setAdapter(adapter);

        return view;
    }
    @Override
    public void onAttach(Context context) {
        Log.d(LOG,NAME + " onAttach");
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(LOG,NAME + " onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d(LOG,NAME + " onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d(LOG,NAME + " onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d(LOG,NAME + " onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(LOG,NAME + " onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(LOG,NAME + " onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(LOG,NAME + " onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG,NAME + " onDestroy");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(LOG,NAME + " onDatach");
    }

}
