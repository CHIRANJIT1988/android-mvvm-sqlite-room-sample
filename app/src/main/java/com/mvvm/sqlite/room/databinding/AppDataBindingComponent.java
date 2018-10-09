package com.mvvm.sqlite.room.databinding;

/**
 * Created by CHIRANJIT on 20/09/2018
 */
public class AppDataBindingComponent implements android.databinding.DataBindingComponent {

    @Override
    public RecyclerViewDataBinding getRecyclerViewDataBinding() {

        return new RecyclerViewDataBinding();
    }
}
