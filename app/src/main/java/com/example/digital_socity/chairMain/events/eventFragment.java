package com.example.digital_socity.chairMain.events;

import android.annotation.SuppressLint;
import  android.app.DatePickerDialog;
import  android.os.Build;
import  android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.digital_socity.databinding.BottomsheetEventDialogBinding;
import com.example.digital_socity.databinding.FragmentEventBinding;

import java.util.ArrayList;
import java.util.Calendar;


public class eventFragment extends Fragment implements eventBottomsheet.onclick{

    private FragmentEventBinding binding;
    private ArrayList<eventModel> list;
    private Calendar calendar=Calendar.getInstance();
    private eventAdapter adapter;
    private eventBottomsheet bottomsheet;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        //        arraylist
        list=new ArrayList<>();

        //        binding
        binding=FragmentEventBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        // adapter settings

        adapter=new eventAdapter(list,getContext());
        binding.eventrcv.setAdapter(adapter);
        binding.eventrcv.setLayoutManager(new LinearLayoutManager(getContext()));

        // floating action button
        binding.fabevent.setOnClickListener(view1 ->
        {
            bottomsheet=new eventBottomsheet(this);
            bottomsheet.show(getParentFragmentManager(),"event");
        });

    }

//    date picker settings

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onsetdateclicklistener(BottomsheetEventDialogBinding binding)
    {
        DatePickerDialog dialog= new DatePickerDialog(getContext(),
                        (DatePickerDialog.OnDateSetListener) (datePicker, i, i1, i2) -> {
            String date=i2+"-"+(i1+1)+"-"+i;
            binding.tvdateevent.setText(date);

        },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
        dialog.getDatePicker().setMinDate(System.currentTimeMillis());
        dialog.show();

    }

//    event add button listener
    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onbtnaddclicklistener(BottomsheetEventDialogBinding binding2)
    {
        eventModel model=new eventModel(binding2.inputEventTitle.getText().toString(),binding2.inputEventDesc.getText().toString(),binding2.tvdateevent.getText().toString());
        list.add(model);
        bottomsheet.dismiss();
        adapter.notifyDataSetChanged();

    }
}