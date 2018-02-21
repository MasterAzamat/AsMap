package com.example.azaat.asmap;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class IndividualFragment extends Fragment {


    public IndividualFragment() {
        // Required empty public constructor
    }
    String NAME = "individualFragmenr",LOG = "myLogs";
    ListView lv ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_individual, container, false);
        lv = (ListView) view.findViewById(R.id.individ_lv);

        int []image = {R.drawable.change_profile,R.drawable.history_list,R.drawable.back_call};
        String []title = {"Редактировать профиль","История заказов","Контакты"};

        ArrayList<Map<String,Object>> arr = new ArrayList<>();
        Map m;
        for(int i = 0;i<image.length;i++){
            m = new HashMap();
            m.put("image1",image[i]);
            m.put("title",title[i]);
            m.put("image2",R.drawable.right_arrow);
            arr.add(m);
        }
        String []from = {"image1","title","image2"};
        int []to = {R.id.icon_image1,R.id.icon_des,R.id.icon_image2};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(),arr,R.layout.item_for_idividual,from,to);
        lv.setAdapter(simpleAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                switch (i){
                    case 0:
                        Intent intent = new Intent(getActivity(),Change_profile.class);
                        startActivity(intent);
                        break;
                    case 1:
                        fragmentTransaction.replace(R.id.frame_con,new HistoryFragment());
                        fragmentTransaction.addToBackStack(null);
                        break;
                    case 2:

                        break;
                }
                fragmentTransaction.commit();
            }
        });
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
