package com.example.bettafish;


import android.view.View;

class CustomOnItemClickListener implements View.OnClickListener {
    private int position;
    private OnItemClickCallback onItemClickCallback;


    public CustomOnItemClickListener(int position, CustomOnItemClickListener.OnItemClickCallback onItemClickCallback) {
        this.position = position;
        this.onItemClickCallback = onItemClickCallback;
    }

    @Override
    public void onClick(View v){
        onItemClickCallback.onItemClicked(v, position);
    }

    public interface OnItemClickCallback{
        void onItemClicked(View v, int position);
    }
}