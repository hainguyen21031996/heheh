package com.example.signingoogle;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class NewFeed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_feed);

        setTitle("Bảng Tin");
    }
}