package com.example.digital_socity.chairMain.notice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.digital_socity.databinding.BottomsheetLayoutNoticeBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class bottomsheet extends BottomSheetDialogFragment {

    interface onbtnclick{
        void onbtnclicklistener(BottomsheetLayoutNoticeBinding binding);
    }
    private onbtnclick onbtnclick;

    public bottomsheet(bottomsheet.onbtnclick onbtnclick) {
        this.onbtnclick = onbtnclick;
    }

    private BottomsheetLayoutNoticeBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=BottomsheetLayoutNoticeBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnAddnotice.setOnClickListener(view1 -> {
            onbtnclick.onbtnclicklistener(binding);
        });

    }
}
