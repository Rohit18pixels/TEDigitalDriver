package com.machinetest.app.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.machinetest.app.R;
import com.machinetest.app.data.model.HeroDataum;
import com.machinetest.app.support.AppStuffs;

import org.w3c.dom.Text;

import java.util.List;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.ViewHolder> {

    List<HeroDataum> listDataums;
    public HeroesAdapter(List<HeroDataum> listDataums) {

        this.listDataums = listDataums;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_heroes_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        HeroDataum heroDataum = listDataums.get(position);
        holder.textView.setText(heroDataum.getName());
        AppStuffs.Picasso(heroDataum.getImageurl(), holder.imgHeroes);

    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return listDataums.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgHeroes;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgHeroes = itemView.findViewById(R.id.imgHeroes);
            textView = itemView.findViewById(R.id.txtHeroName);
        }
    }
}
