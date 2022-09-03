package com.example.quranapplistview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;
import com.example.quranapplistview.SurahModel;

import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    ListView surahlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        surahlist=findViewById(R.id.surahList);
        navigationView=findViewById(R.id.nav_menu);
        drawerLayout=findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        DBHelper helper=new DBHelper(MainActivity.this);
        List<com.example.quranapplistview.SurahModel> surahModels=helper.readSurah();
        custom_surahAdapter adapter=new custom_surahAdapter(MainActivity.this, surahModels);
        surahlist.setAdapter(adapter);
        surahlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this, Surah.class);
                intent.putExtra("position", position);
                intent.putExtra("type", "Surah");
                startActivity(intent);
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.para_open)
                {
                    Intent intent1=new Intent(MainActivity.this, Para_List.class);
                    startActivity(intent1);
                    return true;
                }
                else if(item.getItemId()==R.id.app_bar_search){

                    return true;
                }
                else{
                    return false;
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.surah_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.para_open) {
            Toast.makeText(this, "Android Menu is Clicked", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this,Para_List.class);
            startActivity(intent);
            return true;
        }
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}