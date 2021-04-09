package com.example.ahmadsidani20190148aliyassine20190234hadiibrahim20170297;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;

public class Login extends AppCompatActivity {
    String[] auth={"asidani88@gmail.com","sidani"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText email = (EditText) findViewById(R.id.email);
        EditText password = (EditText) findViewById(R.id.password);
        password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        CheckBox showpassword = (CheckBox) findViewById(R.id.showpass);
        password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        showpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (showpassword.isChecked()) {
                    password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else {
                    password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                password.setSelection(password.length());
            }
        });

        // Sign in Process
        Button signin = (Button) findViewById(R.id.signin);
        TextView w1 = (TextView) findViewById(R.id.warning1);
        TextView w2 = (TextView) findViewById(R.id.warning2);
        ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar);


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().equals("")) {
                    w1.setText("Empty Field!!!");
                } else {
                    if (!isEmailValid(email.getText().toString())) {
                        w1.setText("Invalid email address");
                    } else {
                        w1.setText("");
                    }

                }
                if (password.getText().toString().equals("")) {
                    w2.setText("Empty Field!!!");
                } else {
                    w2.setText("");
                }
                //hi there i am hadi ibrahim


                if(w1.getText().toString().equals("")&&w2.getText().toString().equals("")&&!password.getText().toString().equals("")) {
                    // Good To Go now we need to authenticate

                    if (email.getText().toString().equals(auth[0]) && password.getText().toString().equals(auth[1])) {

                        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                        inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(),0);
                        signin.setVisibility(View.INVISIBLE);
                        pb.setVisibility(View.VISIBLE);

                        Intent intent =new Intent(getApplication(),Admin.class);
                        HandlerThread handlerThread = new HandlerThread("hideTextHandlerThread");
                        handlerThread.start();
                        Handler handler = new Handler(handlerThread.getLooper());
                        Handler mainHandler = new Handler(Login.this.getMainLooper());
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
                                        email.setText("");
                                        password.setText("");
                                        pb.setVisibility(View.INVISIBLE);
                                        signin.setVisibility(View.VISIBLE);
                                        finish();


                                    }
                                });
                                handler.getLooper().quit();
                            }
                        };
                        handler.post(runnable);




                    } else {
                        Snackbar.make(v, "Incorrect Email or Password!!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }
                }

//                Intent intent = new Intent(getApplication(), Admin.class);
//                startActivity(intent);

            }
        });
    }
        public void forgotPassword(View v){
            Intent intent = new Intent(this,Forgotpassword.class);
            EditText email= (EditText)findViewById(R.id.email);
            intent.putExtra("email",email.getText().toString());
            startActivity(intent);
            finish();
        }
        public boolean isEmailValid(CharSequence email) {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
}