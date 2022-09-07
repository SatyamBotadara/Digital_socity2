package com.example.digital_socity.chairMain;

import   android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.digital_socity.databinding.FragmentRequestBinding;

import java.util.ArrayList;


public class Request extends Fragment {

    private ArrayList<memberRequestModel> list;
    private FragmentRequestBinding binding;
   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        binding=FragmentRequestBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list= new ArrayList<>();
        list.add(new memberRequestModel("satyam","botadara"));
        list.add(new memberRequestModel("satyam2","botadara2"));
        requestAdapter adapter=new requestAdapter(list,getActivity());
        binding.rcvRequest.setAdapter(adapter);
        binding.rcvRequest.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}