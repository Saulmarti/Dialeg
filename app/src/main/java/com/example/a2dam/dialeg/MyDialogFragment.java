package com.example.a2dam.dialeg;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static com.example.a2dam.dialeg.R.array.Colores;


public class MyDialogFragment extends DialogFragment {
    private  String [] colores;
    TextView color;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        color = ((TextView)getActivity().findViewById(R.id.textViewColor));
        colores = getResources().getStringArray(Colores);
        return createSimpleDialog();

    }

    public AlertDialog createSimpleDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
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
        return builder.create();
    }
}


