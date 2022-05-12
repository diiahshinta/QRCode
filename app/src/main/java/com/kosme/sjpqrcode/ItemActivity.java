package com.kosme.sjpqrcode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ItemActivity extends AppCompatActivity {

    View product, reject, check;
    ImageView imgProduct, imgReject, imgCheck;
    TextView txtProduct, txtReject, txtCheck;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        product = findViewById(R.id.menu_product);
        reject = findViewById(R.id.menu_reject);
        check = findViewById(R.id.menu_check);


        imgProduct = product.findViewById(R.id.img_menu);
        txtProduct = product.findViewById(R.id.txt_title);
        imgReject = reject.findViewById(R.id.img_menu);
        txtReject = reject.findViewById(R.id.txt_title);
        imgCheck = check.findViewById(R.id.img_menu);
        txtCheck = check.findViewById(R.id.txt_title);

        imgCheck.setImageResource(R.drawable.ic_check);
        txtCheck.setText("QC\nCheck");
        imgReject.setImageResource(R.drawable.ic_reject);
        txtReject.setText("Reject\nProduct");
        imgProduct.setImageResource(R.drawable.ic_qr);
        txtProduct.setText("Details\nProduct");

        //for development purpose only
        reject.setVisibility(View.GONE);
        check.setVisibility(View.GONE);



//        reject.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(ItemActivity.this, MainActivity.class);
//                i.putExtra("code", "reject");
//                startActivity(i);
//            }
//        });

        product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ItemActivity.this, MenuActivity.class);
                startActivity(i);
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ItemActivity.this, MainActivity.class);
                i.putExtra("code", "qc");
                startActivity(i);
            }
        });

    }
}
