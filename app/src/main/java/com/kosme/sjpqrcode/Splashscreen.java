package com.kosme.sjpqrcode;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.kosme.sjpqrcode.model.Login;
import com.kosme.sjpqrcode.model.User;

public class Splashscreen extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("Login", null);
        Login login = gson.fromJson(json, Login.class);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (login == null){
                    Intent intent = new Intent(Splashscreen.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(Splashscreen.this, MenuActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 2000);

    }

}
