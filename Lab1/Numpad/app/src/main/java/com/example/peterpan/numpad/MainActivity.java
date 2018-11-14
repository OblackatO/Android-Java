package com.example.peterpan.numpad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    String NumPadText = "";
    TextView NumPadField;
    HashMap<Integer, Button> buttons = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.NumPadField = findViewById(R.id.textView);

        for (int i = 0; i <= 9; i++) {
            if(i == 0){continue;}

            int id = this.getResources().getIdentifier("button"+i, "id", getPackageName());
            Button button_to_add = (Button) findViewById(id);
            button_to_add.setOnClickListener(this);
            this.buttons.put(id, button_to_add);
        }

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Button current_button = this.buttons.get(id);
        String new_text = this.NumPadField.getText().toString() + current_button.getText().toString();
        this.NumPadField.setText(new_text);
    }
}
