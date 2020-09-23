package com.machinetest.app.data.repository;

import android.content.Context;

import androidx.room.TypeConverter;

import com.machinetest.app.data.api.ApiResponseHandler;
import com.machinetest.app.data.api.ApiService;
import com.machinetest.app.data.api.ApiServiceImpl;
import com.machinetest.app.data.api.UserDatabase;
import com.machinetest.app.data.model.HeroesResponse;
import com.machinetest.app.data.model.User;
import com.machinetest.app.data.model.UserDao;

import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private final UserDao dao;

    private static ApiService myInterface ;

    public UserRepository(Context context) {
        dao = UserDatabase.getAppDatabase(context).userDao();
        myInterface =  ApiServiceImpl.getClient();
    }

//    public boolean isUserLogged(String userName) {
//        return dao.isUserLogged(userName);
//    }

    public boolean login(String userName, String password) {


        List<User> users = dao.getAllUsers();

        System.out.println("user"+users);
        for (User user:users) {

            if(user.getUserName().equals(userName) && password.equals(user.getPassword()))
            {
                System.out.println("user"+userName+"   "+user.getPassword());
                return true;
            }
        }

        //get single user by id
//        User u = dao.getUser(0);
        return false;
    }

    public Long registration(String username, String fullname, String phone, String dob, String gender, String password) {


        System.out.println("user"+username + fullname);

        List<User> users = dao.getAllUsers();

        if(!users.isEmpty()) {
            for (User user : users) {

                if (user.getUserName().equals(username)) {
                    return -1l;
                } else {

//init the entity
                    User u = new User();
                    u.setUserName(username);
                    u.setFullName(fullname);
                    u.setPhone(phone);
                    u.setDob(Long.parseLong(dob));
                    u.setGender(gender);
                    u.setPassword(password);

//init dao and perform operation

                    System.out.println("user" + u);
                    return dao.insert(u);
                }
            }
        }
        else
        {
            User u = new User();
            u.setUserName(username);
            u.setFullName(fullname);
            u.setPhone(phone);
            u.setDob(Long.parseLong(dob));
            u.setGender(gender);
            u.setPassword(password);

            System.out.println("user" + u);
            return dao.insert(u);
        }
        return 1l;
    }

    public List<User> getList(){
        return dao.getAllUsers();
    }


    public void fetchHeroes(ApiResponseHandler<HeroesResponse> apiResponseHandler) {

        Call<HeroesResponse> callMethod = myInterface.fetcHeroes();
        callMethod.enqueue(new Callback<HeroesResponse>() {
            @Override
            public void onResponse(@NotNull Call<HeroesResponse> call, @NotNull Response<HeroesResponse> response) {
                if (response.body() != null) {
                    apiResponseHandler.onSuccessResponse(response.body());
                }else {
                    apiResponseHandler.onErrorResponse(response.message());
                }
            }
            //(t == null)? "" : t.getMessage()
            @Override
            public void onFailure(@NotNull Call<HeroesResponse> call, @NotNull Throwable t) {
                apiResponseHandler.onErrorResponse(t.getMessage());

            }
        });
    }
}
