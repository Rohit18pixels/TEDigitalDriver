package com.jobportalemployer.asizone.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;


import com.jobportalemployer.asizone.BR;
import com.jobportalemployer.asizone.R;
import com.jobportalemployer.asizone.model.auth.StateData;

import java.util.List;

public class StateListAdapter extends RecyclerView.Adapter<StateListAdapter.ViewHolder> {

    private List<StateData> arrayList;
    private onClickInterfaceState onClickInterface;
    private ViewDataBinding binding;

    public StateListAdapter(List<StateData> arrayList, onClickInterfaceState onClickInterface) {
        this.arrayList = arrayList;
        this.onClickInterface = onClickInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_state, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        StateData StateData = arrayList.get(position);
//        holder.bind(StateData);

        binding.setVariable(BR.stateName, StateData);
        binding.getRoot().setOnClickListener(v -> onClickInterface.onClickedState(StateData.getId(), StateData.getName()));
        binding.executePendingBindings();

    }

    @Override
    public int getItemViewType(int position)
    {
        return position;
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

    public interface onClickInterfaceState {
        void onClickedState(int stateId, String stateName);
    }
}
