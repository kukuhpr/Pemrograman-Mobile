package com.example.pengingattugas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView titlepage, subtitlepage, endpage;

    DatabaseReference reference;
    RecyclerView ourdoes;
    ArrayList<PengingatKu> list;
    DoesAdapter doesAdapter;
    FloatingActionButton add_does;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titlepage = findViewById(R.id.title_page);
        subtitlepage = findViewById(R.id.subtitle_text);
        endpage = findViewById(R.id.end_page);

        add_does = findViewById(R.id.add_does);

        add_does.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(MainActivity.this, new_task_act.class);
                startActivity(a);
            }
        });

        Typeface MBold = Typeface.createFromAsset(getAssets(),"font/montserratextrabold.ttf");
        Typeface MReg = Typeface.createFromAsset(getAssets(), "font/montserratregular.ttf");

        //custome font
        titlepage.setTypeface(MBold);
        subtitlepage.setTypeface(MReg);
        endpage.setTypeface(MReg);

        //data
        ourdoes = findViewById(R.id.ourdoes);
        ourdoes.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<PengingatKu>();

        reference = FirebaseDatabase.getInstance().getReference().child("PengingatTugas");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    PengingatKu p = dataSnapshot1.getValue(PengingatKu.class);
                    list.add(p);
                }
                doesAdapter = new DoesAdapter(MainActivity.this, list);
                ourdoes.setAdapter(doesAdapter);
                doesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "No Data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
