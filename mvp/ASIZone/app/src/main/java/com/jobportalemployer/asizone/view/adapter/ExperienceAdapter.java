package com.jobportalemployer.asizone.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jobportalemployer.asizone.R;
import com.jobportalemployer.asizone.model.jobpost.AreaSectorDataum;
import com.jobportalemployer.asizone.model.jobpost.ExperienceDataum;

import java.util.List;

public class ExperienceAdapter extends RecyclerView.Adapter<ExperienceAdapter.ViewHolder>
{

    List<ExperienceDataum> list ;
    public ExperienceAdapter(List<ExperienceDataum> list) {
        this.list = list;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_location_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ExperienceDataum dataum = list.get(position);

        holder.textView.setText(dataum.getName());
        holder.textView.setOnClickListener(v -> {
            holder.viewLinear.setBackgroundResource(R.drawable.capsule_selected);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        LinearLayout viewLinear;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.txtCapsule);
            viewLinear = itemView.findViewById(R.id.viewLinear);
        }
    }
}
