package com.example.dapmapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import android.view.MenuItem;
import android.os.Bundle;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    //divcontent
    RecyclerView recyclerView;

    //Pozele din stiri
    String[] s1, s2;
    int[] images = {R.drawable.centrafrique, R.drawable.pacte_de_stabilite, R.drawable.starliner,
            R.drawable.enbretagne, R.drawable.liverpool, R.drawable.djokovicnadal,
            R.drawable.lacaserne, R.drawable.recyclage, R.drawable.lafrance, R.drawable.puces_electroniques};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Drawer - butoanele de open close, si trecerea inapoi
        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        // trece peste trigger-ul de open close si intoarce inapoi
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //divcontent
        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.articles);
        s2 = getResources().getStringArray(R.array.description);

        DivAdapter divAdapter = new DivAdapter(this, s1, s2, images);
        recyclerView.setAdapter(divAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    // override pentru onOptionsItemSelected()

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}