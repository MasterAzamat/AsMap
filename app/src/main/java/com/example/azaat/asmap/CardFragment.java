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
import android.view.ViewParent;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


public class CardFragment extends Fragment  implements View.OnClickListener{

    public CardFragment() {
        // Required empty public constructor
    }
    String NAME = "cardFragment",LOG = "myLogs";

    SliderAdapter sliderAdapter;
    ViewPager viewPager;
    LinearLayout dotsLayout;

    TextView []dots;
    int currentPage;
    Button bt1,bt2,bt3;
    Timer timer;

    int currentButton;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_card, container, false);

        viewPager = (ViewPager) view.findViewById(R.id.page_slider);
        dotsLayout = (LinearLayout) view.findViewById(R.id.dots);
        bt1 = (Button) view.findViewById(R.id.bt_tab_1);
        bt2 = (Button) view.findViewById(R.id.bt_tab_2);
        bt3 = (Button) view.findViewById(R.id.bt_tab_3);
        bt1.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt2.setOnClickListener(this);

        currentButton = 1;
        bt1.setTextColor(getResources().getColor(R.color.whiteColor));
        bt1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.card_container,new DesFragment());
        fragmentTransaction.commit();

        sliderAdapter = new SliderAdapter(getActivity());
        viewPager.setAdapter(sliderAdapter);

        viewPager.addOnPageChangeListener(viewListener);

        addDots(0);

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
    public void onClick(View view) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        switch (view.getId()){
            case R.id.bt_tab_1:
                if(currentButton == 2){
                    bt2.setTextColor(getResources().getColor(R.color.colorPrimary));
                    bt2.setBackgroundColor(getResources().getColor(R.color.whiteColor));
                }else if(currentButton == 3){
                    bt3.setTextColor(getResources().getColor(R.color.colorPrimary));
                    bt3.setBackgroundColor(getResources().getColor(R.color.whiteColor));
                }
                currentButton = 1;
                fragmentTransaction.replace(R.id.card_container,new DesFragment());
                bt1.setTextColor(getResources().getColor(R.color.whiteColor));
                bt1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                break;
            case R.id.bt_tab_2:
                if(currentButton == 1){
                    bt1.setTextColor(getResources().getColor(R.color.colorPrimary));
                    bt1.setBackgroundColor(getResources().getColor(R.color.whiteColor));
                }else if(currentButton == 3){
                    bt3.setTextColor(getResources().getColor(R.color.colorPrimary));
                    bt3.setBackgroundColor(getResources().getColor(R.color.whiteColor));
                }
                currentButton = 2;
                fragmentTransaction.replace(R.id.card_container,new ConsistFragment());
                bt2.setTextColor(getResources().getColor(R.color.whiteColor));
                bt2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                break;
            case R.id.bt_tab_3:
                if(currentButton == 2){
                    bt2.setTextColor(getResources().getColor(R.color.colorPrimary));
                    bt2.setBackgroundColor(getResources().getColor(R.color.whiteColor));
                }else if(currentButton == 1){
                    bt1.setTextColor(getResources().getColor(R.color.colorPrimary));
                    bt1.setBackgroundColor(getResources().getColor(R.color.whiteColor));
                }
                currentButton = 3;
                fragmentTransaction.replace(R.id.card_container,new DesFragment());
                bt3.setTextColor(getResources().getColor(R.color.whiteColor));
                bt3.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                break;
        }
        fragmentTransaction.commit();
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
