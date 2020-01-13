package com.example.myintenapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import javax.xml.transform.URIResolver;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnMove, btnMoveData, btnCall, btnITTP, btn_Ex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMove = findViewById(R.id.btnMove);
        btnMove.setOnClickListener(this);

        btnMoveData = findViewById(R.id.btnMoveData);
        btnMoveData.setOnClickListener(this);

        btnCall = findViewById(R.id.btnCall);
        btnCall.setOnClickListener(this);

        btnITTP = findViewById(R.id.btnITTP);
        btnITTP.setOnClickListener(this);

        btn_Ex = findViewById(R.id.btn_Ex);
        btn_Ex.setOnClickListener(this);


    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnMove:
                Intent moveActivity = new Intent(this, MoveActivity.class);
                startActivity(moveActivity);
                break;

            case R.id.btnMoveData:
                Intent moveDataActivity = new Intent(this, MoveDataActivity.class);
                moveDataActivity.putExtra(MoveDataActivity.EXTRA_NAME, "Kukuh Primadito R Kuda Poni");
                moveDataActivity.putExtra(MoveDataActivity.EXTRA_AGE, 20);
                moveDataActivity.putExtra(MoveDataActivity.EXTRA_ADD, "Jln. Pramuka No.164 Purwokerto Kulon");
                startActivity(moveDataActivity);
                break;

            case R.id.btnCall:
                String phoneNumber = "089618815501";
                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+phoneNumber));
                startActivity(callIntent);
                break;

            case R.id.btnITTP:
                String web = "http://www.ittelkom-pwt.ac.id";
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(web));
                startActivity(webIntent);
                break;

            case R.id.btn_Ex:
                Intent eks = new Intent(this, lineEdit.class);
                startActivity(eks);
                break;



        }
    }
}
