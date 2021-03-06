package com.jobportalemployer.app.ui.main.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.jobportalemployer.app.BR;
import com.jobportalemployer.app.R;
import com.jobportalemployer.app.data.model.CityData;
import com.jobportalemployer.app.data.model.CityResponce;
import com.jobportalemployer.app.data.model.CountryResponce;

import java.util.List;

public class CityListAdapter extends RecyclerView.Adapter<CityListAdapter.ViewHolder> {

    private List<CityData> arrayList;
    private onClickInterfaceCity onClickInterface;
    private ViewDataBinding binding;

    public CityListAdapter(List<CityData> arrayList, onClickInterfaceCity onClickInterface) {
        this.arrayList = arrayList;
        this.onClickInterface = onClickInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_city, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        CityData cityResponce = arrayList.get(position);
//        holder.bind(countryResponce);

        binding.setVariable(BR.cityName, cityResponce);
        binding.getRoot().setOnClickListener(v -> onClickInterface.onClickedCity(cityResponce.getId(), cityResponce.getName()));
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

    public interface onClickInterfaceCity {
        void onClickedCity(int cityId, String cityName);
    }
}
