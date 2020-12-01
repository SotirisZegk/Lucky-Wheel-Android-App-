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

public class MainActivity extends AppCompatActivity {
    TextView edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
                this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar
                this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //set content view AFTER ABOVE sequence (to avoid crash)
                this.setContentView(R.layout.activity_main);
        //setContentView(R.layout.activity_main);

        initViews();

        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
        if (sp.getBoolean("my_first_time", true)) {
            SharedPreferences.Editor editor = sp.edit();
            editor.putInt("your_int_key", 100);
            editor.commit();
            sp.edit().putBoolean("my_first_time", false).commit();
        }
        String temp = Integer.toString(sp.getInt("your_int_key",Activity.MODE_PRIVATE));
        edit=(TextView) findViewById(R.id.edit);
        edit.setText(temp);
    }

    @Override
    public void onRestart() {
        super.onRestart();
        //When BACK BUTTON is pressed, the activity on the stack is restarted
        //Do what you want on the refresh procedure here
        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
        String temp = Integer.toString(sp.getInt("your_int_key",Activity.MODE_PRIVATE));
        edit=(TextView) findViewById(R.id.edit);
        edit.setText(temp);


    }

    private void initViews() {

        Button intentButton = findViewById(R.id.button);
        intentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("your_prefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor =sp.edit();
                if(sp.getInt("your_int_key",Activity.MODE_PRIVATE)>0) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(MainActivity.this, MoreMoneyActivity.class);
                    startActivity(intent);
                }
            }
        });

        Button intentButton2 = findViewById(R.id.button2);
        intentButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });

        Button hardlevelbutton = findViewById(R.id.button3);
        hardlevelbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("your_prefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor =sp.edit();
                if(sp.getInt("your_int_key",Activity.MODE_PRIVATE)>0) {
                    Intent intent = new Intent(MainActivity.this, HardLevelActivity.class);
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(MainActivity.this, MoreMoneyActivity.class);
                    startActivity(intent);
                }
            }
        });
        Button buyButton = findViewById(R.id.button4);
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, MoreMoneyActivity.class);
                    startActivity(intent);
            }
        });
    }


}