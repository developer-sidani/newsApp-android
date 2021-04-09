package com.example.ahmadsidani20190148aliyassine20190234hadiibrahim20170297;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Spinner;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Spinner sp= (Spinner)findViewById(R.id.selection_spinner);
        sp.setEnabled(false);
    }
    public void changeNotification(View v){
        Spinner sp= (Spinner)findViewById(R.id.selection_spinner);
        if(v.getId()==R.id.rd_custom){
            sp.setEnabled(true);
        }else {
            sp.setEnabled(false);
        }
    }
}