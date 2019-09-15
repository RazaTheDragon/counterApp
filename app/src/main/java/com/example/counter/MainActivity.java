package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView mUnit;
    Button mPlus;
    Button mMinus;
    Button mReset;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null && savedInstanceState.containsKey("num"))
            number = savedInstanceState.getInt("num");

    mUnit=findViewById(R.id.unit);
    mMinus=findViewById(R.id.minus_button);
    mPlus=findViewById(R.id.plus_button);
    mReset=findViewById(R.id.reset_botton);

        mUnit.setText(String.valueOf(number));

    mPlus.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            number++;
            mUnit.setText(String.valueOf(number));
        }
    });
    mMinus.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (number < 0){
                number = 0;
                mUnit.setText(String.valueOf(number));
            }
            else if (number > 0){
                number--;
                mUnit.setText(String.valueOf(number));
            }
        }
    });
    mReset.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (number != 0) {
                number = 0;
                mUnit.setText(String.valueOf(number));
            }
        }
    });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("num",number);
        super.onSaveInstanceState(outState);
    }
}
