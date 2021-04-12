package com.example.ahmadsidani20190148aliyassine20190234hadiibrahim20170297;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        LinearLayout mylin=(LinearLayout)findViewById(R.id.spinnerlinear);
        Switch myswitch=(Switch)findViewById(R.id.myswitch);

        myswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(myswitch.isChecked()){
                    mylin.setVisibility(View.VISIBLE);
                }else{
                    mylin.setVisibility(View.INVISIBLE);
                }
            }
        });

    }
}