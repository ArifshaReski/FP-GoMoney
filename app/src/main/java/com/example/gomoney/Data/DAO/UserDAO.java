package com.example.gomoney.Data.DAO;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.gomoney.Data.Model.User;

@Dao
public interface UserDAO {

    @Insert
    void Register(User users);

    @Query("SELECT * FROM User WHERE Email=(:mail) and Password=(:pass)")
    User login(String mail, String pass);

}
