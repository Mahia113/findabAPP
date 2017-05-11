package com.android.findab;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.android.findab.adaptador.categoriaAdaptador;
import com.android.findab.modelo.categoria;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    private RecyclerView recyclerCategorias;
    private List<categoria> listaEditoriales;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        ActionBar bar = getSupportActionBar();

        //bar.setDisplayShowTitleEnabled(false);

        //bar.setTitle("Mi Aplicaci");

        CollapsingToolbarLayout ctlLayout = (CollapsingToolbarLayout)findViewById(R.id.mycoll);
        ctlLayout.setTitle("Mi Aplicaciónnn");


        recyclerCategorias = (RecyclerView) findViewById(R.id.recyclerview_editoriales);

        //LinearLayoutManager lm = new LinearLayoutManager(this);
        //lm.setOrientation(LinearLayoutManager.VERTICAL);

        GridLayoutManager glm = new GridLayoutManager(this,2);


        recyclerCategorias.setLayoutManager(glm);
    }

    public void inicializarDatos()
    {
        listaEditoriales = new ArrayList<>();

        listaEditoriales.add(new categoria(R.drawable.ciudad));
        listaEditoriales.add(new categoria(R.drawable.medio_dia));
        listaEditoriales.add(new categoria(R.drawable.tarde));
        listaEditoriales.add(new categoria(R.drawable.tarde_lago));
        listaEditoriales.add(new categoria(R.drawable.ciudad));
        listaEditoriales.add(new categoria(R.drawable.medio_dia));
    }

    public categoriaAdaptador adaptador;
    private void inicializaAdaptador()
    {
        adaptador = new categoriaAdaptador(listaEditoriales);
        recyclerCategorias.setAdapter(adaptador);
    }
}
