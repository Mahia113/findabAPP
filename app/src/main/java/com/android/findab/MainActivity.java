package com.android.findab;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.findab.adaptador.categoriaAdaptador;
import com.android.findab.modelo.Categoria;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    private RecyclerView recyclerCategorias;
    private List<Categoria> listaCategorias;

    private Toolbar toolbar;

    /**
     * Instancia del drawer
     */
    private DrawerLayout drawerLayout;

    /**
     * Titulo inicial del drawer
     */
    private String drawerTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        ActionBar bar = getSupportActionBar();

        bar.setDisplayShowTitleEnabled(false);
       // bar.setTitle("Categorias");

        CollapsingToolbarLayout ctlLayout = (CollapsingToolbarLayout)findViewById(R.id.mycoll);
        //ctlLayout.setTitle("Mi Aplicaciónnn");

        recyclerCategorias = (RecyclerView) findViewById(R.id.recyclerview_categorias);

        //LinearLayoutManager lm = new LinearLayoutManager(this);
        //lm.setOrientation(LinearLayoutManager.VERTICAL);

        GridLayoutManager glm = new GridLayoutManager(this,2);
        recyclerCategorias.setLayoutManager(glm);

        initNavigationDrawer();

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

        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                int var = recyclerCategorias.getChildPosition(v);

                switch (var)
                {
                    case 0:
                        Toast.makeText(getApplicationContext(),"Estas dentro de la categoria Restaurantes",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),ListaNegocios.class);
                        intent.putExtra("parametro", "Restaurantes");
                        startActivity(intent);
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(),"Estas dentro de la categoria Bares",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(),"Estas dentro de la categoria Cafeterias",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(),"Estas dentro de la categoria Farmacias",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(getApplicationContext(),"Estas dentro de la categoria Turisticos",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(getApplicationContext(),"Estas dentro de la categoria Favoritos",
                                Toast.LENGTH_SHORT).show();
                        break;
                }

                // Log.i("DemoRecView", "Pulsado el elemento " + recView.getChildPosition(v));
            }
        });
        recyclerCategorias.setAdapter(adaptador);
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
                new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close){

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
