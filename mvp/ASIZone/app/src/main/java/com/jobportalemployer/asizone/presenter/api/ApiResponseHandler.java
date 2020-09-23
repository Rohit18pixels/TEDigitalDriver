package com.jobportalemployer.asizone.presenter.api;

public abstract class ApiResponseHandler<T>{

    public abstract void onSuccessResponse(T response);
    public abstract void onErrorResponse(String errorMessage);
}
