package com.example.btrade;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    RecyclerView recyclerView,trendyrecyclerview,categrecyclerview;
    static final float END_SCALE = 0.7f;
    RecyclerView.Adapter adapter;
    private GradientDrawable gradientDrawable1,gradientDrawable2,gradientDrawable3,gradientDrawable4;
    LinearLayout contentview;
    ImageView menuicon,add;
    //drawermenu
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.dashbrd_activity);
        //HOOKS
        recyclerView = findViewById(R.id.recyl);
        trendyrecyclerview = findViewById(R.id.trend_view);
        categrecyclerview = findViewById(R.id.categories_recycler);
        menuicon = findViewById(R.id.menum);
        add = findViewById(R.id.neww);
        contentview=findViewById(R.id.content);

        //menu hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_menu);


        navigateDrawer();


        //function call of recycler view
        featuredRecycler();
        trendingRecycler();
        categoryRecycler();

    }
    public void callStartupScreen(View view){
        startActivity(new Intent(getApplicationContext(),StartupActivity.class));
    }

//navigation funcions
    private void navigateDrawer() {
        //navigationdrawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);
        menuicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else
                    drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        //animate
        animatenav();
    }

    private void animatenav() {
        drawerLayout.setScrimColor(getResources().getColor(R.color.bannerbackground));
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentview.setScaleX(offsetScale);
                contentview.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentview.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentview.setTranslationX(xTranslation);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerVisible(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
        super.onBackPressed();
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_all_categories:
                Intent intent = new Intent(getApplicationContext(), AllCategory.class);
                startActivity(intent);
                break;

            case R.id.nav_login:
                Intent login = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(login);
                break;
        }
        return true;
    }


//recyclerview
    private void featuredRecycler() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<RecyModel> ftlocs = new ArrayList<>();
        ftlocs.add(new RecyModel(R.drawable.plimbing,"service","i do plumbing"));
        ftlocs.add(new RecyModel(R.drawable.laundry,"service","naosha nguo for exchange"));
        ftlocs.add(new RecyModel(R.drawable.chair,"household","newly bought chair,white in color,three seater"));
        ftlocs.add(new RecyModel(R.drawable.bicycle,"household","serviced red bicyle for age 10 and above"));
        ftlocs.add(new RecyModel(R.drawable.book,"textbooks","i'm swapping  form 4 textbooks for an exhange of an item"));

        adapter= new RecyAdapter(ftlocs);
        recyclerView.setAdapter(adapter);

        GradientDrawable gradientDrawable1= new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff400,0xffaff600});
    }
    private void trendingRecycler() {
        trendyrecyclerview.setHasFixedSize(true);
        trendyrecyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<TrendyModel> tlocs = new ArrayList<>();
        tlocs.add(new TrendyModel(R.drawable.plimbing,"service","i do plumbing"));
        tlocs.add(new TrendyModel(R.drawable.laundry,"service","naosha nguo for exchange"));
        tlocs.add(new TrendyModel(R.drawable.chair,"household","newly bought chair,white in color,three seater"));
        tlocs.add(new TrendyModel(R.drawable.bicycle,"household","serviced red bicyle for age 10 and above"));
        tlocs.add(new TrendyModel(R.drawable.book,"textbooks","i'm swapping  form 4 textbooks for an exhange of an item"));

        adapter= new TrendingAdapter(tlocs);
        recyclerView.setAdapter(adapter);

        GradientDrawable gradientDrawable2= new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff400,0xffaff600});
    }
    private void categoryRecycler() {
        categrecyclerview.setHasFixedSize(true);
        categrecyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<CategModel> categloc = new ArrayList<>();
        categloc.add(new CategModel(R.drawable.plimbing,"service","i do plumbing"));
        categloc.add(new CategModel(R.drawable.laundry,"service","naosha nguo for exchange"));
        categloc.add(new CategModel(R.drawable.chair,"household","newly bought chair,white in color,three seater"));
        categloc.add(new CategModel(R.drawable.bicycle,"household","serviced red bicyle for age 10 and above"));
        categloc.add(new CategModel(R.drawable.book,"textbooks","i'm swapping  form 4 textbooks for an exhange of an item"));

        adapter= new CategoryAdapter(categloc);
        recyclerView.setAdapter(adapter);
        GradientDrawable gradientDrawable3= new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff400,0xffaff600});

    }


}