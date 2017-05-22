package com.android.findab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.findab.adaptador.negociosAdaptador;
import com.android.findab.modelo.Negocios;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by josel on 21/05/2017.
 */

public class ListaNegocios extends AppCompatActivity
{
    private RecyclerView recyclerNegocios;
    private List<Negocios> listaNegocios;

    public negociosAdaptador adaptador;

    private Toolbar toolbarNegocios;

    private String nombreCategoria;

    private DrawerLayout drawerLayout;

    /**
     * Titulo inicial del drawer
     */
    private String drawerTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.negocios_lista);

        toolbarNegocios = (Toolbar) findViewById(R.id.negocios_toolbar);
        setSupportActionBar(toolbarNegocios);

        ActionBar bar = getSupportActionBar();

        bar.setDisplayShowTitleEnabled(true);

        nombreCategoria = getIntent().getExtras().getString("parametro");
       // bar.setTitle(getIntent().getExtras().getString("parametro"));
        bar.setTitle(nombreCategoria);

        CollapsingToolbarLayout ctlLayout = (CollapsingToolbarLayout)findViewById(R.id.mycoll);

        recyclerNegocios = (RecyclerView) findViewById(R.id.recyclerview_negocios);

        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerNegocios.setLayoutManager(lm);

        initNavigationDrawer();

        inicializarDatos();

        inicializaAdaptador();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_negocios, menu);
        return true;
    }

    public void inicializarDatos()
    {
        listaNegocios = new ArrayList<>();

        listaNegocios.add(new Negocios(R.drawable.material_background, "Pizzeria Dgusta", "20","35", "5", R.drawable.ic_search));

        listaNegocios.add(new Negocios(R.drawable.material_background2, "Pizzeria Dgusta", "20","35", "5", R.drawable.ic_search));

        listaNegocios.add(new Negocios(R.drawable.material_background3, "Pizzeria Dgusta", "20","35", "5", R.drawable.ic_search));

        listaNegocios.add(new Negocios(R.drawable.material_background, "Pizzeria Dgusta", "20","35", "5", R.drawable.ic_search));

        listaNegocios.add(new Negocios(R.drawable.material_background2, "Pizzeria Dgusta", "20","35", "5", R.drawable.ic_search));

    }

    private void inicializaAdaptador()
    {
        adaptador = new negociosAdaptador(listaNegocios);
        recyclerNegocios.setAdapter(adaptador);
    }

    public void initNavigationDrawer()
    {

        NavigationView navigationView = (NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                int id = menuItem.getItemId();

                switch (id)
                {
                    case R.id.home:
                        Toast.makeText(getApplicationContext(),"Home",Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.settings:
                        Toast.makeText(getApplicationContext(),"Settings",Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.trash:
                        Toast.makeText(getApplicationContext(),"Trash",Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.logout:
                        finish();
                }
                return true;
            }
        });
        View header = navigationView.getHeaderView(0);
        //  TextView tv_email = (TextView)header.findViewById(R.id.tv_email);
        //  tv_email.setText("raj.amalw@learn2crack.com");
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle actionBarDrawerToggle =
                new ActionBarDrawerToggle(this,drawerLayout,toolbarNegocios,R.string.drawer_open,R.string.drawer_close){

                    @Override
                    public void onDrawerClosed(View v){
                        super.onDrawerClosed(v);
                    }

                    @Override
                    public void onDrawerOpened(View v) {
                        super.onDrawerOpened(v);
                    }
                };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }
}
