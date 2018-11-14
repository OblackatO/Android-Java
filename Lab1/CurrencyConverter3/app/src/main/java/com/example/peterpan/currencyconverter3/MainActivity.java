package com.example.peterpan.currencyconverter3;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

public class MainActivity extends AppCompatActivity{

    final double bitcoin_value = 1.0;
    final double euro_value = 5000;

    TextInputEditText euro_input;
    TextWatcher euro_text_watcher;

    TextInputEditText bitcoin_input;
    TextWatcher bitcoin_text_watcher;


    public String euro_to_bitcoin(String euro_text){
        if(euro_text.equals("") || euro_text.equals(" ")){
            return "";
        }

        float euro_double = Float.parseFloat(euro_text);
        return String.valueOf(  (euro_double*bitcoin_value)
                                /euro_value);
    }

    public String bitcoin_to_euro(String bitcoin_text){
        if(bitcoin_text.equals("") || bitcoin_text.equals(" ")){
            return "";
        }

        float bitcoin_double = Float.parseFloat(bitcoin_text);
        return String.valueOf(bitcoin_double*euro_value);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.euro_input = (TextInputEditText) findViewById(R.id.euro_input);
        this.bitcoin_input = (TextInputEditText) findViewById(R.id.bitcoin_input);

        this.euro_text_watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //Nothing to do
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //Nothing to do.
            }

            @Override
            public void afterTextChanged(Editable s) {
                bitcoin_input.removeTextChangedListener(bitcoin_text_watcher);
                bitcoin_input.setText(euro_to_bitcoin(s.toString()));
                bitcoin_input.addTextChangedListener(bitcoin_text_watcher);
            }
        };

        this.euro_input.addTextChangedListener(this.euro_text_watcher);

        this.bitcoin_text_watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //nothing to do
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //Nothing to do.
            }

            @Override
            public void afterTextChanged(Editable s) {
                euro_input.removeTextChangedListener(euro_text_watcher);
                euro_input.setText(bitcoin_to_euro(s.toString()));
                euro_input.addTextChangedListener(euro_text_watcher);
            }
        };

        this.bitcoin_input.addTextChangedListener(this.bitcoin_text_watcher);

    }
}
