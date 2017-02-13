package com.faan.mascotasrecyclerviewyactionview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import  android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by FAAN on 12/02/2017.
 */

public class RecyclerViewFragment extends Fragment
{
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragmentrecyclerview,container, false);

       // Toolbar miActionBar = (Toolbar) v.findViewById(R.id.miActionBar);
        //setSupportActionBar(miActionBar);

        // toca mover
      listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
        return v;
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,getActivity());
        listaMascotas.setAdapter(adaptador);
    }
    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Cerdito",2, R.drawable.cerdito));
        mascotas.add(new Mascota("Ayudante de Santa",5, R.drawable.mascota1));
        mascotas.add(new Mascota("Micho",7, R.drawable.micho));
        mascotas.add(new Mascota("Pluto",4, R.drawable.pluto));
        mascotas.add(new Mascota("Tux",5, R.drawable.tux));

    }

    public void iraCincoMascotas (View v){
        Intent i = new Intent(getActivity(),cincoMascotas.class);
        startActivity(i);
    }
}
