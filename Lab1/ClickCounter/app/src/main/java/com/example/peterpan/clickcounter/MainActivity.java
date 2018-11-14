package com.example.peterpan.clickcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final public String STATIC_TEXT = "Count:";
    int count_increments = 0;

    Button counter_button;
    TextView counter_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.counter_button = (Button) findViewById(R.id.button);
        this.counter_button.setOnClickListener(this);
        
        this.counter_text = (TextView) findViewById(R.id.textView);
        this.counter_text.setText(this.STATIC_TEXT);


    }

    @Override
    public void onClick(View v) {
        count_increments++;
        this.counter_text.setText(this.STATIC_TEXT+String.valueOf(this.count_increments));
    }
}
