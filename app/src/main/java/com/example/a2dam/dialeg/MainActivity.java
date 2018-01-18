package com.example.a2dam.dialeg;

import android.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends FragmentActivity{

    Button bdata, bhora,bcolor;
    TextView data,texthora,color;
    String datatext,horatext,colortext;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bdata = (Button) findViewById(R.id.btndata);
        bhora = (Button) findViewById(R.id.btnhora);
        bcolor = (Button) findViewById(R.id.btncolor);
        data = (TextView) findViewById(R.id.textViewData);
        texthora = (TextView) findViewById(R.id.textViewHora);
        color = (TextView) findViewById(R.id.textViewColor);

        bdata.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getFragmentManager(), "datePicker");
            }
        });


        bhora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DialogFragment newFragment = new TimePickerFragment();
                newFragment.show(getFragmentManager(), "timePicker");
            }
        });

        bcolor.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                new MyDialogFragment().show(getFragmentManager(), "dialog");

            }
        });


    }
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        datatext = data.getText().toString();
        outState.putString("data", datatext);
        horatext = texthora.getText().toString();
        outState.putString("hora", horatext);
        colortext = color.getText().toString();
        outState.putString("color", colortext);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        datatext = savedInstanceState.getString("data");
        horatext = savedInstanceState.getString("hora");
        colortext = savedInstanceState.getString("color");

        data.setText(datatext);
        texthora.setText(horatext);
        color.setText(colortext);


    }
}


