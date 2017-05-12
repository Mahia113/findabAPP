package com.android.findab;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.android.findab.adaptador.categoriaAdaptador;
import com.android.findab.modelo.Categoria;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    private RecyclerView recyclerCategorias;
    private List<Categoria> listaCategorias;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        ActionBar bar = getSupportActionBar();

        bar.setDisplayShowTitleEnabled(true);

        //bar.setTitle("Mi Aplicaci");

        CollapsingToolbarLayout ctlLayout = (CollapsingToolbarLayout)findViewById(R.id.mycoll);
        ctlLayout.setTitle("Mi Aplicaciónnn");


        recyclerCategorias = (RecyclerView) findViewById(R.id.recyclerview_categorias);

        //LinearLayoutManager lm = new LinearLayoutManager(this);
        //lm.setOrientation(LinearLayoutManager.VERTICAL);

        GridLayoutManager glm = new GridLayoutManager(this,2);
        recyclerCategorias.setLayoutManager(glm);

        inicializarDatos();
        inicializaAdaptador();
    }

    public void inicializarDatos()
    {
        listaCategorias = new ArrayList<>();

        listaCategorias.add(new Categoria(R.drawable.icon_restaurant, "Restaurantes"));
        listaCategorias.add(new Categoria(R.drawable.icon_bar,"Bares"));
        listaCategorias.add(new Categoria(R.drawable.icon_cafeteria,"Cafeterias"));
        listaCategorias.add(new Categoria(R.drawable.icon_hospital,"Farmacias"));
        listaCategorias.add(new Categoria(R.drawable.icon_turisticos,"Turisticos"));
        listaCategorias.add(new Categoria(R.drawable.icon_favorito,"Favoritos"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_categorias, menu);
        return true;
    }

    public categoriaAdaptador adaptador;
    private void inicializaAdaptador()
    {
        adaptador = new categoriaAdaptador(listaCategorias);
        recyclerCategorias.setAdapter(adaptador);
    }
}
