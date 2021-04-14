package com.example.ahmadsidani20190148aliyassine20190234hadiibrahim20170297;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class shownews extends Fragment {

    public shownews(){

    }
    @Nullable

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//     return super.onCreateView(inflater, container, savedInstanceState);
        v = inflater.inflate(R.layout.shownews,container, false);
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();


    }

}
