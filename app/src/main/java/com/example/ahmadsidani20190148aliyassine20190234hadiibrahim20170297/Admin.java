package com.example.ahmadsidani20190148aliyassine20190234hadiibrahim20170297;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;


public class Admin extends AppCompatActivity {

    Button add;
    TextView title;
    TextView description;
    TextView keywords;
    Spinner s;
    long maxid = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("news");

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
            String currentDateTime= Calendar.getInstance().getTime().toString();


            System.out.println(currentDateTime);
            boolean check = true;

                if (s_title.equals("")) {
                    check = false;
                    title.setError("Enter title");
                }

                if (s_description.equals("")) {
                    check = false;
                    description.setError("Enter description");
                }

                if (s_keywords.equals("")) {
                    check = false;
                    keywords.setError("Enter keywords");
                }

            if (check == true){


        save(s_title, s_spinner, s_description,s_keywords,currentDateTime);



            }

        }
    });
}


    public void save(String s_title, String s_spinner, String s_description, String s_keywords, String currentDateTime)
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("news");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists() ){

                    maxid = (snapshot.getChildrenCount());

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        news c = new news(maxid+1, s_spinner, s_title, s_description,s_keywords,currentDateTime);
        ref.child(String.valueOf(maxid+1)).setValue(c);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }

}