package com.example.asyctaskandhandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class AsyncTaskActivity extends AppCompatActivity {
    Button btnStart,btnRandom;
    TextView tvCounter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        btnStart = findViewById(R.id.btnStart);
        btnRandom = findViewById(R.id.btnRandom);
        tvCounter = findViewById(R.id.tvCounter);

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                tvCounter.setText(String.valueOf(r.nextInt(100)));
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                CountTask countTask = new CountTask();
                countTask.execute(5);
            }
        });

    }

    class CountTask extends AsyncTask<Integer,Integer,Void>{

        @Override
        protected Void doInBackground(Integer... integers) {
            Log.d("TAG", "doInBackground: Started ");
            int n = integers[0];
            for (int i=0;i<n;i++){
                wait1Sec();
                publishProgress(i);
            }
            waitNSec(5);
            Log.d("TAG", "doInBackground: Finished");

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            tvCounter.setText(String.valueOf(values[0]));
        }
    }
    void wait1Sec(){
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() < startTime + 1000);
    }

    void waitNSec(int n){
        for (int i = 0 ; i<n ; i++){
            wait1Sec();
        }
    }
}