package com.mvvm.sqlite.room.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mvvm.sqlite.room.model.Student;


public class ItemStudentViewModel extends BaseObservable
{
    private Student student;
    private Context context;


    public ItemStudentViewModel(Context context, Student student)
    {
        this.student = student;
        this.context = context;
    }

    public String getName()
    {
        return this.student.getName();
    }

    public String getPhone()
    {
        return this.student.getPhone() == null ? "Not Available" : this.student.getPhone();
    }

    public String getEmail()
    {
        return this.student.getEmail();
    }

    public String getProfilePic()
    {
        return this.student.getProfile_pic();
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url)
    {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

    public void setStudent(Student student)
    {
        this.student = student;
        notifyChange();
    }
}