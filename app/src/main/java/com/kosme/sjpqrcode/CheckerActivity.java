package com.kosme.sjpqrcode;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.kosme.sjpqrcode.api.Api;
import com.kosme.sjpqrcode.api.ApiInterface;
import com.kosme.sjpqrcode.model.Replace;
import com.kosme.sjpqrcode.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CheckerActivity extends AppCompatActivity {

    EditText barcode, name, dept;
    TextView check;
    ProgressDialog loading;
    ApiInterface apiInterface;
    String code;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checker);

        code = getIntent().getStringExtra("barcode");

        SharedPreferences  mPrefs = getPreferences(MODE_PRIVATE);
        apiInterface = Api.getClient().create(ApiInterface.class);

        barcode = findViewById(R.id.edt_barcode);
        name = findViewById(R.id.edt_name);
        dept = findViewById(R.id.edt_dept);
        check = findViewById(R.id.btn_check);

        Gson gson = new Gson();
        String json = mPrefs.getString("User", "");
        User user = gson.fromJson(json, User.class);

        barcode.setText(code);
        barcode.setFocusable(false);
        barcode.setClickable(false);

//        name.setText(user.getNama());
//        name.setFocusable(false);
//        name.setClickable(false);
//
//        dept.setText(user.getDept());
//        dept.setFocusable(false);
//        dept.setClickable(false);

        if (user == null){
            Toast.makeText(CheckerActivity.this, "Silahkan Login Terlebih Dahulu!", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(CheckerActivity.this, LoginActivity.class);
            startActivity(i);
        } else {
            check.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loading = ProgressDialog.show(CheckerActivity.this, null, "loading", true, false);
                    checkProduct(code, name.getText().toString(), dept.getText().toString());
                }
            });
        }



    }

    public void checkProduct(String barcode, String name, String dept){
        apiInterface.cekQC(barcode, name, dept).enqueue(new Callback<Replace>() {
            @Override
            public void onResponse(Call<Replace> call, Response<Replace> response) {
                loading.dismiss();
                if (response.body().getStatus().equals("success")){
                    Toast.makeText(CheckerActivity.this, "Check Produk Sukses", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(CheckerActivity.this, ItemActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(CheckerActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Replace> call, Throwable t) {
                loading.dismiss();
                Toast.makeText(CheckerActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
