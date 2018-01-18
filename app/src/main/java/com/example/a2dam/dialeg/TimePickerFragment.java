package com.example.a2dam.dialeg;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment  implements TimePickerDialog.OnTimeSetListener{
    TextView texthora;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        texthora = ((TextView)getActivity().findViewById(R.id.textViewHora));

        final Calendar c = Calendar.getInstance();
        int hora = c.get(Calendar.HOUR_OF_DAY);
        int min = c.get(Calendar.MINUTE);


        return new TimePickerDialog(getActivity(), this, hora, min, true);
    }

    public void onTimeSet(TimePicker view, int hora, int min) {
        texthora.setText("Hora: "+hora + ":"
                +min );

    }
}
