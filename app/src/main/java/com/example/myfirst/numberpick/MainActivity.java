package com.example.myfirst.numberpick;

import android.app.Activity;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NumberPicker.OnValueChangeListener onValueChanged
                = new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker,int oldVal,int newVal) {
                NumberPicker[] nps = new NumberPicker[3];
                nps[0] = (NumberPicker)
                        findViewById(R.id.numberPicker1);
                nps[1] = (NumberPicker)
                        findViewById(R.id.numberPicker2);
                nps[2] = (NumberPicker)
                        findViewById(R.id.numberPicker3);
                String temp = "";
                for (int i = 0; i < 3; i++) {
                    String[] values = nps[i].getDisplayedValues();
                    temp = values[nps[i].getValue()]+temp;
                }
                TextView tv =(TextView)findViewById(R.id.editText);
                tv.setText(temp);
            }
        };

        String[] values = new String[10];
        for (int i = 0; i < values.length; i++)
        {
            values[i] = Integer.toString(i);
        }
        NumberPicker[] nps = new NumberPicker[3];
        nps[0] = (NumberPicker)
                findViewById(R.id.numberPicker1);
        nps[1] = (NumberPicker)
                findViewById(R.id.numberPicker2);
        nps[2] = (NumberPicker)
                findViewById(R.id.numberPicker3);
        for (int i = 0; i < 3; i++) {
            nps[i].setMaxValue(values.length - 1);
            nps[i].setMinValue(0);
            nps[i].setDisplayedValues(values);
            nps[i].setOnValueChangedListener(onValueChanged);
        }
    }
}
