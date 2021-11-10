package com.example.vgameapi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private void setAppLocale(String localeCode){
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration config = res.getConfiguration();

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN_MR1){
            config.setLocale(new Locale(localeCode.toLowerCase()));
        } else {
            config.locale = new Locale(localeCode.toLowerCase());
        }
        res.updateConfiguration(config, dm);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SystemClock.sleep(200);
        setTheme(R.style.Theme_VGameAPI);

        setAppLocale("");

        SharedPreferences prefs = getSharedPreferences("SharedP", Context.MODE_PRIVATE);
        Intent intent = new Intent(this, MainMenu.class);

        if (prefs.getString("lang","").equals("en")) {
            setAppLocale("en");
        } else if (prefs.getString("lang","").equals("esp")) {
            setAppLocale("");
        }

        if (prefs.getBoolean("login", false)) {
            startActivity(intent);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Codes for linking java variables to xml elements
        Button btnLogin = findViewById(R.id.btnLogin);
        EditText txtUsername = findViewById(R.id.txtUsername);
        EditText txtPassword = findViewById(R.id.txtPassword);
        CheckBox checkRememberMe = findViewById(R.id.checkRememberMe);

        //If login button is clicked, lblLoginResult text will show if login succeeded or not
        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Login will succeed if the username and password equal to "admin"
                if (txtUsername.getText().toString().equals("admin") && txtPassword.getText().toString().equals("admin")) {
                    if (checkRememberMe.isChecked()) {
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putString("username", txtUsername.getText().toString());
                        editor.putString("password", txtPassword.getText().toString());
                        editor.putBoolean("login", true);
                        editor.commit();
                    }
                    Toast.makeText(getApplicationContext(), "Login OK", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Login KO", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}