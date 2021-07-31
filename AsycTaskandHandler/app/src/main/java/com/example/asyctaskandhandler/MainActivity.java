package com.example.asyctaskandhandler;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "Timer";
    String[] name =  new String[]{
            "Harshit","Avi" ,"Prakhar","Abhishek","Arjun","Swarit","Katappa"
    };
    ListView listView;
    Button btn;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lvnames);
        btn = findViewById(R.id.btn);
        linearLayout = findViewById(R.id.linearLayout);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
          this,  android.R.layout.simple_list_item_1,
                name
        );
        listView.setAdapter(arrayAdapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler h = new Handler();
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        linearLayout.setBackgroundColor(Color.RED);
                        Log.d(TAG, "run: ");
                    }
                };
                h.postDelayed(r,5000);

            }
        });


    }


}