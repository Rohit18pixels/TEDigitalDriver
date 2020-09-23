package com.tedigital.driver.app.support.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<B extends ViewDataBinding, D> extends RecyclerView.Adapter<BaseAdapter.ViewHolder> {

    private ArrayList<D> data;
    private Listener listener;

    public BaseAdapter(ArrayList<D> data) {
        this.data = data;
    }

    public interface Listener {

        void onAdapterItem(Object data, int position);
    }

    public void setListener(Listener listener)
    {
        this.listener = listener;
    }

    public Listener getListener() {
        return listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        B binding = DataBindingUtil.inflate(inflater, getLayout(), parent, false);
        return getViewHolder(binding);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void addData(List<D> model) {
        data.addAll(model);
        notifyDataSetChanged();
    }

    public List<D> getData()
    {
        return  data;
    }

    public void clearData() {
        data.clear();
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(data.get(position), position);
    }

    public abstract static class ViewHolder<B extends ViewDataBinding, D> extends RecyclerView.ViewHolder {

        private int position;
        private B binding;

        protected ViewHolder(B binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public B getBinding() {
            return binding;
        }

        void bind(D data, int position) {
            this.position = position;
            bindData(data);
            setClickListeners(data, position);
            action(binding, data, position);
        }

        protected abstract void action(B binding, D data, int position);

        /**
         *
         * @param data binding.setCalendarData(new AdapterViewModel(CalendarData));
         */
        protected abstract void bindData(D data);

        protected void setClickListeners(D data, int position) {
            ViewHolderClickListener viewHolderClickListener = viewHolderReference(binding, data,
                    position);
            setClickListeners(viewHolderClickListener, binding, data);
        }

        public abstract void setClickListeners(ViewHolderClickListener thisContext,
                                               B binding, D data);

        protected abstract ViewHolderClickListener viewHolderReference(
                B binding, D data, int position);

    }


    public static abstract class ViewHolderClickListener<B extends ViewDataBinding, D> implements View.OnClickListener{
        protected final int position;
        protected B binding;
        private final D data;

        public ViewHolderClickListener(B binding, D data, int position) {
            this.position = position;
            this.binding = binding;
            this.data = data;
        }

        @Override
        public abstract void onClick(View view);
    }

    public abstract ViewHolder getViewHolder(B binding);

    @LayoutRes
    protected abstract int getLayout();

}
