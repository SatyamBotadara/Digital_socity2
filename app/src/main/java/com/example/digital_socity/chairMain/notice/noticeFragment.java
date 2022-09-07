package com.example.digital_socity.chairMain.notice;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.digital_socity.databinding.BottomsheetLayoutNoticeBinding;
import com.example.digital_socity.databinding.FragmentNoticeBinding;
import java.util.ArrayList;
import java.util.Objects;

public class noticeFragment extends Fragment implements bottomsheet.onbtnclick{

    private FragmentNoticeBinding binding;
    private ArrayList<noticeModel> list;
    bottomsheet bottomsheet=new bottomsheet(this);
    noticeAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        list=new ArrayList<>();
        binding=FragmentNoticeBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        BottomsheetLayoutNoticeBinding binding2=BottomsheetLayoutNoticeBinding.inflate(getLayoutInflater());;

         adapter=new noticeAdapter(list,getContext());
        binding.noticercv.setAdapter(adapter);
        binding.noticercv.setLayoutManager(new LinearLayoutManager(getContext()));

        binding.fabnotice.setOnClickListener(view1 -> {




            bottomsheet.show(getParentFragmentManager(),"dialog");


        });
    }


    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onbtnclicklistener(BottomsheetLayoutNoticeBinding binding2) {

        list.add(new noticeModel(Objects.requireNonNull(binding2.inputNoticeTitle.getText()).toString(),binding2.inputNoticeDesc.getText().toString()));
        binding2.inputNoticeTitle.setText("");
        binding2.inputNoticeDesc.setText("");
        adapter.notifyDataSetChanged();
        bottomsheet.dismiss();

    }
}