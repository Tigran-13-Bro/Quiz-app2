package com.sagarkhurana.quizforfun.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Attempt.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}