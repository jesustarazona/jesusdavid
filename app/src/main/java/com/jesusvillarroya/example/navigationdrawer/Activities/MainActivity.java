package com.jesusvillarroya.example.navigationdrawer.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;

import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.jesusvillarroya.example.navigationdrawer.Fragments.InformacionFragment;
import com.jesusvillarroya.example.navigationdrawer.Fragments.ListadoFragment;
import com.jesusvillarroya.example.navigationdrawer.R;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, CompoundButton.OnCheckedChangeListener{

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Switch switchBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();
        drawerLayout =(DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView = (NavigationView)findViewById(R.id.navview);

        changeFragment(new InformacionFragment(), navigationView.getMenu().getItem(0));


        //Controlar cuando está abierto el Drawer
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });


        //Navegación con el Drawer
        navigationView.setNavigationItemSelectedListener(this);

        //Manejar el switch del Drawer
        switchBtn = (Switch) navigationView.getMenu().findItem(R.id.opcion_1).getActionView();
        switchBtn.setOnCheckedChangeListener(this);

    }

    private void setToolbar(){
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Añadimos el icono de la hamburguesa
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    private void changeFragment(Fragment fragment, MenuItem item){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();
        item.setChecked(true);
        getSupportActionBar().setTitle(item.getTitle());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                //Abrir el menú lateral
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);


    }
    //Switch Listener del drawer
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
        if (checked){
            Toast.makeText(this, "Sip, has activado", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Me has desactivado", Toast.LENGTH_SHORT).show();
        }
    }

    //Navegación con el Drawer
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        boolean fragmentTransaction = false;
        Fragment fragment = null;

        switch (item.getItemId()){
            case R.id.menu_1:
                fragment = new ListadoFragment();
                fragmentTransaction=true;
                break;

            case R.id.menu_2:
                fragment = new InformacionFragment();
                fragmentTransaction=true;
                break;
        }

        if (fragmentTransaction == true) {
            changeFragment(fragment, item);
            drawerLayout.closeDrawers();
        }
        return true;

    }
}
