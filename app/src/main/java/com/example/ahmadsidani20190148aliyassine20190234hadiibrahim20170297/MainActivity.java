package com.example.ahmadsidani20190148aliyassine20190234hadiibrahim20170297;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.events.Subscriber;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.nio.channels.Channel;
import java.util.ArrayList;
import java.util.List;


//finish(); is a function to close the activity before moving on to another activity (if needed)
public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private static final String TAG = "MainActivity";
    ListView newsListView;
    List<news> newsList;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mAuth = FirebaseAuth.getInstance();
        Log.d(TAG, "Subscribing to weather topic");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        newsListView=(ListView)findViewById(R.id.newsListView);
        newsList=new ArrayList<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        ref = database.getReference("news");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                newsList.clear();
                for (DataSnapshot newsSnapshot : dataSnapshot.getChildren()) {
                    news n = newsSnapshot.getValue(news.class);
                    if(n.isactive==true) {
                        newsList.add(0, n);

                        ListAdapter adapter = new ListAdapter(MainActivity.this, newsList);
                        newsListView.setAdapter(adapter);
                    }

                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        // Inflate the menu; this adds items to the action bar if it is present.
        if(currentUser != null){
            getMenuInflater().inflate(R.menu.menu_admin, menu);
            return true;
        }else{
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this,Settings.class);
            startActivity(intent);
        }else if(id == R.id.action_login){
            Intent intent = new Intent(this,Login.class);
            startActivity(intent);
        }
        else if(id==R.id.action_logout){
            FirebaseAuth.getInstance().signOut();
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }else if(id==R.id.action_addnews){
            Intent intent =new Intent(this,Admin.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

}