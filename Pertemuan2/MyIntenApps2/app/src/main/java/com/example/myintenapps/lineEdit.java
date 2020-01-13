package com.example.myintenapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class lineEdit extends AppCompatActivity implements View.OnClickListener {


    Button btnInput;
    EditText etTeks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_edit);

        etTeks = findViewById(R.id.et_Teks);


        btnInput = findViewById(R.id.btnInput);
        btnInput.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnInput:
                Intent intent = new Intent(this, moveLanjut.class);
                intent.putExtra(moveLanjut.EXTRA_DATA, etTeks.getText().toString());
                startActivity(intent);
                finish();
                break;

        }
    }
}
