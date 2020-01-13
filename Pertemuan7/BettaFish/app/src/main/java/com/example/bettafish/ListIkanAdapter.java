package com.example.bettafish;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListIkanAdapter extends RecyclerView.Adapter<ListIkanAdapter.CardViewHolder> {

    private Context context;
    private ArrayList<Cupang> listCupang;
    private OnClick onClick;

    public ListIkanAdapter(Context context, OnClick onClick){
        this.context = context;
        this.onClick = onClick;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_ikan, viewGroup, false);
        CardViewHolder viewHolder = new CardViewHolder(view);
        return viewHolder;


    }


    @Override
    public void onBindViewHolder(@NonNull CardViewHolder cardViewHolder, int i) {
        Cupang c = getListCupang().get(i);
        cardViewHolder.tampil(c, onClick);

        cardViewHolder.btnShare.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback(){
            @Override
            public void onItemClicked(View v, int position){
                Toast.makeText(context, "Share info tentang " + getListCupang().get(position).getNama(),
                        Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getListCupang().size();
    }

    public ArrayList<Cupang> getListCupang() {
        return listCupang;
    }

    public void setListIkan(ArrayList<Cupang> listCupang) {
        this.listCupang = listCupang;
    }


    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFoto;
        TextView tvNama, tvDetail;
        Button btnShare, btnDetail;
        Cupang cupang;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = (ImageView)itemView.findViewById(R.id.img_view);
            tvNama = (TextView)itemView.findViewById(R.id.txt_nama);
            tvDetail = (TextView)itemView.findViewById(R.id.txt_detail);
            btnShare = (Button)itemView.findViewById(R.id.btn_share);
            btnDetail = (Button)itemView.findViewById(R.id.btn_detail);
        }
        public void tampil(final Cupang cupang, final OnClick OnItemClick){

            Glide.with(context)
                    .load(cupang.getFoto())
                    .override(350,550)
                    .into(imgFoto);

            tvNama.setText(cupang.getNama());
            tvDetail.setText(cupang.getDetail());

            btnDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    OnItemClick.onClick(cupang);
                }
            });
        }
    }
    public interface OnClick{
        void onClick(Object cupang);
    }
}
