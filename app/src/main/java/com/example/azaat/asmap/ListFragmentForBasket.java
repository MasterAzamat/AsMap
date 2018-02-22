package com.example.azaat.asmap;



import android.app.ListFragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

/**
 * Created by Azaat on 22.02.2018.
 */

public class ListFragmentForBasket extends ListFragment {
    DBHelper dbHelper;
    SQLiteDatabase db;
    Cursor cursor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_for_list_fragment,container,false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        dbHelper = new DBHelper(getActivity());
        db = dbHelper.getWritableDatabase();
        cursor = db.query("basket",new String[]{"_id","image","name","price","count"},null,null,null,null,null);

        String []from = {"image","name","price","count"};
        int []to = {R.id.basket_item_image,R.id.basket_item_title,R.id.basket_item_price,R.id.basket_item_count};
        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(getActivity(), R.layout.basket_item, cursor,from,to,0);
        setListAdapter(cursorAdapter);

    }

    @Override
    public void onStart() {
        super.onStart();
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(), "d4d4d4", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(getActivity(), "Вы выбрали ", Toast.LENGTH_SHORT).show();
    }
}
