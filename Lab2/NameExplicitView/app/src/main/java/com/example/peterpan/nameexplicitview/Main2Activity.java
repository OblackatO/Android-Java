package com.example.peterpan.nameexplicitview;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView display_name = (TextView) findViewById(R.id.textView3);

        Intent intent = getIntent();
        //Get Name and surname
        String first_name = intent.getStringExtra("parameter1");
        String surname = intent.getStringExtra("parameter2");

        //change color to yellow
        this.getWindow().getDecorView().setBackgroundColor(Color.YELLOW);

        display_name.setText("Hi "+first_name+" "+surname);

    }
}
