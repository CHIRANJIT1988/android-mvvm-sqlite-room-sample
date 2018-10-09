package com.mvvm.sqlite.room.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.mvvm.sqlite.room.model.Student;

import java.util.List;


@Dao
public interface StudentDao
{
    @Query("SELECT * FROM STUDENT")
    List<Student> getAll();

    @Query("SELECT COUNT(*) FROM STUDENT")
    int count();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(Student student);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertAll(List<Student> students);

    @Delete
    void delete(Student student);
}