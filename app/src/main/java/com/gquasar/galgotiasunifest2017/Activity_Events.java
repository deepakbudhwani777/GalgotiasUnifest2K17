package com.gquasar.galgotiasunifest2017;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Activity_Events extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    LinearLayout ll1,ll2,ll3,ll4,ll5,ll6,ll7,ll8,ll9,ll10;
    ImageView iv1,iv2,iv3,iv4,iv5,iv6,iv7,iv8,iv9,iv10;
    Toolbar toolbar;
    public String fburl="https://www.facebook.com/gquasar/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__events);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Events");
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ll1=(LinearLayout)findViewById(R.id.ll1);
        ll2=(LinearLayout)findViewById(R.id.ll2);
        ll3=(LinearLayout)findViewById(R.id.ll3);
        ll4=(LinearLayout)findViewById(R.id.ll4);
        ll5=(LinearLayout)findViewById(R.id.ll5);
        ll6=(LinearLayout)findViewById(R.id.ll6);
        ll7=(LinearLayout)findViewById(R.id.ll7);
        ll8=(LinearLayout)findViewById(R.id.ll8);
        ll9=(LinearLayout)findViewById(R.id.ll9);
        ll10=(LinearLayout)findViewById(R.id.ll10);
        iv1=(ImageView)findViewById(R.id.iv1);
        iv2=(ImageView)findViewById(R.id.iv2);
        iv3=(ImageView)findViewById(R.id.iv3);
        iv4=(ImageView)findViewById(R.id.iv4);
        iv5=(ImageView)findViewById(R.id.iv5);
        iv6=(ImageView)findViewById(R.id.iv6);
        iv7=(ImageView)findViewById(R.id.iv7);
        iv8=(ImageView)findViewById(R.id.iv8);
        iv9=(ImageView)findViewById(R.id.iv9);
        iv10=(ImageView)findViewById(R.id.iv10);

        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(ll1.getVisibility()==View.GONE)
                {
                    ll1.setVisibility(View.VISIBLE);
                }
                else
                {
                    ll1.setVisibility(View.GONE);
                }
                ll2.setVisibility(View.GONE);
                ll3.setVisibility(View.GONE);
                ll4.setVisibility(View.GONE);
                ll5.setVisibility(View.GONE);
                ll6.setVisibility(View.GONE);
                ll7.setVisibility(View.GONE);
                ll8.setVisibility(View.GONE);
                ll9.setVisibility(View.GONE);
                ll10.setVisibility(View.GONE);


            }
        });
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ll2.getVisibility()==View.GONE)
                {
                    ll2.setVisibility(View.VISIBLE);
                }
                else
                {
                    ll2.setVisibility(View.GONE);
                }
                ll1.setVisibility(View.GONE);
                ll3.setVisibility(View.GONE);
                ll4.setVisibility(View.GONE);
                ll5.setVisibility(View.GONE);
                ll6.setVisibility(View.GONE);
                ll7.setVisibility(View.GONE);
                ll8.setVisibility(View.GONE);
                ll9.setVisibility(View.GONE);
                ll10.setVisibility(View.GONE);
            }
        });

        iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ll3.getVisibility()==View.GONE)
                {
                    ll3.setVisibility(View.VISIBLE);
                }
                else
                {
                    ll3.setVisibility(View.GONE);
                }
                ll1.setVisibility(View.GONE);
                ll2.setVisibility(View.GONE);
                ll4.setVisibility(View.GONE);
                ll5.setVisibility(View.GONE);
                ll6.setVisibility(View.GONE);
                ll7.setVisibility(View.GONE);
                ll8.setVisibility(View.GONE);
                ll9.setVisibility(View.GONE);
                ll10.setVisibility(View.GONE);
            }
        });

        iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ll4.getVisibility()==View.GONE)
                {
                    ll4.setVisibility(View.VISIBLE);
                }
                else
                {
                    ll4.setVisibility(View.GONE);
                }
                ll1.setVisibility(View.GONE);
                ll3.setVisibility(View.GONE);
                ll2.setVisibility(View.GONE);
                ll5.setVisibility(View.GONE);
                ll6.setVisibility(View.GONE);
                ll7.setVisibility(View.GONE);
                ll8.setVisibility(View.GONE);
                ll9.setVisibility(View.GONE);
                ll10.setVisibility(View.GONE);
            }
        });

        iv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ll5.getVisibility()==View.GONE)
                {
                    ll5.setVisibility(View.VISIBLE);
                }
                else
                {
                    ll5.setVisibility(View.GONE);
                }
                ll1.setVisibility(View.GONE);
                ll3.setVisibility(View.GONE);
                ll4.setVisibility(View.GONE);
                ll2.setVisibility(View.GONE);
                ll6.setVisibility(View.GONE);
                ll7.setVisibility(View.GONE);
                ll8.setVisibility(View.GONE);
                ll9.setVisibility(View.GONE);
                ll10.setVisibility(View.GONE);
            }
        });

        iv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ll6.getVisibility()==View.GONE)
                {
                    ll6.setVisibility(View.VISIBLE);
                }
                else
                {
                    ll6.setVisibility(View.GONE);
                }
                ll1.setVisibility(View.GONE);
                ll3.setVisibility(View.GONE);
                ll4.setVisibility(View.GONE);
                ll5.setVisibility(View.GONE);
                ll2.setVisibility(View.GONE);
                ll7.setVisibility(View.GONE);
                ll8.setVisibility(View.GONE);
                ll9.setVisibility(View.GONE);
                ll10.setVisibility(View.GONE);
            }
        });

        iv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ll7.getVisibility()==View.GONE)
                {
                    ll7.setVisibility(View.VISIBLE);
                }
                else
                {
                    ll7.setVisibility(View.GONE);
                }
                ll1.setVisibility(View.GONE);
                ll3.setVisibility(View.GONE);
                ll4.setVisibility(View.GONE);
                ll5.setVisibility(View.GONE);
                ll6.setVisibility(View.GONE);
                ll2.setVisibility(View.GONE);
                ll8.setVisibility(View.GONE);
                ll9.setVisibility(View.GONE);
                ll10.setVisibility(View.GONE);
            }
        });

        iv8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ll8.getVisibility()==View.GONE)
                {
                    ll8.setVisibility(View.VISIBLE);
                }
                else
                {
                    ll8.setVisibility(View.GONE);
                }
                ll1.setVisibility(View.GONE);
                ll3.setVisibility(View.GONE);
                ll4.setVisibility(View.GONE);
                ll5.setVisibility(View.GONE);
                ll6.setVisibility(View.GONE);
                ll7.setVisibility(View.GONE);
                ll2.setVisibility(View.GONE);
                ll9.setVisibility(View.GONE);
                ll10.setVisibility(View.GONE);
            }
        });

        iv9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ll9.getVisibility()==View.GONE)
                {
                    ll9.setVisibility(View.VISIBLE);
                }
                else
                {
                    ll9.setVisibility(View.GONE);
                }
                ll1.setVisibility(View.GONE);
                ll3.setVisibility(View.GONE);
                ll4.setVisibility(View.GONE);
                ll5.setVisibility(View.GONE);
                ll6.setVisibility(View.GONE);
                ll7.setVisibility(View.GONE);
                ll8.setVisibility(View.GONE);
                ll2.setVisibility(View.GONE);
                ll10.setVisibility(View.GONE);
            }
        });

        iv10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ll10.getVisibility()==View.GONE)
                {
                    ll10.setVisibility(View.VISIBLE);
                }
                else
                {
                    ll10.setVisibility(View.GONE);
                }
                ll1.setVisibility(View.GONE);
                ll3.setVisibility(View.GONE);
                ll4.setVisibility(View.GONE);
                ll5.setVisibility(View.GONE);
                ll6.setVisibility(View.GONE);
                ll7.setVisibility(View.GONE);
                ll8.setVisibility(View.GONE);
                ll9.setVisibility(View.GONE);
                ll2.setVisibility(View.GONE);
            }
        });


    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Intent intent=new Intent(this,Activity_Main.class);
            intent.putExtra("fragment", "home");
            startActivity(intent);
            finish();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent intent=new Intent(this,Activity_Main.class);
            intent.putExtra("fragment", "home");
            startActivity(intent);
            finish();
        }
        else if (id == R.id.nav_events) {

        } else if (id == R.id.nav_gallery) {
            Intent intent=new Intent(this,Activity_Gallery.class);
            startActivity(intent);

        } else if (id == R.id.nav_register) {
            Intent intent=new Intent(this,Activity_Main.class);
            intent.putExtra("fragment", "register");
            startActivity(intent);
            finish();

        } else if (id == R.id.nav_contacts) {

            Intent intent=new Intent(this,Activity_Main.class);
            intent.putExtra("fragment", "contacts");
            startActivity(intent);
            finish();

        } else if (id == R.id.nav_facebook) {

            Uri uri= Uri.parse(fburl);
            Intent intent=new Intent(Intent.ACTION_VIEW,uri);
            startActivity(intent);
        }
        else if (id == R.id.nav_about) {

            Intent intent=new Intent(this,Activity_Main.class);
            intent.putExtra("fragment", "about");
            startActivity(intent);
            finish();

        }else if (id == R.id.nav_developer) {

            Intent intent=new Intent(this,Activity_Main.class);
            intent.putExtra("fragment", "developer");
            startActivity(intent);
            finish();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
