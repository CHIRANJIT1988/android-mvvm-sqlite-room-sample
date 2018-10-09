package com.mvvm.sqlite.room.data;

import com.mvvm.sqlite.room.data.db.AppDatabase;
import com.mvvm.sqlite.room.model.Student;

import java.util.List;


public class DatabaseInitializer
{
    private static final String TAG = DatabaseInitializer.class.getName();

    public static long insertStudent(final AppDatabase db, final Student student)
    {
        return db.studentDao().insert(student);
    }

    public static List<Student> getAllStudent(final AppDatabase db)
    {
        return db.studentDao().getAll();
    }
}