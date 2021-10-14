package com.example.vgameapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*SystemClock.sleep(200);
        setTheme(R.style.Theme_VGameAPI);*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Codes for linking java variables to xml elements
        Button btnLogin = findViewById(R.id.btnLogin);
        EditText txtUsername = findViewById(R.id.txtUsername);
        EditText txtPassword = findViewById(R.id.txtPassword);
        TextView lblLoginResult = findViewById(R.id.lblLoginResult);

        Intent intent = new Intent(this, MainMenu.class);

        //If login button is clicked, lblLoginResult text will show if login succeeded or not
        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Login will fail if the password equals to "1234"
                if (txtUsername.getText().toString().equals("1234") && txtPassword.getText().toString().equals("1234")) {
                    lblLoginResult.setText("Login OK");
                    Log.i("Test","Login OK");
                    startActivity(intent);
                } else {
                    lblLoginResult.setText("Login KO");
                    Log.i("Test","Login KO");
                }
            }
        });



    }
}