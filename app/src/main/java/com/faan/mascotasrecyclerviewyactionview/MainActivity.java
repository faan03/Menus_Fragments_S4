package com.faan.mascotasrecyclerviewyactionview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList <Mascota> mascotas;
    private RecyclerView listaMascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

       listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
    } // fin oncreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.mContacto:
                Intent i = new Intent(this,activityContacto.class);
                startActivity(i);
                break;

            case R.id.mAcercaDe:
                Intent i1 = new Intent(this, AcercaDeActivity.class);
                startActivity(i1);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void inicializarAdaptador(){
       MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);
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
        Intent i = new Intent(this,cincoMascotas.class);
        startActivity(i);
    }

}
