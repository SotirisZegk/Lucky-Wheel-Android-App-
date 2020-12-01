package com.example.katsa.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MoreMoneyActivity extends AppCompatActivity {

    TextView edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //set content view AFTER ABOVE sequence (to avoid crash)
        this.setContentView(R.layout.activity_moremoney);

        initViews();

        SharedPreferences sp = getSharedPreferences("your_prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =sp.edit();
        String temp = Integer.toString(sp.getInt("your_int_key",Activity.MODE_PRIVATE));
        edit=(TextView) findViewById(R.id.coins);
        edit.setText(temp);

    }

    private void initViews() {

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("your_prefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor =sp.edit();
                    int temp = ((sp.getInt("your_int_key",Activity.MODE_PRIVATE)+10));
                    editor.putInt("your_int_key",temp);
                    editor.commit();
                    String temps= Integer.toString(sp.getInt("your_int_key",Activity.MODE_PRIVATE));
                    edit=(TextView) findViewById(R.id.coins);
                    edit.setText(temps);
//                    Intent intent = new Intent(MoreMoneyActivity.this, BoughtBurger.class);
//                    startActivity(intent);
            }
        });

        Button button9 = findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("your_prefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor =sp.edit();
                    int temp = ((sp.getInt("your_int_key",Activity.MODE_PRIVATE)+50));
                    editor.putInt("your_int_key",temp);
                    editor.commit();
                    String temps= Integer.toString(sp.getInt("your_int_key",Activity.MODE_PRIVATE));
                    edit=(TextView) findViewById(R.id.coins);
                    edit.setText(temps);
//                    Intent intent = new Intent(MoreMoneyActivity.this, BoughtPizza.class);
//                    startActivity(intent);
            }
        });

        Button button8 = findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("your_prefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor =sp.edit();
                    int temp = ((sp.getInt("your_int_key",Activity.MODE_PRIVATE)+100));
                    editor.putInt("your_int_key",temp);
                    editor.commit();
                    String temps= Integer.toString(sp.getInt("your_int_key",Activity.MODE_PRIVATE));
                    edit=(TextView) findViewById(R.id.coins);
                    edit.setText(temps);
//                    Intent intent = new Intent(MoreMoneyActivity.this, BoughtPopcorn.class);
//                    startActivity(intent);
            }
        });

        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("your_prefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor =sp.edit();
                    int temp = ((sp.getInt("your_int_key",Activity.MODE_PRIVATE)+250));
                    editor.putInt("your_int_key",temp);
                    editor.commit();
                    String temps= Integer.toString(sp.getInt("your_int_key",Activity.MODE_PRIVATE));
                    edit=(TextView) findViewById(R.id.coins);
                    edit.setText(temps);
//                    Intent intent = new Intent(MoreMoneyActivity.this, BoughtHotdog.class);
//                    startActivity(intent);
            }
        });

    }
}
