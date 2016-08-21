package com.example.ahmme.tourmate;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.ahmme.tourmate.Expence.ExpenceFragment;
import com.example.ahmme.tourmate.TourMate.MainFragment;
import com.example.ahmme.tourmate.NearBy.NearByFragment;
import com.example.ahmme.tourmate.TourMate.ViewTravelMomentFragment;
import com.example.ahmme.tourmate.Tracker.LocationTrackerFragment;
import com.example.ahmme.tourmate.TravelLogManagement.TravelLogFragment;
import com.example.ahmme.tourmate.Weather.WeatherFragment;

public class TureMateActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView = null;
    Toolbar toolbar = null;

    Fragment currentFragment;
    FragmentManager manager;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ture_mate);

        currentFragment = new MainFragment();
        manager = getFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.fragment_container, currentFragment);
        transaction.commit();




       toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
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
        getMenuInflater().inflate(R.menu.ture_mate, menu);
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

        if (id == R.id.weather) {
            currentFragment=new WeatherFragment();
        } else if (id == R.id.nav_gallery) {
            currentFragment = new MainFragment();

        } else if (id == R.id.viewTravleMoment) {
            transaction.remove(currentFragment);
            currentFragment = new ViewTravelMomentFragment();
        } else if (id == R.id.travel_log) {
            transaction.remove(currentFragment);
            currentFragment = new TravelLogFragment();

        } else if (id == R.id.expance) {
            currentFragment=new ExpenceFragment();

        } else if (id == R.id.nearBy) {
            transaction.remove(currentFragment);
            currentFragment = new NearByFragment();

        } else if (id == R.id.tracker) {
            currentFragment=new LocationTrackerFragment();

        }else if (id == R.id.nav_share) {

        }else if (id == R.id.about) {

        }
        transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container, currentFragment);
        transaction.addToBackStack(null);
        transaction.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
