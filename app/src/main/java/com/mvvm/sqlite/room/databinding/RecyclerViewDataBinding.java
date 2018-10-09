package com.mvvm.sqlite.room.databinding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.mvvm.sqlite.room.model.Student;
import com.mvvm.sqlite.room.view.adapter.StudentRecyclerAdapter;

import java.util.List;

/**
 * Created by CHIRANJIT on 20/09/2018.
 */
public class RecyclerViewDataBinding
{
    /**
     * Binds the data to the {@link android.support.v7.widget.RecyclerView.Adapter}, sets the
     * recycler view on the adapter, and performs some other recycler view initialization.
     *
     * @param recyclerView passed in automatically with the data binding
     * @param adapter      must be explicitly passed in
     * @param studentList         must be explicitly passed in
     */
    @BindingAdapter({"app:adapter", "app:data"})
    public void bind(RecyclerView recyclerView, StudentRecyclerAdapter adapter, List<Student> studentList)
    {
        recyclerView.setAdapter(adapter);
        adapter.setStudentList(studentList);
    }
}