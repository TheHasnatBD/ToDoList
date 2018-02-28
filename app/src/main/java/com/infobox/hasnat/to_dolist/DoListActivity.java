package com.infobox.hasnat.to_dolist;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Date;

public class DoListActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_list);

        listView = (ListView)findViewById(R.id.toDoListView);

        MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(getApplicationContext());

        final String[] data = myDatabaseHelper.getAllData();

        final LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return data.length;
            }

            @Override
            public Object getItem(int i) {
                return i;
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                if (view == null){
                    view = layoutInflater.inflate(R.layout.single_item, null);
                }
                TextView title_view = (TextView)view.findViewById(R.id.title_tv);
                TextView detail_view = (TextView) view.findViewById(R.id.details_tv);
                TextView date_view = (TextView) view.findViewById(R.id.date_tv);


                Date date = new Date(i);
                title_view.setText(data[i]);
                detail_view.setText(data[i]);
                date_view.setText(android.text.format.DateFormat.format("dd/MM/yyy HH:mm:ss a", date));

                return view;
            }
        };
        listView.setAdapter(adapter);


    }
}
