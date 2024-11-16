package com.rajviryadav.utility;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;


public class Splash extends AppCompatActivity
{

    CountDownTimer CDT;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        CDT = new CountDownTimer(2500, 500)
        {
            public void onTick(long millisUntilFinished)
            {

            }
            public void onFinish()
            {
                Intent ns=new Intent(Splash.this,MainActivity.class);
                startActivity(ns);
            }
        }.start();
    }

    @Override
    public void onBackPressed()
    {
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory(Intent.CATEGORY_HOME);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
        this.finishAffinity();
    }


}
