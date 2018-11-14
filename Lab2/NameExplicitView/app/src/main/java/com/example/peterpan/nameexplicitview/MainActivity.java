package com.example.peterpan.nameexplicitview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button view_name;
    TextView first_name;
    TextView surname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.view_name = (Button) findViewById(R.id.button1);
        this.view_name.setOnClickListener(this);
        this.first_name = (TextView) findViewById(R.id.editText);
        this.surname = (TextView) findViewById(R.id.editText2);

    }

    @Override
    public void onClick(View v) {
        Intent name_intent = new Intent(this, Main2Activity.class);
        name_intent.putExtra("parameter1", this.first_name.getText().toString());
        name_intent.putExtra("parameter2", this.surname.getText().toString());
        startActivity(name_intent);
    }
}
