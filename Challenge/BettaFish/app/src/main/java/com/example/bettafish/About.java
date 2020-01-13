package com.example.bettafish;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class About extends AppCompatActivity{
    private Dialog myDialog;
    private LinearLayout igView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        myDialog = new Dialog(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("About Me");
    }

    public void ShowPopupKukuh(View view){
        TextView txtClose;
        myDialog.setContentView(R.layout.activity_custompopup_kukuh);
        txtClose =(TextView) myDialog.findViewById(R.id.txtclose);
        txtClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

    public void ShowPopupAmin(View view){
        TextView txtClose;
        myDialog.setContentView(R.layout.activity_custompopup_amin);
        txtClose =(TextView) myDialog.findViewById(R.id.txtclose);
        txtClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

    public void ShowPopupAnggar(View view){
        TextView txtClose;
        myDialog.setContentView(R.layout.activity_custompopup_anggar);
        txtClose =(TextView) myDialog.findViewById(R.id.txtclose);
        txtClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


}
