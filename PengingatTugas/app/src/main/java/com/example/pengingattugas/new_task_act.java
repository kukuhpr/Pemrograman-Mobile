package com.example.pengingattugas;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class new_task_act extends AppCompatActivity {

    TextView titlepage, addtitle, desc_does;
    EditText title_does, dsc_does;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task_act);

        titlepage = findViewById(R.id.title_page);
        addtitle = findViewById(R.id.addtitle);
        title_does = findViewById(R.id.title_does);
        desc_does = findViewById(R.id.descdoes);
        dsc_does = findViewById(R.id.dsc_does);

        //font
        Typeface MBold = Typeface.createFromAsset(getAssets(),"font/montserratextrabold.ttf");
        Typeface MReg = Typeface.createFromAsset(getAssets(), "font/montserratregular.ttf");

        titlepage.setTypeface(MBold);
        addtitle.setTypeface(MBold);
        desc_does.setTypeface(MBold);
        dsc_does.setTypeface(MReg);
        title_does.setTypeface(MReg);
    }
}
