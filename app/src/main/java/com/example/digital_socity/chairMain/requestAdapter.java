package com.example.digital_socity.chairMain;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digital_socity.databinding.RequestItemLayoutBinding;

import java.util.ArrayList;

public class requestAdapter extends RecyclerView.Adapter<requestAdapter.viewHolder> {

    private ArrayList<memberRequestModel> list;
    private Context context;
    private RequestItemLayoutBinding binding;

    public requestAdapter(ArrayList<memberRequestModel> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding=RequestItemLayoutBinding.inflate(LayoutInflater.from(context));
        return new viewHolder(binding);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        memberRequestModel requestModel= list.get(position);
        holder.binding.tvusername.setText(requestModel.getFirstName()+" "+requestModel.getLastName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        RequestItemLayoutBinding binding;
        public viewHolder(RequestItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
