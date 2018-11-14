package com.example.peterpan.multichoice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<RadioButton> radio_buttons = new ArrayList<>();
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.submit = (Button) findViewById(R.id.button2);
        this.submit.setOnClickListener(this);

        for(int i=0; i<4; i++){
            int id = this.getResources().getIdentifier("radioButton"+i, "id", getPackageName());
            RadioButton current_button = findViewById(id);
            this.radio_buttons.add(current_button);
        }
    }

    @Override
    public void onClick(View v) {

        for(RadioButton button: this.radio_buttons){
            if(button.isChecked()){
                Intent show_letter_intent = new Intent(this, ShowLetter.class);
                show_letter_intent.putExtra("chosen_letter", button.getText().toString());
                startActivityForResult(show_letter_intent, 200);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == RESULT_OK && requestCode == 200){
            System.out.println("Successfully returned.");
        }
    }
}
