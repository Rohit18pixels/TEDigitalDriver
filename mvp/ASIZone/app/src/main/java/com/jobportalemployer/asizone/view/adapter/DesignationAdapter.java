package com.jobportalemployer.asizone.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jobportalemployer.asizone.R;
import com.jobportalemployer.asizone.model.jobpost.AreaSectorDataum;
import com.jobportalemployer.asizone.model.jobpost.DesignationDataum;
import com.jobportalemployer.asizone.presenter.utils.AppStuffs;

import java.util.ArrayList;
import java.util.List;

public class DesignationAdapter extends RecyclerView.Adapter<DesignationAdapter.ViewHolder> {

    List<DesignationDataum> list;
    private int selected = -1;
    Context context;

    public DesignationAdapter(Context context, List<DesignationDataum> list) {
        this.list = list;
//        this.selected = selected;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_location_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        DesignationDataum dataum = list.get(position);

        holder.textView.setText(dataum.getName());

        holder.textView.setOnClickListener(v -> {

            selected = position;

            if(selected == position)
            {
                holder.viewLinear.setBackgroundResource(R.drawable.capsule_selected);

            }
            else
            {
                holder.viewLinear.setBackgroundResource(R.drawable.capsule);

            }
//
//            if (selected.size() == 0) {
//                selected.add(position);
//                holder.viewLinear.setBackgroundResource(R.drawable.capsule_selected);
//                Toast.makeText(context, "size" + selected.size(), Toast.LENGTH_SHORT).show();
//            }
//            else {
//                for (int i=0; i<selected.size(); i++) {
//
//                    if (selected.get(i) != position) {
//                        selected.add(position);
//
//                        Toast.makeText(context, "Sele" + position, Toast.LENGTH_SHORT).show();
//                    } else {
//
//                        selected.remove(position);
//                        Toast.makeText(context, "un" + position, Toast.LENGTH_SHORT).show();
//
//
//                    }
//                }
//            }
        });


//        for(int i=0; i<selected.size(); i++) {
//
//            if (selected.get(i) != position) {
//                selected.add(position);
//                holder.viewLinear.setBackgroundResource(R.drawable.capsule_selected);
//                Toast.makeText(context, "Sele" + position, Toast.LENGTH_SHORT).show();
//            } else {
//
//                Toast.makeText(context, "un" + position, Toast.LENGTH_SHORT).show();
//
//                holder.viewLinear.setBackgroundResource(R.drawable.capsule);
//            }
//        }
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
