package com.mvvm.sqlite.room.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.mvvm.sqlite.room.R;
import com.mvvm.sqlite.room.databinding.ActivityStudentBinding;
import com.mvvm.sqlite.room.model.Student;
import com.mvvm.sqlite.room.viewmodel.StudentViewModel;


public class StudentActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        ActivityStudentBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_student);
        binding.setStudentViewModel(new StudentViewModel(this, new Student()));

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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