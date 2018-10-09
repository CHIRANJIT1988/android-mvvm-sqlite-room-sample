package com.mvvm.sqlite.room.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.mvvm.sqlite.room.R;
import com.mvvm.sqlite.room.databinding.ActivityStudentListBinding;
import com.mvvm.sqlite.room.model.Student;
import com.mvvm.sqlite.room.view.adapter.StudentRecyclerAdapter;
import com.mvvm.sqlite.room.viewmodel.StudentViewModel;

import java.util.ArrayList;


public class StudentListActivity extends AppCompatActivity
{
    private StudentViewModel studentViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        ActivityStudentListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_student_list);

        this.studentViewModel = new StudentViewModel(this, new ArrayList<Student>(), new StudentRecyclerAdapter());

        binding.setStudentViewModel(studentViewModel);

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onResume()
    {
        super.onResume();
        this.studentViewModel.reloadData();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId() == android.R.id.home)
        {
            finish();
            return  true;
        }

        return super.onOptionsItemSelected(item);
    }
}