package com.example.vgameapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

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

        //If login button is clicked, lblLoginResult text will show if login succeeded or not
        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Login will fail if the password equals to "1234"
                if (txtPassword.getText().toString().equals("1234")) {
                    lblLoginResult.setText("Login not ok");
                    Log.i("Test","Login not ok");
                } else {
                    lblLoginResult.setText("Login ok");
                    Log.i("Test","Login ok");
                }
            }
        });

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FormFragment()).commit();

        BottomNavigationView bottomNav = findViewById(R.id.main_menu);

        bottomNav.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            switch (item.getItemId()){
                case R.id.nav_home:
                    selectedFragment = new FragmentHome();
                    break;

                case R.id.nav_list:
                    selectedFragment = new ListFragment();
                    break;

                case R.id.nav_add:
                    selectedFragment = new FormFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

            return true;
        });

    }
}