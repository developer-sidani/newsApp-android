package com.example.ahmadsidani20190148aliyassine20190234hadiibrahim20170297;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class Forgotpassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);

        Intent i = getIntent();
        String email =i.getStringExtra("email");

        EditText fp_email=(EditText)findViewById(R.id.fp_email);
        fp_email.setText(email);


        TextView w1 = (TextView) findViewById(R.id.fp_warning1);
        Button reset=(Button)findViewById(R.id.reset_btn);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               resetPassword(v,w1,fp_email);
            }
        });

    }
    public boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    public void resetPassword(View v, TextView w1, EditText fp_email){
        if(fp_email.getText().toString().equals("")){
            w1.setText("Empty Field!!!");
        }else if(!isEmailValid(fp_email.getText().toString())){
            w1.setText("Invalid email address");
        }else{
            w1.setText("");
            InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(),0);
            Snackbar.make(v, "Please Check your Email!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            Intent intent =new Intent(this,Login.class);
            HandlerThread handlerThread = new HandlerThread("hideTextHandlerThread");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            Handler mainHandler = new Handler(Forgotpassword.this.getMainLooper());
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(intent);
                            finish();

                        }
                    });
                    handler.getLooper().quit();
                }
            };
            handler.post(runnable);

        }
    }
}