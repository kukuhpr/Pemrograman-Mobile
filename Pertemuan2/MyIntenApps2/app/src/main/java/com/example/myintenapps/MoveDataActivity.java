package com.example.myintenapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MoveDataActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_AGE = "extra_age";
    public static final String EXTRA_ADD = "extra_add";

    TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_data);

        tvData = findViewById(R.id.tv_data);

        String nama = getIntent().getStringExtra(EXTRA_NAME);
        int age = getIntent().getIntExtra(EXTRA_AGE, 0);
        String add = getIntent().getStringExtra(EXTRA_ADD);

        String text = "Nama : "+nama+",\n Umur : "+age+",\n Alamat : "+add;
        tvData.setText(text);
    }
}
