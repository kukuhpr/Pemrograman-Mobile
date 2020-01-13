package com.example.signupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnRegis , btnLog ;
    EditText etUsr, etPas ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnRegis = findViewById(R.id.btnRegister);
        btnLog = findViewById(R.id.btnLogin);
        etUsr = findViewById(R.id.etUser);
        etPas = findViewById(R.id.etPass);


        btnRegis.setOnClickListener(this);
        btnLog.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnRegister:
                Intent inten = new Intent(this, MainActivity.class);
                startActivity(inten);
                break;

            case R.id.btnLogin:


        }
    }
}
