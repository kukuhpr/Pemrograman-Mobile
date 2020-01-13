package com.example.bettafish;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardIkanAdapter extends RecyclerView.Adapter<CardIkanAdapter.ListViewHolder> {
    private ArrayList<Ikan> listIkan;
    private Context context;

    public CardIkanAdapter(Context context, ArrayList<Ikan> listIkan){
        this.listIkan = listIkan;
        this.context = context;
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_katalog
        , parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {

        final Ikan ikan = listIkan.get(position);
        Glide.with(holder.itemView.getContext())
                .load(ikan.getPhoto())
                .apply(new RequestOptions().fitCenter())
                .into(holder.imgPhoto);
        holder.tvName.setText(ikan.getName());
        holder.tvDesc.setText(ikan.getDescription());

        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailIkan = new Intent(context, DetailListIkan.class);
                detailIkan.putExtra("ikan_id", ikan.getId());
                context.startActivity(detailIkan);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listIkan.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvName, tvDesc;
        CardView cv;

        public ListViewHolder(@NonNull View itemView){
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_katalog_list);
            tvName = itemView.findViewById(R.id.name_katalog_list);
            tvDesc = itemView.findViewById(R.id.desc_katalog_list);
            cv = itemView.findViewById(R.id.cardview_view);
        }
    }
}
