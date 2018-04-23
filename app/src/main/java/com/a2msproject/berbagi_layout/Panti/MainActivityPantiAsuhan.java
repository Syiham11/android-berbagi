package com.a2msproject.berbagi_layout.Panti;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.a2msproject.berbagi_layout.R;

public class MainActivityPantiAsuhan extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FrameLayout container;
    RelativeLayout relativeLayout;

    RecyclerView recyclerView;
    ActionBar abp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_panti_asuhan);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        container=(FrameLayout) findViewById(R.id.container_body_panti_asuhan);
        relativeLayout=(RelativeLayout) findViewById(R.id.content_main_panti_asuhan);
        setSupportActionBar(toolbar);

        container=(FrameLayout) findViewById(R.id.container_body_panti_asuhan);
        setSupportActionBar(toolbar);

        abp=getSupportActionBar();

        container.setVisibility(View.VISIBLE);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity_panti_asuhan, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment=null;

        if (id == R.id.nav_home) {
            container.setVisibility(View.GONE);
            relativeLayout.setVisibility(View.VISIBLE);
            abp.setTitle("Berita");
        } else if (id == R.id.nav_dt) {
            container.setVisibility(View.VISIBLE);
            relativeLayout.setVisibility(View.GONE);
            fragment=new Fragment_Tab_Donatur_Tetap_Panti();
            abp.setTitle("Donatur Tetap");

        } else if (id == R.id.nav_db) {
            container.setVisibility(View.VISIBLE);
            relativeLayout.setVisibility(View.GONE);
            fragment=new Fragment_Tab_Donasi_Barang_Panti();
            abp.setTitle("Donasi Barang");

        } else if (id == R.id.nav_dd) {
            container.setVisibility(View.VISIBLE);
            relativeLayout.setVisibility(View.GONE);
            fragment=new Fragment_Tab_Donasi_Dana_Panti();
            abp.setTitle("Donasi Dana");

        } else if (id == R.id.nav_pk) {
            container.setVisibility(View.VISIBLE);
            relativeLayout.setVisibility(View.GONE);
            fragment=new Fragment_Tab_Permintaan_Kegiatan_Panti();
            abp.setTitle("Kegiatan");
        } else if (id == R.id.nav_profil) {
            container.setVisibility(View.VISIBLE);
            relativeLayout.setVisibility(View.GONE);
            fragment=new Fragment_Profil_Panti_Asuhan();
            abp.setTitle("Profil Panti Asuhan");
        }else if (id == R.id.nav_logout) {

        }

        if(fragment!=null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body_panti_asuhan, fragment);
            fragmentTransaction.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
