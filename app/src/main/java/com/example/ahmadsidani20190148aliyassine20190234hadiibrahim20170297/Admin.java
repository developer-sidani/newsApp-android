package com.example.ahmadsidani20190148aliyassine20190234hadiibrahim20170297;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Admin extends AppCompatActivity {

    Button add;
    TextView title;
    TextView description;
    TextView keywords;
    Spinner s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String[] spinnerContents = {"Breaking", "Local", "Global", "Finance", "Sports", "Technology"};
        Spinner s = (Spinner) findViewById(R.id.category);

        ArrayAdapter<String> myadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spinnerContents);
        s.setAdapter(myadapter);

        TextView title = (TextView) findViewById(R.id.title);
        TextView description = (TextView) findViewById(R.id.description);
        TextView keywords = (TextView) findViewById(R.id.keywords);


    Button add = (Button) findViewById(R.id.addbutton);
        add.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String s_title = title.getText().toString();
            String s_description = description.getText().toString();
            String s_keywords = keywords.getText().toString();
            String s_spinner = s.getSelectedItem().toString();

            if(s_title.equals("")){
                title.setError("Enter title");
            }

            if(s_description.equals("")){
                description.setError("Enter description");
            }

            if(s_keywords.equals("")){
                keywords.setError("Enter keywords");
            }

//            if(s_keywords.equals("")){
//                keywords.setError("Enter keywords");
//            }


//                System.out.println(s_title);
//                System.out.println(s_description);
//                System.out.println(s_keywords);
//                System.out.println(s_spinner);



        }
    });
}
}