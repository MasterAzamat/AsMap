package com.example.azaat.asmap;

import android.app.Fragment;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

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
    Button btDown,btUp,letsShop;

    DBHelper dbHelper;
    SQLiteDatabase db;
    Cursor cursor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        dbHelper = new DBHelper(getActivity());
        db = dbHelper.getWritableDatabase();
        cursor = db.query("basket",new String[]{"_id","image","name","price","count"},null,null,null,null,null);
        View view = null;
        if(cursor.moveToFirst()){
            view = inflater.inflate(R.layout.fragment_basket, container, false);

            close = (ImageButton) view.findViewById(R.id.basket_item_image);
            count = (TextView) view.findViewById(R.id.basket_item_count);
            btDown = (Button) view.findViewById(R.id.basket_item_down);
            btUp = (Button) view.findViewById(R.id.basket_item_up);


        }else {
            view = inflater.inflate(R.layout.basket_alternativ, container, false);
            letsShop = (Button) view.findViewById(R.id.letsShop);
        }

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View view = getView();
    }
}
