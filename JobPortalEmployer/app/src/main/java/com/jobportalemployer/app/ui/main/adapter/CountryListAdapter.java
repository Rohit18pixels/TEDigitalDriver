package com.jobportalemployer.app.ui.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.jobportalemployer.app.BR;
import com.jobportalemployer.app.R;
import com.jobportalemployer.app.data.model.CountryResponce;

import java.util.List;

public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.ViewHolder> {

    private List<CountryResponce> arrayList;
    private onClickInterface onClickInterface;
    private ViewDataBinding binding;

    public CountryListAdapter(List<CountryResponce> arrayList, onClickInterface onClickInterface) {
        this.arrayList = arrayList;
        this.onClickInterface = onClickInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_country, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        CountryResponce countryResponce = arrayList.get(position);
//        holder.bind(countryResponce);

        binding.setVariable(BR.countryName, countryResponce);
        binding.getRoot().setOnClickListener(v -> onClickInterface.onClicked(countryResponce.getId(), countryResponce.getName()));
        binding.executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull ViewDataBinding binding) {
            super(binding.getRoot());


        }
    }

    public interface onClickInterface {
        void onClicked(int countryId, String countryName);
    }
}
