package com.example.digital_socity.chairMain.notice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.digital_socity.databinding.LayoutNoticeRcvItemBinding;
import java.util.ArrayList;

public class noticeAdapter extends RecyclerView.Adapter<noticeAdapter.viewHolder> {

    private ArrayList<noticeModel> list;
    private Context context;
    private LayoutNoticeRcvItemBinding binding;

    public noticeAdapter(ArrayList<noticeModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding=LayoutNoticeRcvItemBinding.inflate(LayoutInflater.from(context));
        return new viewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position)
    {
        noticeModel model=list.get(position);
        holder.binding.rcvitemNotesTitle.setText(model.getTitle());
        holder.binding.rcvitemNotesDesc.setText(model.getDesc());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        LayoutNoticeRcvItemBinding binding;
        public viewHolder(LayoutNoticeRcvItemBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
