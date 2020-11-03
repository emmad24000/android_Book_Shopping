package com.example.hw_9_shopping;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TimePicker;

import java.sql.Time;
import java.util.Calendar;


public class TimePickerFragment extends DialogFragment {
    private TimePickerDialog.OnTimeSetListener listener;

    public TimePickerFragment(TimePickerDialog.OnTimeSetListener listener) {
        this.listener = listener;
        // Required empty public constructor
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),listener,hour,minute,false);
        return timePickerDialog;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_time_picker, container, false);
    }


}