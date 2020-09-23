package com.jobportalemployer.asizone.presenter.repository;

import com.jobportalemployer.asizone.model.auth.LoginResponce;
import com.jobportalemployer.asizone.model.jobpost.AreaSectorResponce;
import com.jobportalemployer.asizone.model.jobpost.DesignationResponce;
import com.jobportalemployer.asizone.model.jobpost.ExperienceResponce;
import com.jobportalemployer.asizone.model.jobpost.JobtypeResponse;
import com.jobportalemployer.asizone.model.jobpost.LocationResponse;
import com.jobportalemployer.asizone.model.jobpost.QualificationResponce;
import com.jobportalemployer.asizone.presenter.api.ApiResponseHandler;
import com.jobportalemployer.asizone.presenter.api.ApiService;
import com.jobportalemployer.asizone.presenter.api.ApiServiceImpl;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JobPostRepository {

    private static ApiService myInterface ;

    public JobPostRepository() {
        myInterface =  ApiServiceImpl.getClient();
    }

    public void postLocation(String location, ApiResponseHandler<LocationResponse> apiResponseHandler) {
        Call<LocationResponse> locationPost = myInterface.postaJob(location);
        locationPost.enqueue(new Callback<LocationResponse>() {
            @Override
            public void onResponse(@NotNull Call<LocationResponse> call, @NotNull Response<LocationResponse> response) {
                if (response.body() != null) {
                    apiResponseHandler.onSuccessResponse(response.body());
                }else {
                    apiResponseHandler.onErrorResponse(response.message());
                }
            }
            //(t == null)? "" : t.getMessage()
            @Override
            public void onFailure(@NotNull Call<LocationResponse> call, @NotNull Throwable t) {
                apiResponseHandler.onErrorResponse(t.getMessage());

            }
        });
    }

    public void qualification(String qualification, ApiResponseHandler<QualificationResponce> apiResponseHandler) {
        Call<QualificationResponce> qualificationPost = myInterface.qualification(qualification);
        qualificationPost.enqueue(new Callback<QualificationResponce>() {
            @Override
            public void onResponse(@NotNull Call<QualificationResponce> call, @NotNull Response<QualificationResponce> response) {
                if (response.body() != null) {
                    apiResponseHandler.onSuccessResponse(response.body());
                }else {
                    apiResponseHandler.onErrorResponse(response.message());
                }
            }
            //(t == null)? "" : t.getMessage()
            @Override
            public void onFailure(@NotNull Call<QualificationResponce> call, @NotNull Throwable t) {
                apiResponseHandler.onErrorResponse(t.getMessage());

            }
        });
    }

    public void jobtype(String jobtype, ApiResponseHandler<JobtypeResponse> apiResponseHandler) {

        Call<JobtypeResponse> jobtypePost = myInterface.jobtypes(jobtype);
        jobtypePost.enqueue(new Callback<JobtypeResponse>() {
            @Override
            public void onResponse(@NotNull Call<JobtypeResponse> call, @NotNull Response<JobtypeResponse> response) {
                if (response.body() != null) {
                    apiResponseHandler.onSuccessResponse(response.body());
                }else {
                    apiResponseHandler.onErrorResponse(response.message());
                }
            }
            //(t == null)? "" : t.getMessage()
            @Override
            public void onFailure(@NotNull Call<JobtypeResponse> call, @NotNull Throwable t) {
                apiResponseHandler.onErrorResponse(t.getMessage());

            }
        });
    }


    public void areaofsector(String areasector, ApiResponseHandler<AreaSectorResponce> apiResponseHandler) {

        Call<AreaSectorResponce> sectors = myInterface.areasectors(areasector);
        sectors.enqueue(new Callback<AreaSectorResponce>() {
            @Override
            public void onResponse(@NotNull Call<AreaSectorResponce> call, @NotNull Response<AreaSectorResponce> response) {
                if (response.body() != null) {
                    apiResponseHandler.onSuccessResponse(response.body());
                }else {
                    apiResponseHandler.onErrorResponse(response.message());
                }
            }
            //(t == null)? "" : t.getMessage()
            @Override
            public void onFailure(@NotNull Call<AreaSectorResponce> call, @NotNull Throwable t) {
                apiResponseHandler.onErrorResponse(t.getMessage());

            }
        });
    }

    public void designation(String text, ApiResponseHandler<DesignationResponce> apiResponseHandler) {

        Call<DesignationResponce> callMethod = myInterface.designation(text);
        callMethod.enqueue(new Callback<DesignationResponce>() {
            @Override
            public void onResponse(@NotNull Call<DesignationResponce> call, @NotNull Response<DesignationResponce> response) {
                if (response.body() != null) {
                    apiResponseHandler.onSuccessResponse(response.body());
                }else {
                    apiResponseHandler.onErrorResponse(response.message());
                }
            }
            //(t == null)? "" : t.getMessage()
            @Override
            public void onFailure(@NotNull Call<DesignationResponce> call, @NotNull Throwable t) {
                apiResponseHandler.onErrorResponse(t.getMessage());

            }
        });
    }

    public void experience(String text, ApiResponseHandler<ExperienceResponce> apiResponseHandler) {

        Call<ExperienceResponce> callMethod = myInterface.experiencePost(text);
        callMethod.enqueue(new Callback<ExperienceResponce>() {
            @Override
            public void onResponse(@NotNull Call<ExperienceResponce> call, @NotNull Response<ExperienceResponce> response) {
                if (response.body() != null) {
                    apiResponseHandler.onSuccessResponse(response.body());
                }else {
                    apiResponseHandler.onErrorResponse(response.message());
                }
            }
            //(t == null)? "" : t.getMessage()
            @Override
            public void onFailure(@NotNull Call<ExperienceResponce> call, @NotNull Throwable t) {
                apiResponseHandler.onErrorResponse(t.getMessage());

            }
        });
    }
}
