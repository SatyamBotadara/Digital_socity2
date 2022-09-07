package com.example.digital_socity.chairMain.complain;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.digital_socity.R;
import com.example.digital_socity.databinding.FragmentComplainBinding;

import java.util.ArrayList;


public class complainFragment extends Fragment {

    private FragmentComplainBinding binding;
    private ArrayList<complainModel> list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentComplainBinding.inflate(getLayoutInflater());
        list=new ArrayList<>();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list.add(new complainModel("satyam","not good env","this is the main issue with the society that there is not good env for childerens"));
        list.add(new complainModel("satyam","not good env","this is the main issue with the society that there is not good env for childerens"));
        list.add(new complainModel("satyam","not good env","this is the main issue with the society that there is not good env for childerens"));
        list.add(new complainModel("satyam","not good env","this is the main issue with the society that there is not good env for childerens"));
        complainAdapter adapter=new complainAdapter(list,getContext());
        binding.complainRcv.setAdapter(adapter);
        binding.complainRcv.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}