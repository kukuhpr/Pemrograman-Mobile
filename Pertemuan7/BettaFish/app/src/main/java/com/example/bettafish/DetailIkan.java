package com.example.bettafish;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;



public class DetailIkan extends AppCompatActivity {

    ImageView fotoku;
    TextView nama, detail, detail2, jenis, harga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_ikan);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Cupang diterima = getIntent().getParcelableExtra("kunci");

        fotoku = (ImageView)findViewById(R.id.img_view);
        nama = (TextView)findViewById(R.id.txt_nama);
        detail = (TextView)findViewById(R.id.txt_detail);
        detail2 = (TextView)findViewById(R.id.tv_detail_panjang);
        jenis = (TextView)findViewById(R.id.tv_jenis);
        harga = (TextView)findViewById(R.id.tv_harga);

        Glide.with(this).load(diterima.getFoto()).override(350, 550).into(fotoku);

        nama.setText(diterima.getNama());
        detail.setText(diterima.getDetail());
        detail2.setText(diterima.getDetail2());
        harga.setText(diterima.getHarga());
        jenis.setText(diterima.getJenis());


    }
}
