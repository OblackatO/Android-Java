package com.example.a017066611b.asynchtask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button trigger;
    ProgressBar progress_bar;
    TextView text_view;
    int MAX_NUMBER = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.trigger = (Button) findViewById(R.id.button);
        this.trigger.setOnClickListener(this);

        this.progress_bar = (ProgressBar) findViewById(R.id.progressBar);
        this.text_view = (TextView) findViewById(R.id.textView);

        Random rand = new Random();
        this.MAX_NUMBER = rand.nextInt(50) + 1;
    }

    @Override
    public void onClick(View v) {


        AsyncTask<Void,Integer,String> A = new AsyncTask<Void, Integer, String>() {

            float getpourcentage(int index){
                return (index*100)/MAX_NUMBER;
            }

            @Override
            protected String doInBackground(Void... voids) {
                int final_result = 0;
                for(int i = 0; i<MAX_NUMBER; i++){
                    final_result += i;

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    publishProgress((int) getpourcentage(i));
                }

                return String.valueOf(final_result);

            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                progress_bar.setProgress(values[0]);
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                text_view.setText("No result yet.");
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                text_view.setText("The result is:"+s);

                if(progress_bar.getProgress() != 100){
                    progress_bar.setProgress(100);
                }
            }

        };

        A.execute();
    }
}
