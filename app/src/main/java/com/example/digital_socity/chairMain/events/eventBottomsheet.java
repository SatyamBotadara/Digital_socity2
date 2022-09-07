package com.example.digital_socity.chairMain.events;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.digital_socity.databinding.BottomsheetEventDialogBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class eventBottomsheet extends BottomSheetDialogFragment
{
    interface onclick{
        void onsetdateclicklistener(BottomsheetEventDialogBinding binding);
        void onbtnaddclicklistener(BottomsheetEventDialogBinding binding);
    }
    private onclick click;
    private BottomsheetEventDialogBinding binding;

    public eventBottomsheet(onclick click) {
        this.click = click;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=BottomsheetEventDialogBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnAddnotice.setOnClickListener(view1 -> {
            click.onbtnaddclicklistener(binding);
        });

        binding.datepickerevent.setOnClickListener(view12 -> {
            click.onsetdateclicklistener(binding);
        });

    }
}
