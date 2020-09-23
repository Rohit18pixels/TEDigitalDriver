package com.tedigital.driver.app.support.base;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;

public class BaseViewModel extends ViewModel {

    private CompositeDisposable mCompositeDisposable;
    private MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private MutableLiveData<String> error = new MutableLiveData<>();

    protected BaseViewModel() {
        this.mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.dispose();
        super.onCleared();
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    public LiveData<Boolean> getLoading() {
        return loading;
    }

    public void isLoading(boolean loading) {
        this.loading.postValue(loading);
    }

    public LiveData<String> getError() {
        return error;
    }

    public void setError(String error) {
        this.error.postValue(error);
    }

}
