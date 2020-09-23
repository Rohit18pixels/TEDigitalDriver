package com.jobportalemployer.asizone.presenter.api;

import com.jobportalemployer.asizone.model.auth.CityResponce;
import com.jobportalemployer.asizone.model.auth.CountryModel;
import com.jobportalemployer.asizone.model.auth.LoginResponce;
import com.jobportalemployer.asizone.model.auth.OTPResponce;
import com.jobportalemployer.asizone.model.auth.RegistrationResponse;
import com.jobportalemployer.asizone.model.auth.StateResponce;
import com.jobportalemployer.asizone.model.jobpost.AreaSectorResponce;
import com.jobportalemployer.asizone.model.jobpost.DesignationDataum;
import com.jobportalemployer.asizone.model.jobpost.DesignationResponce;
import com.jobportalemployer.asizone.model.jobpost.ExperienceResponce;
import com.jobportalemployer.asizone.model.jobpost.JobtypeResponse;
import com.jobportalemployer.asizone.model.jobpost.LocationResponse;
import com.jobportalemployer.asizone.model.jobpost.QualificationResponce;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @POST("/api/employer_register")
    @FormUrlEncoded
    Call<RegistrationResponse> getComReg(@Field("input_email") String email,
                                         @Field("input_password") String password,
                                         @Field("input_pincode") String pincode,
                                         @Field("input_country") int country,
                                         @Field("input_state") int state,
                                         @Field("input_city") int city,
                                         @Field("input_company") String company,
                                         @Field("input_contact_person") String phone,
                                         @Field("input_Mobile") String mobile);

    @FormUrlEncoded
    @POST("/API/login_employer")
    Call<LoginResponce> getEmpLogin(@Field("email") String email,
                                    @Field("password") String password);

    @FormUrlEncoded
    @POST("/API/statelist")
    Call<StateResponce> executeState(@Field("cid") int email);

    @FormUrlEncoded
    @POST("/API/citylist")
    Call<CityResponce> executeCity(@Field("sid") int email);


    @GET("/API/countrylist")
    Call<CountryModel> executeCountry();

    @FormUrlEncoded
    @POST("/api/employer_otp_verify")
    Call<OTPResponce> executeotpverify(@Field("otp") int otp, @Field("eid") int eid);

    @FormUrlEncoded
    @POST("/api/fetch")
    Call<LocationResponse> postaJob(@Field("keyword") String value);

    @FormUrlEncoded
    @POST("/api/fetch")
    Call<QualificationResponce> qualification(@Field("keyword") String value);

    @FormUrlEncoded
    @POST("/api/fetch")
    Call<JobtypeResponse> jobtypes(@Field("keyword") String value);

    @FormUrlEncoded
    @POST("/api/fetch")
    Call<AreaSectorResponce> areasectors(@Field("keyword") String value);

    @FormUrlEncoded
    @POST("/api/fetch")
    Call<DesignationResponce> designation(@Field("keyword") String value);

    @FormUrlEncoded
    @POST("/api/fetch")
    Call<ExperienceResponce> experiencePost(@Field("keyword") String value);




    /*@POST("/hot/api/authentication/verify-phone")
    @FormUrlEncoded
    Call<WebResponse> getPhoneVerify(@Header("Authorization") String auth_key,
                                     @Header("X-API-KEY") String api_key,
                                     @Field("phone") String phone);


    @POST("/hot/api/authentication/registration")
    @FormUrlEncoded
    Call<WebResponse> getRegister(@Header("Authorization") String auth_key,
                                  @Header("X-API-KEY") String api_key,
                                  @Field("first_name") String firstname,
                                  @Field("last_name") String lastname,
                                  @Field("email") String email,
                                  @Field("phone") String phone,
                                  @Field("password") String password);




*/
}
