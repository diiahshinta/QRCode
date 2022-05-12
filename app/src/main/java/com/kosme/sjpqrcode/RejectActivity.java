package com.kosme.sjpqrcode;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.kosme.sjpqrcode.api.Api;
import com.kosme.sjpqrcode.api.ApiInterface;
import com.kosme.sjpqrcode.model.Reject;
import com.kosme.sjpqrcode.model.Response;
import com.kosme.sjpqrcode.model.ResponseReject;

import retrofit2.Call;
import retrofit2.Callback;

public class RejectActivity extends AppCompatActivity {
    ApiInterface apiInterface;
    String barcode;
    TextView produk, batch, scan, ed, md, station, bar, palet, box, inner, btnReject;
    ProgressDialog loading;

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reject);

        barcode = getIntent().getStringExtra("barcode").replace("http://","");
        loading = ProgressDialog.show(RejectActivity.this, null, "loading", true, false);

        apiInterface = Api.getClient().create(ApiInterface.class);

        produk = findViewById(R.id.txt_nama_produk);
        batch = findViewById(R.id.txt_batch_number);
        scan = findViewById(R.id.txt_scan_date);
        ed = findViewById(R.id.txt_expired_date);
        md = findViewById(R.id.txt_make_date);
        station = findViewById(R.id.txt_station_name);
        bar = findViewById(R.id.barcode);
        palet = findViewById(R.id.txt_palet);
        box = findViewById(R.id.txt_box);
        inner = findViewById(R.id.txt_inner);
        btnReject = findViewById(R.id.btn_reject);
        builder = new AlertDialog.Builder(this);


        getData(barcode);

    }

    @Override
    public void onResume(){
        super.onResume();
        loading.show();
        getData(barcode);
    }

    void getData(String barcode1){
        Call<ResponseReject> response = apiInterface.getReject(barcode1);
        response.enqueue(new Callback<ResponseReject>() {
            @Override
            public void onResponse(Call<ResponseReject> call, retrofit2.Response<ResponseReject> response) {
                ResponseReject data = response.body();
                loading.dismiss();
                if (data == null){
                    Toast.makeText(RejectActivity.this, "No data available!", Toast.LENGTH_SHORT).show();
                } else {
                    if (data.getStatus().equals("success")){
                        bar.setText(data.getReject().getBarcode());
                        produk.setText(data.getReject().getProduk());
                        batch.setText(data.getReject().getBatch());
                        scan.setText(data.getReject().getScanned());
                        ed.setText(data.getReject().getEd().replace("00:00:00", ""));
                        md.setText(data.getReject().getMd().replace("00:00:00", ""));
                        station.setText(data.getReject().getLine());
                        palet.setText(data.getReject().getPalet());
                        box.setText(data.getReject().getBox());
                        inner.setText(data.getReject().getInner());
                        btnReject.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                builder.setMessage("Yakin ingin reject product?")
                                        .setCancelable(false)
                                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                Intent intent = new Intent(RejectActivity.this, MainActivity.class);
                                                intent.putExtra("code", "replace");
                                                intent.putExtra("old", data.getReject().getBarcode());
                                                startActivity(intent);
                                            }
                                        })
                                        .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                dialogInterface.cancel();
                                            }
                                        });
                                AlertDialog alertDialog = builder.create();
                                alertDialog.setTitle("Reject Product");
                                alertDialog.show();
                            }
                        });
                    } else {
                        Toast.makeText(RejectActivity.this, data.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseReject> call, Throwable t) {
                loading.dismiss();
                Log.d("errordataAPI", t.getLocalizedMessage());
            }
        });
    }
}
