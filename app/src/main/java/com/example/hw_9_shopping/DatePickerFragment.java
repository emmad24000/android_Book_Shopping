package com.example.hw_9_shopping;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{

    public DatePickerFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_date_picker, container, false);
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@NonNull Bundle savedInstanceState){
        final Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int year = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),this,year,month,day);
        return datePickerDialog;
    }


    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        String date = String.format("%d/%d/%d",month,day,year);
        Book.date = date;
    }
}
