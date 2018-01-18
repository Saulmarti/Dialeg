package com.example.a2dam.dialeg;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;


public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    TextView data;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

         data = ((TextView)getActivity().findViewById(R.id.textViewData));

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);


        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        data.setText("Data: "+day + "/"
                + (month + 1) + "/" + year);

    }
}

