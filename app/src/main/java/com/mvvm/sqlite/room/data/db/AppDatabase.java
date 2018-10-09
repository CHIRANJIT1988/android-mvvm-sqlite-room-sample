package com.mvvm.sqlite.room.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.mvvm.sqlite.room.data.dao.StudentDao;
import com.mvvm.sqlite.room.model.Student;


@Database(entities = {Student.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase
{

    private static AppDatabase INSTANCE;

    public abstract StudentDao studentDao();

    public static AppDatabase getAppDatabase(Context context)
    {
        if (INSTANCE == null)
        {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "student-database")
                            // allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                            .build();
        }

        return INSTANCE;
    }

    public static void destroyInstance()
    {
        INSTANCE = null;
    }
}