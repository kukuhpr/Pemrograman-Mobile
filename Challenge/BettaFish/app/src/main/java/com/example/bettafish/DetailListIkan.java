package com.example.bettafish;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.github.chrisbanes.photoview.PhotoView;

import java.util.ArrayList;

public class DetailListIkan extends AppCompatActivity {

    private int ikan_id;
    ImageView imgDetail;
    TextView tvName, tvDesc;
    private ArrayList<Ikan> listIkan = new ArrayList<>();
    private ScaleGestureDetector mScaleGestureDetector;
    private float mScaleFactor = 1.0f;
    PhotoView potoikan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_list_ikan);

        ikan_id = getIntent().getIntExtra("ikan_id", 0);
        tvName = findViewById(R.id.nama_ikan);
        tvDesc = findViewById(R.id.desc_detail);
        imgDetail = findViewById(R.id.img_detail);
        potoikan = findViewById(R.id.imageView);

        mScaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener());

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        listIkan.addAll(IkanData.getListData());
        getSupportActionBar().setTitle(listIkan.get(ikan_id).getName());
        setLayout();

        /*imgDetail.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(DetailListIkan.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_custom, null);
                PhotoView photoView = mView.findViewById(R.id.imageView);

                mBuilder.setView(mView);
                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });*/
    }



    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener{

        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {

            mScaleFactor *= scaleGestureDetector.getScaleFactor();
            mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 10.0f));

            imgDetail.setScaleX(mScaleFactor);
            imgDetail.setScaleY(mScaleFactor);

            return true;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        mScaleGestureDetector.onTouchEvent(event);

        return true;
    }

    private void setLayout() {
        tvName.setText(listIkan.get(ikan_id).getName());
        tvDesc.setText(listIkan.get(ikan_id).getDescription());
        Glide.with(this)
                .load(listIkan.get(ikan_id).getPhoto())
                .apply(new RequestOptions().fitCenter())
                .into(imgDetail);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
         if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
