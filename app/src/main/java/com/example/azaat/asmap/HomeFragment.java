package com.example.azaat.asmap;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;


public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }
    String NAME = "homeFragment",LOG = "myLogs";


    SliderAdapter sliderAdapter;
    ViewPager viewPager;
    LinearLayout dotsLayout;

    TextView[]dots;
    int currentPage;
    Timer timer;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        viewPager = (ViewPager) view.findViewById(R.id.page_slider);
        dotsLayout = (LinearLayout) view.findViewById(R.id.dots);

        sliderAdapter = new SliderAdapter(getActivity());
        viewPager.setAdapter(sliderAdapter);

        viewPager.addOnPageChangeListener(viewListener);
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == 4) {
                    currentPage = 0;
                }
                if(getActivity()!=null){
                    viewPager.setCurrentItem(currentPage++, true);
                }else
                    Thread.interrupted();

            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 100, 2000);
        addDots(0);
        int []list_image = {R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image3};

        ListView gridView = (ListView) view.findViewById(R.id.home_list);
        ArrayList<Map<String,Object>> arr = new ArrayList<>();
        Map<String,Object> m;
        for(int  i = 0;i < list_image.length;i++){
            m = new HashMap<>();
            m.put("IMAGE",list_image[i]);
            arr.add(m);
        }
        String []from = {"IMAGE"};
        int []to = {R.id.home_item_image};

        SimpleAdapter adapter = new SimpleAdapter(getActivity(),arr,R.layout.card_item,from,to);
        gridView.setAdapter(adapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_con,new CardFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return view;
    }
    void  addDots(int position){
        dotsLayout.removeAllViews();
        dots = new TextView[sliderAdapter.getCount()];
        for (int i = 0;i<dots.length;i++){
             dots[i] = new TextView(getActivity());
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.dotsColor));

            dotsLayout.addView(dots[i]);
        }
        if(dots.length>0){
            dots[position].setTextColor(getResources().getColor(R.color.activeDotsColor));
        }

    }
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            currentPage = position;
            addDots(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

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
        timer.cancel();
        timer = null;
        super.onDestroy();
        Log.d(LOG,NAME + " onDestroy");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(LOG,NAME + " onDatach");
    }
}
