package com.example.campingintunisia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }




    public void closeScreen(View view) {
        finish();
    }


    public void skipScreen(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}