package com.example.digital_socity.chairMain.complain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.digital_socity.databinding.ComplainItemRcvBinding;
import java.util.ArrayList;

public class complainAdapter extends RecyclerView.Adapter<complainAdapter.viewHolder> {
    private ArrayList<complainModel> list;
    private Context context;
    private ComplainItemRcvBinding binding;

    public complainAdapter(ArrayList<complainModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding=ComplainItemRcvBinding.inflate(LayoutInflater.from(context));

        return new viewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position)
    {
        complainModel complainModel=list.get(position);
        holder.binding.complainName.setText(complainModel.getName());
        holder.binding.complaintitle.setText(complainModel.getComplainTitle());
        holder.binding.complaindesc.setText(complainModel.getComplainDesc());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ComplainItemRcvBinding binding;
        public viewHolder(ComplainItemRcvBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
