package com.gquasar.galgotiasunifest2017;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Activity_Main extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener , FragmentChangeListener {

    Toolbar toolbar;
    public String fburl="https://www.facebook.com/gquasar/";
    String fragmenttag="Null";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Galgotias Unifest 2017");
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        Intent it= getIntent();
        fragmenttag =it.getStringExtra("fragment");
        if(fragmenttag.equals("home"))
        {
            toolbar.setTitle("Galgotias Unifest 2017");
            Fragment fragment= new Fragment_HomePage();
            FragmentManager  fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.content_activity__home_page,fragment);
            fragmentTransaction.commit();
        }
        if(fragmenttag.equals("register"))
        {
            toolbar.setTitle("Register");
            Fragment fragment= new Fragment_Register();
            FragmentManager  fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content_activity__home_page,fragment);
            fragmentTransaction.commit();
        }
        if(fragmenttag.equals("contacts"))
        {

            toolbar.setTitle("Contacts");
            Fragment  fragment= new Fragment_Contacts();
            FragmentManager  fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content_activity__home_page,fragment);
            fragmentTransaction.commit();
        } if(fragmenttag.equals("about"))
        {
            toolbar.setTitle("About");
            Fragment fragment= new Fragment_AboutUs();
            FragmentManager  fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content_activity__home_page,fragment);
            fragmentTransaction.commit();
        } if(fragmenttag.equals("developer"))
        {
            toolbar.setTitle("Developers");
            Fragment  fragment= new Fragment_Developers();
            FragmentManager  fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content_activity__home_page,fragment);
            fragmentTransaction.commit();
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Fragment_HomePage myFragment=(Fragment_HomePage)getSupportFragmentManager().findFragmentByTag("home");
            if (myFragment == null) {
                Fragment fragment= new Fragment_HomePage();
                FragmentManager  fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_activity__home_page,fragment,"home");
                fragmentTransaction.commit();
                toolbar.setTitle("Galgotias Unifest 2017");
            }
            else {
                AlertDialog.Builder alert=new AlertDialog.Builder(this);
                alert.setMessage("Do you want to Exit ?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alertDialog=alert.create();
                alertDialog.setTitle("Exit ?");
                alertDialog.show();
            }
    }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.activity__home_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
           finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        Fragment fragment;

        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Fragment_HomePage myFragment = (Fragment_HomePage) getSupportFragmentManager().findFragmentByTag("home");
            if (myFragment == null) {
                        Fragment fragment_homePage= new Fragment_HomePage();
                        FragmentManager  fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.content_activity__home_page,fragment_homePage,"home");
                        fragmentTransaction.commit();
            }
        }

       else if (id == R.id.nav_events) {
            Intent intent=new Intent(this,Activity_Events.class);
            startActivity(intent);
            finish();

        } else if (id == R.id.nav_gallery) {
            Intent intent=new Intent(this,Activity_Gallery.class);
            startActivity(intent);

        } else if (id == R.id.nav_register) {
            toolbar.setTitle("Register");
             fragment= new Fragment_Register();
            FragmentManager  fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content_activity__home_page,fragment);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_contacts) {
            toolbar.setTitle("Contacts");
            fragment= new Fragment_Contacts();
            FragmentManager  fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content_activity__home_page,fragment);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_facebook) {

            Uri uri= Uri.parse(fburl);
            Intent intent=new Intent(Intent.ACTION_VIEW,uri);
            startActivity(intent);

        }
        else if (id == R.id.nav_about) {
            toolbar.setTitle("About");
            fragment= new Fragment_AboutUs();
            FragmentManager  fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content_activity__home_page,fragment);
            fragmentTransaction.commit();

        }else if (id == R.id.nav_developer) {
            toolbar.setTitle("Developers");
            fragment= new Fragment_Developers();
            FragmentManager  fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content_activity__home_page,fragment);
            fragmentTransaction.commit();

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void replaceFragment(Fragment fragment,String title) {
        toolbar.setTitle(title);
        FragmentManager  fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_activity__home_page,fragment);
        fragmentTransaction.commit();
    }
}

