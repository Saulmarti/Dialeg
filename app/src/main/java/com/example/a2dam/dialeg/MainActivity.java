package com.example.a2dam.dialeg;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.icu.util.Calendar;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import static com.example.a2dam.dialeg.R.array.Colores;

public class MainActivity extends AppCompatActivity{

    Button bdata, bhora,bcolor;
    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;
    TextView data,texthora,color;
    final Calendar c = Calendar.getInstance();
    private  String [] colores;


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
        colores = getResources().getStringArray(Colores);

        bdata.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                int any = c.get(Calendar.YEAR);
                int mes = c.get(Calendar.MONTH);
                int dia = c.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int any,
                                                  int mes, int dia) {
                                data.setText("Data: "+dia + "/"
                                        + (mes + 1) + "/" + any);

                            }
                        }, any, mes, dia);
                datePickerDialog.show();
            }
        });


        bhora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int hora = c.get(Calendar.HOUR_OF_DAY);
                int min = c.get(Calendar.MINUTE);

                timePickerDialog = new TimePickerDialog(MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int hora,int min) {
                                texthora.setText("Hora: "+hora + ":"
                                        +min );

                            }
                        }, hora, min,false);
                timePickerDialog.show();
            }
        });

        bcolor.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Alerta").setItems(colores, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int posicion) {
                        if(String.format(colores[posicion]).equals("Azul")){
                            color.setText("Azul");
                            color.setBackgroundColor(Color.BLUE);
                        }else if(colores[posicion].equals("Rojo")){
                            color.setText("Rojo");
                            color.setBackgroundColor(Color.RED);
                        }else if(colores[posicion].equals("Verde")){
                            color.setText("Verde");
                            color.setBackgroundColor(Color.GREEN);
                        }
                    }
                });
                builder.create();
                builder.show();

            }
        });


    }

}


