package com.a2msproject.berbagi_layout.Donatur;

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

public class MainActivityDonatur extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FrameLayout container;
    RelativeLayout relativeLayout;

    RecyclerView recyclerView;
    ActionBar ab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_donatur);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        container=(FrameLayout) findViewById(R.id.container_body);
        relativeLayout=(RelativeLayout) findViewById(R.id.content_main_donatur);
        setSupportActionBar(toolbar);

        container=(FrameLayout) findViewById(R.id.container_body);
        setSupportActionBar(toolbar);

        ab=getSupportActionBar();

        container.setVisibility(View.VISIBLE);

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
        getMenuInflater().inflate(R.menu.main_activity_donatur, menu);
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
            ab.setTitle("Berita");
        } else if (id == R.id.nav_panti_asuhan) {
            container.setVisibility(View.VISIBLE);
            relativeLayout.setVisibility(View.GONE);
            fragment=new Fragment_Tab_Panti_Asuhan();
            ab.setTitle("Panti Asuhan");
        } else if (id == R.id.nav_donasi_barang) {
            container.setVisibility(View.VISIBLE);
            relativeLayout.setVisibility(View.GONE);
            fragment=new Fragment_Tab_Donasi_Barang();
            ab.setTitle("Donasi Barang");
        }else if (id == R.id.nav_donasi_dana) {
            container.setVisibility(View.VISIBLE);
            relativeLayout.setVisibility(View.GONE);
            fragment=new Fragment_Tab_Donasi_Dana();
            ab.setTitle("Donasi Dana");
        } else if (id == R.id.nav_dp) {
            container.setVisibility(View.VISIBLE);
            relativeLayout.setVisibility(View.GONE);
            fragment=new Fragment_Tab_Donatur_Tetap();
            ab.setTitle("Donatur Tetap");
        } else if (id == R.id.nav_kegiatan) {
            container.setVisibility(View.VISIBLE);
            relativeLayout.setVisibility(View.GONE);
            fragment=new Fragment_Tab_Permintaan_Kegiatan();
            ab.setTitle("Kegiatan");
        } else if (id == R.id.nav_logout) {
        }

        if(fragment!=null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
