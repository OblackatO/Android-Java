package com.example.peterpan.browserintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button launch_browser;
    String URL;
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.launch_browser = findViewById(R.id.button);
        this.launch_browser.setOnClickListener(this);
        this.textview = findViewById(R.id.editText);
    }


    @Override
    public void onClick(View v) {
        this.URL = this.textview.getText().toString();
        Intent browser_intent = new Intent(Intent.ACTION_VIEW);
        browser_intent.setData(Uri.parse(this.URL));
        startActivity(browser_intent);
    }
}
