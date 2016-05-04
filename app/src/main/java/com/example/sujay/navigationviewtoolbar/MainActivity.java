package com.example.sujay.navigationviewtoolbar;

import android.app.Activity;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final DrawerLayout drawerLayout=(DrawerLayout)findViewById(R.id.drawerlayout);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.dopen,R.string.dclosed){
            public void onDrawerOpened(View v)
            {
                    super.onDrawerOpened(v);
            }
            public void onDrawerClosed(View v)
            {
                    super.onDrawerClosed(v);
            }
        };
        NavigationView navigationView=(NavigationView)findViewById(R.id.navview);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            public boolean onNavigationItemSelected(MenuItem item)
            {
                Toast.makeText(getApplicationContext()," "+item.getItemId(),Toast.LENGTH_LONG).show();
                drawerLayout.closeDrawers();
                return true;
            }
        });
        drawerLayout.addDrawerListener(toggle);
       toggle.syncState();
    }
}
