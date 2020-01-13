package com.example.bettafish;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvKatalog;
    private ArrayList<Ikan> list = new ArrayList<>();
    private Menu menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() !=null){
            getSupportActionBar().setTitle("Betta Fish");

        }

        rvKatalog = findViewById(R.id.rv_katalog);
        rvKatalog.setHasFixedSize(true);

        list.addAll(IkanData.getListData());
        showRecycleList();
    }

    private void showRecycleList() {
        rvKatalog.setLayoutManager(new LinearLayoutManager(this));
        CardIkanAdapter cardIkanAdapter = new CardIkanAdapter(this, list);
        rvKatalog.setAdapter(cardIkanAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        this.menu = menu;
        getMenuInflater().inflate(R.menu.menu, menu);
        invalidateOptionsMenu();
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        int id = item.getItemId();
        if (id == R.id.action_about){
            Intent about = new Intent(this, About.class);
            startActivity(about);
        }
        return super.onOptionsItemSelected(item);
    }
}
