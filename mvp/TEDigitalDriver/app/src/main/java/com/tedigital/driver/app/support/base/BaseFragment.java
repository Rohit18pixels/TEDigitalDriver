package com.tedigital.driver.app.support.base;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.fxn.cue.Cue;
import com.fxn.cue.enums.Duration;
import com.fxn.cue.enums.Type;
import com.google.android.material.navigation.NavigationView;
import com.tedigital.driver.app.R;
import com.tedigital.driver.app.support.Constant;
import com.tedigital.driver.app.support.Utilities;

public abstract class BaseFragment<B extends ViewDataBinding, V extends ViewModel> extends Fragment {

    private BaseActivity activity;
    private B binding;
    private V viewModel;
    private OnFragmentInteractionListener mListener;

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String title);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(activity).get(setViewModel());
        getViewModel(viewModel);
        setHasOptionsMenu(false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            this.activity = (BaseActivity) context;
            try {
                mListener = (OnFragmentInteractionListener) activity;
            } catch (ClassCastException e) {
                                                                         throw new ClassCastException(activity.toString()
                        + " must implement OnFragmentInteractionListener");
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        if (mListener != null) {
            mListener.onFragmentInteraction(getTitle());
        }
        binding = DataBindingUtil.inflate(inflater, getLayout(), container, false);
        getBinding(binding);

        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activity = null;
        viewModel = null;
        mListener = null;
        System.gc();
    }

    public BaseActivity getBaseActivity() {
        return activity;
    }

    protected abstract Class<V> setViewModel();

    @LayoutRes
    public abstract int getLayout();

    public abstract String getTitle();

    protected abstract void getBinding(B binding);

    protected abstract void getViewModel(V viewModel);

    protected abstract void init();

    public boolean inputValidate(String editText)
    {
        if (TextUtils.isEmpty(editText))
            return false;
        else
            return true;

    }

    public void showToast(String message, String type) {
        if (type.equalsIgnoreCase(Constant.TOAST_SUCCESS)) {
            Cue.init().with(getContext())
                    .setMessage(message)
                    .setType(Type.SUCCESS)
                    .setGravity(Gravity.BOTTOM)
                    .setPadding(20)
                    .setDuration(Duration.LONG)
                    .show();
        } else if (type.equalsIgnoreCase(Constant.TOAST_ERROR)) {
            Utilities.vibrate(getContext());
            Cue.init().with(getContext())
                    .setMessage(message)
                    .setType(Type.DANGER)
                    .setGravity(Gravity.BOTTOM)
                    .setPadding(20)
                    .setDuration(Duration.LONG)
                    .show();
        } else {
            Cue.init().with(getContext())
                    .setMessage(message)
                    .setType(Type.DARK)
                    .setGravity(Gravity.BOTTOM)
                    .setPadding(20)
                    .setDuration(Duration.LONG)
                    .show();
        }
    }

    public void loadFragment(Fragment fragment)
    {
        FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
        supportFragmentManager.beginTransaction().replace(R.id.fragment, fragment)
                .commit();
    }
    public void hideKeyboard() {
        View view = getActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }
}
