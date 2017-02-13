package com.faan.mascotasrecyclerviewyactionview;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        if (toolbar!= null){
            setSupportActionBar(toolbar);
        }

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

    private  ArrayList <Fragment> agregarFragments(){
        ArrayList <Fragment> fragments = new ArrayList<>();
        fragments.add( new RecyclerViewFragment());

        fragments.add( new PerfilFragment());
        return fragments;
    }
    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("Mascotas");
        tabLayout.getTabAt(1).setText("Mi Mascota Favorita");
        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_home);
        tabLayout.getTabAt(1).setIcon(R.mipmap.ic_pet);
    }






}
