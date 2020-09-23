package com.machinetest.app.data.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.machinetest.app.ui.login.LoginActivity;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    Long insert(User u);

    @Query("SELECT * FROM users ORDER BY id DESC")
    List<User> getAllUsers();

    @Query("SELECT * FROM users WHERE id =:id")
    User getUser(int id);

    @Update
    void update(User u);

    @Delete
    void delete(User u);

//    @Query("SELECT logged_in FROM users where logged_in = tr")
//    boolean isUserLogged(String userName);
}
