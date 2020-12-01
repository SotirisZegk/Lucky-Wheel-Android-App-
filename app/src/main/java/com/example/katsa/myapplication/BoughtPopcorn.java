package com.example.katsa.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class BoughtPopcorn extends AppCompatActivity {

    public static final int Length = 12;

    TextView edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //set content view AFTER ABOVE sequence (to avoid crash)
        this.setContentView(R.layout.activity_bought_popcorn);

        RandomString rd = new RandomString();
        String temp = rd.RandomString(Length);
        edit=(TextView) findViewById(R.id.Coupon3);
        edit.setText(temp);
    }
}
