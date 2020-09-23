package com.tedigital.driver.app.data.api;

public abstract class ApiResponseHandler<T>{

    public abstract void onSuccessResponse(T response);
    public abstract void onErrorResponse(String errorMessage);
}
