package com.mvvm.sqlite.room.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mvvm.sqlite.room.R;
import com.mvvm.sqlite.room.databinding.ItemStudentBinding;
import com.mvvm.sqlite.room.model.Student;
import com.mvvm.sqlite.room.viewmodel.ItemStudentViewModel;

import java.util.ArrayList;
import java.util.List;


public class StudentRecyclerAdapter extends RecyclerView.Adapter<StudentRecyclerAdapter.StudentViewHolder>
{
    private List<Student> studentList;


    public StudentRecyclerAdapter()
    {
        this.studentList = new ArrayList<>();
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        ItemStudentBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_student, parent, false);
        return new StudentViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position)
    {
        holder.bindStudent(studentList.get(position));
    }

    @Override
    public int getItemCount()
    {
        return studentList.size();
    }

    public void setStudentList(List<Student> studentList)
    {
        this.studentList.clear();
        this.studentList.addAll(studentList);
        notifyDataSetChanged();
    }

    static class StudentViewHolder extends RecyclerView.ViewHolder
    {
        private ItemStudentBinding binding;

        StudentViewHolder(ItemStudentBinding binding)
        {
            super(binding.getRoot());
            this.binding = binding;
        }


        void bindStudent(Student student)
        {
            if (binding.getStudentItemVM() == null)
            {
                binding.setStudentItemVM(new ItemStudentViewModel(itemView.getContext(), student));
            }

            else
            {
                binding.getStudentItemVM().setStudent(student);
            }
        }
    }
}