package com.jobportalemployer.app.data.api;

import com.jobportalemployer.app.data.model.CityResponce;
import com.jobportalemployer.app.data.model.CountryModel;
import com.jobportalemployer.app.data.model.LoginResponce;
import com.jobportalemployer.app.data.model.RegistrationResponse;
import com.jobportalemployer.app.data.model.StateData;
import com.jobportalemployer.app.data.model.StateResponce;
import com.jobportalemployer.app.data.model.WebResponse;

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
                                         @Field("input_country") String country,
                                         @Field("input_state") String state,
                                         @Field("input_city") String city,
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
