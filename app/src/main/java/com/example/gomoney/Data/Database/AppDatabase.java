package com.example.gomoney.Data.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.gomoney.Data.DAO.UserDAO;
import com.example.gomoney.Data.Model.User;

@Database(entities = {User.class},version = 1)

public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDAO userDAO();
}
