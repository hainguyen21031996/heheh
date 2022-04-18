package com.example.signingoogle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.signingoogle.News.BangTin;

public class ListCongThuc extends AppCompatActivity {

    ImageView home, bun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_cong_thuc);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        home = findViewById(R.id.home_icon);
        bun = findViewById(R.id.bun);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListCongThuc.this, HomeActivity.class);
                startActivity(i);
                finish();
            }
        });

        bun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListCongThuc.this, BangTin.class);
                startActivity(i);
                finish();
            }
        });

    }
}