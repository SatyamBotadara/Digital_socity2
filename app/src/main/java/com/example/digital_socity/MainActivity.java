package com.example.digital_socity;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.digital_socity.chairMain.MainActivityChairMan;
import com.example.digital_socity.login.LoginActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Objects.requireNonNull(getSupportActionBar()).hide();

        SharedPreferences sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);

        new Thread(() -> {
            try {
                Thread.sleep(2300);
            } catch (InterruptedException e) {

                Toast.makeText(this,"this is toast",Toast.LENGTH_SHORT).show();
            }

            if(sharedPreferences.contains("isLogin")){
                Intent i=new Intent(MainActivity.this, MainActivityChairMan.class);
                startActivity(i);
            }
            else{
                Intent i=new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);

            }

            finish();

        }).start();

    }
}