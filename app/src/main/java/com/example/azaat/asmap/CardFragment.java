package com.example.azaat.asmap;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;


public class CardFragment extends Fragment  implements View.OnClickListener{

    public CardFragment() {
        // Required empty public constructor
    }
    private long FRAGMENT_ID;

    String NAME = "cardFragment",LOG = "myLogs";

    SliderAdapter sliderAdapter;
    ViewPager viewPager;
    LinearLayout dotsLayout;

    TextView []dots;
    int currentPage;
    Button bt1,bt2,bt3,addBasket;

    TextView card_title,card_des,card_price;

    int currentButton;

    DBHelper dbHelper;
    SQLiteDatabase db;
    Cursor cursor;

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
        addBasket = (Button) view.findViewById(R.id.to_basket);
        addBasket.setOnClickListener(this);
        bt1.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt2.setOnClickListener(this);
        card_title = (TextView) view.findViewById(R.id.card_title);
        card_des = (TextView) view.findViewById(R.id.card_des);
        card_price = (TextView) view.findViewById(R.id.card_price);
        dbHelper = new DBHelper(getActivity());
        db = dbHelper.getWritableDatabase();
        FRAGMENT_ID = getArguments().getLong("message",1);
        cursor = db.query("mytable",new String[]{"_id","image","name","des","price"},"_id = ?",new String[]{""+FRAGMENT_ID},null,null,null);
        if(cursor.moveToFirst()){
            card_title.setText(cursor.getString(cursor.getColumnIndex("name")));
            card_des.setText(cursor.getString(cursor.getColumnIndex("des")));
            card_price.setText(cursor.getString(cursor.getColumnIndex("price")));
        }

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
            case R.id.to_basket:
                showDialog();
                break;
        }
        fragmentTransaction.commit();
    }
    public void showDialog(){
        ContentValues contentValues = new ContentValues();
        contentValues.put("image",cursor.getString(cursor.getColumnIndex("image")));
        contentValues.put("name",cursor.getString(cursor.getColumnIndex("name")));
        contentValues.put("des",cursor.getString(cursor.getColumnIndex("des")));
        contentValues.put("price",cursor.getString(cursor.getColumnIndex("price")));
        contentValues.put("count",1);
        db.insert("basket",null,contentValues);
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setPositiveButton("OK",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder.setNegativeButton("В корзину",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(getActivity(), "В корзину", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });
        builder.setTitle("Добавлено в корзину!");
        AlertDialog dialog=builder.create();
        dialog.show();
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
        db.close();
        super.onDestroy();
        Log.d(LOG,NAME + " onDestroy");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(LOG,NAME + " onDatach");
    }
}
