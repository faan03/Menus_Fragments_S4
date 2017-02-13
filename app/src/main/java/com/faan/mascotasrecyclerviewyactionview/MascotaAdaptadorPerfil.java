package com.faan.mascotasrecyclerviewyactionview;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by FAAN on 05/02/2017.
 */

public class MascotaAdaptadorPerfil extends RecyclerView.Adapter<MascotaAdaptadorPerfil.MascotaViewHolder> {

    public MascotaAdaptadorPerfil(ArrayList <Mascota> mascotas, Activity activity){
        this.mascotas=mascotas;
        this.activity= activity;

    }

    ArrayList <Mascota> mascotas;
    private Activity activity;
    @Override
    //inflar el layout y lo pasa al viewholder para que obtenga los view
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotaperfil,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    // asocia cada elemento de la lista con cada view
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFotoMascota());
        mascotaViewHolder.tvRaitingCV.setText(String.valueOf(mascota.getRaitingMascota()));
    }

    @Override
    public int getItemCount() { //cantidad elementos de la lista
        return mascotas.size();
    }

    public static class MascotaViewHolder extends ViewHolder{
        private ImageView imgFoto;
        private TextView tvRaitingCV;
        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto     = (ImageView)   itemView.findViewById(R.id.imgFoto);
            tvRaitingCV = (TextView)    itemView.findViewById(R.id.tvRaitingCV);
        }
    }
}
