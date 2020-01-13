package com.example.myintenapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class moveLanjut extends AppCompatActivity {

    public static final String EXTRA_DATA = "Kosong";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_lanjut);

        TextView tvData = findViewById(R.id.tv_KirimData);

        tvData.setText(getIntent().getStringExtra(EXTRA_DATA));
    }
}
