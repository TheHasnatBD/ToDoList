package com.infobox.hasnat.to_dolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText title, about;
    Button save_button, go_list_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = (EditText)findViewById(R.id.title_name);
        about = (EditText)findViewById(R.id.do_name);
        save_button = (Button) findViewById(R.id.saveButton);
        go_list_button = (Button) findViewById(R.id.goListButton);

        //
        final MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(getApplicationContext());


        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String _title = title.getText().toString();
                String _detail = about.getText().toString();
                Date current_date = new Date();

                DataTemp dataTemp = new DataTemp(_title, _detail, current_date);
                myDatabaseHelper.insertData(dataTemp);

                Toast.makeText(getApplicationContext(), ""+_title+" saved in database", Toast.LENGTH_SHORT).show();
            }
        });

        go_list_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, DoListActivity.class);

                Toast.makeText(getApplicationContext(), "List Opened", Toast.LENGTH_SHORT).show();

                startActivity(intent);
            }
        });

    }
}
