package com.faan.mascotasrecyclerviewyactionview;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.faan.mascotasrecyclerviewyactionview.R;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;


public class PerfilFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaPerfil;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_perfil,container, false);

        CircularImageView circularImageView = (CircularImageView) v.findViewById(R.id.imagenPerfil);
// Set Border
        circularImageView.setBorderColor(getResources().getColor(R.color.colorPrimary));
        circularImageView.setBorderWidth(10);
// Add Shadow with default param
        circularImageView.addShadow();
// or with custom param
        circularImageView.setShadowRadius(15);
        circularImageView.setShadowColor(Color.RED);

        listaPerfil = (RecyclerView) v.findViewById(R.id.rvMascotas);
        GridLayoutManager glm = new GridLayoutManager(getActivity(),2);
        glm.setOrientation(GridLayoutManager.VERTICAL);
        listaPerfil.setLayoutManager(glm);
        inicializarListaMascotas();
        inicializarAdaptador();
        return v;
    }



    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,getActivity());
        listaPerfil.setAdapter(adaptador);
    }

    public void inicializarListaMascotas() {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Micho I", 10, R.drawable.micho));
        mascotas.add(new Mascota("Micho II",9, R.drawable.micho2));
        mascotas.add(new Mascota("Micho III",8, R.drawable.micho3));
        mascotas.add(new Mascota("Micho IV",7, R.drawable.micho));
        mascotas.add(new Mascota("Micho V",6, R.drawable.micho));

    }
}
