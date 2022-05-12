package com.kosme.sjpqrcode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.zxing.Result;
import com.kosme.sjpqrcode.api.Api;
import com.kosme.sjpqrcode.api.ApiInterface;
import com.kosme.sjpqrcode.model.ProductData;
import com.kosme.sjpqrcode.model.Replace;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    ZXingScannerView  mScannerView;
    FrameLayout camera;
    ApiInterface apiInterface;
    String id, code, bar, pd, ed;
    private Dialog customDialog;
    EditText oldBarcode, newCode, batch, prodDate, expiredDate;
    final Calendar calendar = Calendar.getInstance();
    private DatePickerDialog datePicker;
    TextView btnReplace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = getIntent().getStringExtra("level");
        code = getIntent().getStringExtra("code");
        bar = getIntent().getStringExtra("old");


        apiInterface = Api.getClient().create(ApiInterface.class);

        camera = findViewById(R.id.frame_layout_camera);

        initScannerView();

    }


    @Override
    public void onResume(){
        super.onResume();
        initView();
    }

    private void initScannerView() {
        mScannerView = new ZXingScannerView(MainActivity.this);
        mScannerView.setAutoFocus(true);
        mScannerView.setResultHandler(this);
        camera.addView(mScannerView);
        mScannerView.startCamera();
    }

    @Override
    public void onStart() {
        mScannerView.startCamera();
        doRequestPermission();
        super.onStart();
    }

    private void doRequestPermission(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.CAMERA}, 100);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                initScannerView();
            } else {

            }
        }
    }

    @Override
    public void onPause(){
        mScannerView.stopCamera();
        super.onPause();
    }

    @Override
    public void handleResult(Result rawResult) {

        if (code != null && code.equals("reject")) {
            Intent i = new Intent(MainActivity.this, RejectActivity.class);
            i.putExtra("barcode", rawResult.getText());
            startActivity(i);
        } else if (code != null && code.equals("qc")){
            Intent i = new Intent(MainActivity.this, CheckerActivity.class);
            i.putExtra("barcode", rawResult.getText());
            startActivity(i);
        } else {
            if (id.equals("4")){
                Intent i = new Intent(MainActivity.this, PaletActivity.class);
                i.putExtra("barcode", rawResult.getText());
                startActivity(i);
            } else if (id.equals("3")){
                Intent i = new Intent(MainActivity.this, MasterBoxActivity.class);
                i.putExtra("barcode", rawResult.getText());
                startActivity(i);
            } else if (id.equals("2")){
                Intent i = new Intent(MainActivity.this, InnerboxActivity.class);
                i.putExtra("barcode", rawResult.getText());
                startActivity(i);
            } else if (id.equals("1")){
                Intent i = new Intent(MainActivity.this, ProductActivity.class);
                i.putExtra("barcode", rawResult.getText());
                startActivity(i);
            }
        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


    private void initView(){
        mScannerView.resumeCameraPreview(this::handleResult);
    }


//    private void initCustomDialog(String newBarcode){
//        customDialog = new Dialog(MainActivity.this);
//        customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        customDialog.setContentView(R.layout.dialog_replace);
//        customDialog.setCancelable(true);
//
//        oldBarcode = customDialog.findViewById(R.id.edt_old);
//        newCode = customDialog.findViewById(R.id.edt_new);
//        batch = customDialog.findViewById(R.id.edt_batch);
//        prodDate = customDialog.findViewById(R.id.edt_production);
//        expiredDate = customDialog.findViewById(R.id.edt_ed);
//        btnReplace = customDialog.findViewById(R.id.btn_replace);
//        customDialog.show();
//
//        oldBarcode.setText(bar);
//        newCode.setText(newBarcode);
//        oldBarcode.setClickable(false);
//        oldBarcode.setFocusable(false);
//        newCode.setClickable(false);
//        newCode.setFocusable(false);
//        prodDate.setFocusable(false);
//        expiredDate.setFocusable(false);
//
//        prodDate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final Calendar c = Calendar.getInstance();
//                int mYear = c.get(Calendar.YEAR); // current year
//                int mMonth = c.get(Calendar.MONTH); // current month
//                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
//                // date picker dialog
//                datePicker = new DatePickerDialog(MainActivity.this,
//                        new DatePickerDialog.OnDateSetListener() {
//
//                            @Override
//                            public void onDateSet(DatePicker view, int year,
//                                                  int monthOfYear, int dayOfMonth) {
//                                // set day of month , month and year value in the edit text
//                                prodDate.setText(year + "-"
//                                        + (monthOfYear + 1) + "-" + dayOfMonth);
//                                pd = year + "-"
//                                        + (monthOfYear + 1) + "-" + dayOfMonth;
//
//                            }
//                        }, mYear, mMonth, mDay);
//                datePicker.show();
//
//            }
//        });
//
//        expiredDate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final Calendar c = Calendar.getInstance();
//                int mYear = c.get(Calendar.YEAR); // current year
//                int mMonth = c.get(Calendar.MONTH); // current month
//                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
//                // date picker dialog
//                datePicker = new DatePickerDialog(MainActivity.this,
//                        new DatePickerDialog.OnDateSetListener() {
//
//                            @Override
//                            public void onDateSet(DatePicker view, int year,
//                                                  int monthOfYear, int dayOfMonth) {
//                                // set day of month , month and year value in the edit text
//                                expiredDate.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
//                                ed = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
//
//                            }
//                        }, mYear, mMonth, mDay);
//                datePicker.show();
//
//            }
//        });
//
//        btnReplace.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                replaceProduct(bar, newBarcode, batch.getText().toString(), pd, ed);
//            }
//        });
//    }

    public void replaceProduct(String oldB, String newB, String newBatch, String pd, String ed){
        apiInterface.replace(oldB, newB, newBatch, pd, ed).enqueue(new Callback<Replace>() {
            @Override
            public void onResponse(Call<Replace> call, Response<Replace> response) {
                if (response.body().getStatus().equals("success")){
                    Toast.makeText(MainActivity.this, "Reject Produk Sukses", Toast.LENGTH_SHORT).show();
                    customDialog.dismiss();
                    Intent intent = new Intent(MainActivity.this, ItemActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Replace> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }



}