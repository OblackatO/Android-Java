package com.example.peterpan.multichoice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowLetter extends AppCompatActivity implements View.OnClickListener {

    TextView display_letter;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_letter);

        this.display_letter = (TextView) findViewById(R.id.textView);
        Intent current_intent = this.getIntent();
        String letter = current_intent.getStringExtra("chosen_letter");
        this.display_letter.setText(letter);

        this.button1 = (Button) findViewById(R.id.button);
        this.button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        setResult(RESULT_OK);
        finish();
    }
}
