package com.example.bettafish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class custompopup_amin extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout ig_viewamin, githubviewamin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custompopup_amin);

        ig_viewamin = findViewById(R.id.ig_view_amin);
        ig_viewamin.setOnClickListener(this);

        githubviewamin = findViewById(R.id.github_view_amin);
        githubviewamin.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ig_view_amin:
                Uri uri = Uri.parse("http://instagram.com/_u/XXXX");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/amiensidiq")));
                }
                break;
            case R.id.github_view_amin:
                String gitAmin = "https://github.com/muhamien12";
                Intent gitintent = new Intent(Intent.ACTION_VIEW, Uri.parse(gitAmin));
                startActivity(gitintent);
                break;
        }
    }
}
