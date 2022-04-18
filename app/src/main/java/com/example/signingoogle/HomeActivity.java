package com.example.signingoogle;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.signingoogle.HelperClasses.CaretoriesAdapter;
import com.example.signingoogle.HelperClasses.CaretoriesHelperClass;
import com.example.signingoogle.HelperClasses.FeartureHelperClass;
import com.example.signingoogle.HelperClasses.FeaturedAdapter;
import com.example.signingoogle.HelperClasses.HostSearchAdapter;
import com.example.signingoogle.HelperClasses.HostsearchHelperClass;
import com.example.signingoogle.HelperClasses.MostviewApdapter;
import com.example.signingoogle.HelperClasses.MostviewHelperClass;
import com.example.signingoogle.ListPho.ChuyenActivity;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView rcv1, rcmostview, rccare, rchs;
    RecyclerView.Adapter adapter;

    ImageView menuIcon;
    LinearLayout contentView;

    //Variables
    static final float END_SCALE = 0.7f;

    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    LinearLayout listcongthuc, newfeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_test);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        rcv1 = findViewById(R.id.rcv1);
        rcmostview = findViewById(R.id.rcmostview);
        rccare = findViewById(R.id.rccare);
        rchs = findViewById(R.id.rchs);

        //Hooks
        menuIcon = findViewById(R.id.menu_icon);
        contentView = findViewById(R.id.contentt);

        //Menu Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);


        listcongthuc = findViewById(R.id.listcongthuc);
        newfeed = findViewById(R.id.newfeed);

        listcongthuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, ChuyenActivity.class);
                startActivity(i);
            }
        });

        newfeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, NewFeed.class);
                startActivity(i);
            }
        });

        navigationView();

        rcv1();
        rcmostview();
        rccare();
        rchs();


    }

    private void navigationView() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        animateNavigationDrawer();
    }

    private void animateNavigationDrawer() {
        //Add any color or remove it to use the default one!
        //To make it transparent use Color.Transparent in side setScrimColor();
        drawerLayout.setScrimColor(getResources().getColor(R.color.plus));
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }

    private void rchs() {

        ArrayList<HostsearchHelperClass> hostsearchHelperClasses = new ArrayList<>();
        hostsearchHelperClasses.add(new HostsearchHelperClass( "1.", "Làm đồ ăn vặt từ cơm nguội"));
        hostsearchHelperClasses.add(new HostsearchHelperClass( "2.", "Làm lẩu thái"));
        hostsearchHelperClasses.add(new HostsearchHelperClass( "3.", "Làm bánh sinh nhật"));

        rchs.setHasFixedSize(true);
        adapter = new HostSearchAdapter(hostsearchHelperClasses);
        rchs.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rchs.setAdapter(adapter);
    }

    private void rccare() {

        ArrayList<CaretoriesHelperClass> categoriesHelperClasses = new ArrayList<>();
        categoriesHelperClasses.add(new CaretoriesHelperClass( R.drawable.care1, "Bún - Mì - Phở"));
        categoriesHelperClasses.add(new CaretoriesHelperClass( R.drawable.care2, "Ăn Vặt"));
        categoriesHelperClasses.add(new CaretoriesHelperClass( R.drawable.care3, "Nước "));

        rccare.setHasFixedSize(true);
        adapter = new CaretoriesAdapter(categoriesHelperClasses);
        rccare.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rccare.setAdapter(adapter);
    }

    private void rcv1() {
        rcv1.setHasFixedSize(true);
        rcv1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeartureHelperClass> featurelocation = new ArrayList<>();
        featurelocation.add(new FeartureHelperClass(R.drawable.amthuc, "Bữa sáng thú vị", "Một vài gợi ý giúp team lười nhất cũng có bữa sáng vừa nhanh gọn, bổ dưỡng lại ngon miệng mỗi ngày"));
        featurelocation.add(new FeartureHelperClass(R.drawable.buatrua, "Bữa trưa ngon miệng", "Thực đơn cơm trưa cho gia đình, đảm bảo 'Ngon - Bổ - Rẻ'  "));
        featurelocation.add(new FeartureHelperClass(R.drawable.buatoi, "Bữa tối heathy", "Gợi ý thực đơn bữa tối trong 1 tuần để da xinh, dáng gọn"));

        adapter = new FeaturedAdapter(featurelocation);
        rcv1.setAdapter(adapter);

        //GradientDrawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff400, 0xffaff600});

    }

    private void rcmostview(){
        rcmostview.setHasFixedSize(true);
        rcmostview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostviewHelperClass> mostViewedLocations = new ArrayList<>();
        mostViewedLocations.add(new MostviewHelperClass(R.drawable.mostview1, "BÁNH TIÊU", "Làm bánh tiêu đơn giản tại nhà không cần men nở, không cần ủ bột."));
        mostViewedLocations.add(new MostviewHelperClass(R.drawable.mostview2, "TRÂN CHÂU", "Làm trân châu từ bột năng, bột nếp, bột mì thơm ngon, dai mềm"));
        mostViewedLocations.add(new MostviewHelperClass(R.drawable.mostview3, "BÁNH FLAN", "Công thức Bánh Flan bất bại rất đơn giản ngay tại nhà"));

        adapter = new MostviewApdapter(mostViewedLocations);
        rcmostview.setAdapter(adapter);
    }

}