package com.example.vgameapi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SystemClock.sleep(200);
        setTheme(R.style.Theme_VGameAPI);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Codes for linking java variables to xml elements
        Button btnLogin = findViewById(R.id.btnLogin);
        EditText txtUsername = findViewById(R.id.txtUsername);
        EditText txtPassword = findViewById(R.id.txtPassword);

        Intent intent = new Intent(this, MainMenu.class);

        //If login button is clicked, lblLoginResult text will show if login succeeded or not
        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Login will succeed if the username and password equal to "admin"
                if (txtUsername.getText().toString().equals("admin") && txtPassword.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(), "Login OK", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Login KO", Toast.LENGTH_LONG).show();
                }
            }
        });



    }
}