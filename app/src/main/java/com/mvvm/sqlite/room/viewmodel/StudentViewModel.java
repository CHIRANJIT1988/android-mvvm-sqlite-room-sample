package com.mvvm.sqlite.room.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableInt;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.mvvm.sqlite.room.BR;
import com.mvvm.sqlite.room.data.DatabaseInitializer;
import com.mvvm.sqlite.room.data.db.AppDatabase;
import com.mvvm.sqlite.room.model.Student;
import com.mvvm.sqlite.room.view.StudentActivity;
import com.mvvm.sqlite.room.view.adapter.StudentRecyclerAdapter;

import java.util.List;


public class StudentViewModel extends BaseObservable
{
    private Context context;

    public ObservableInt progress;
    public ObservableInt recycler;

    private List<Student> studentList;
    private Student student;
    private StudentRecyclerAdapter adapter;


    StudentViewModel(Context context)
    {
        this.context = context;

        this.progress = new ObservableInt(View.VISIBLE);
        this.recycler = new ObservableInt(View.GONE);
    }

    public StudentViewModel(Context context, Student student)
    {
        this(context);
        this.student = student;
    }

    public StudentViewModel(Context context, List<Student> studentList, StudentRecyclerAdapter adapter)
    {
        this(context);

        this.studentList = studentList;
        this.adapter = adapter;
    }

    public void onClickFabLoad(View view)
    {
        context.startActivity(new Intent(context, StudentActivity.class));
    }


    public void onSaveClick(View view)
    {
        if(!student.isValidName())
        {
            Toast.makeText(view.getContext(), "Name should be minimum 3 characters", Toast.LENGTH_SHORT).show();
            return;
        }

        if(!student.isValidEmail())
        {
            Toast.makeText(view.getContext(), "Invalid Email", Toast.LENGTH_SHORT).show();
        }

        if(!student.isValidPhoneNo())
        {
            Toast.makeText(view.getContext(), "Invalid Mobile No.", Toast.LENGTH_SHORT).show();
            return;
        }

        if(DatabaseInitializer.insertStudent(AppDatabase.getAppDatabase(context), student) != -1)
        {
            Toast.makeText(view.getContext(), "Record Inserted", Toast.LENGTH_SHORT).show();
            ((Activity) context).finish();
            return;
        }

        Toast.makeText(view.getContext(), "Failed to Insert", Toast.LENGTH_SHORT).show();
    }

    public void reloadData()
    {
        this.changeStudentDataSet(DatabaseInitializer.getAllStudent(AppDatabase.getAppDatabase(context)));
    }

    private void changeStudentDataSet(List<Student> studentList)
    {
        this.studentList.clear();
        this.studentList.addAll(studentList);

        new Handler().post(new Runnable() {

            @Override
            public void run()
            {
                progress.set(View.GONE);
                recycler.set(View.VISIBLE);

                notifyPropertyChanged(BR.studentList);
            }
        });
    }


    @Bindable
    public List<Student> getStudentList()
    {
        return studentList;
    }

    @Bindable
    public StudentRecyclerAdapter getAdapter()
    {
        return this.adapter;
    }


    /**
     * Bind name field with xml layout
     * @return
     */
    @Bindable
    public String getName()
    {
        return this.student.getName();
    }

    public void setName(String name)
    {
        student.setName(name);
        notifyPropertyChanged(BR.name);
    }


    /**
     * Bind email field with xml layout
     * @return
     */
    @Bindable
    public String getEmail()
    {
        return this.student.getEmail();
    }

    public void setEmail(String email)
    {
        student.setEmail(email);
        notifyPropertyChanged(BR.email);
    }


    /**
     * Bind phone field with xml layout
     * @return
     */
    @Bindable
    public String getPhone()
    {
        return this.student.getPhone();
    }

    public void setPhone(String phone)
    {
        student.setPhone(phone);
        notifyPropertyChanged(BR.phone);
    }
}