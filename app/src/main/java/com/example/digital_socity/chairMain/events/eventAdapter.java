package com.example.digital_socity.chairMain.events;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digital_socity.databinding.EventRcvItemBinding;

import java.util.ArrayList;

public class eventAdapter extends RecyclerView.Adapter<eventAdapter.viewHolder> {

    private ArrayList<eventModel> list;
    private Context context;
    private EventRcvItemBinding binding;

    public eventAdapter(ArrayList<eventModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding=EventRcvItemBinding.inflate(LayoutInflater.from(context));
        return new viewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position)
    {
        eventModel event=list.get(position);
        binding.tveventDate.setText(event.getDate());
        binding.tvtitleEvent.setText(event.getEventTitle());
        binding.tveventDesc.setText(event.getEvenetDescription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        public viewHolder(EventRcvItemBinding binding) {
            super(binding.getRoot());
        }
    }
}
