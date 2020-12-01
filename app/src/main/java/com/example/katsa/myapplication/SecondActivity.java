package com.example.katsa.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    private ShakeDetector mShakeDetector;
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    TextView edit;


    private void shakeIt()
    {
        if (Build.VERSION.SDK_INT >= 26) {
            ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(VibrationEffect.createOneShot(150,10));

        } else {
            ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(150);
        }
    }
    Button button;
    TextView textView;
    ImageView roulette;

    Random r;
    int degree = 0;
    int degree_old = 0;

    private static final float FACTOR = 45f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        roulette = (ImageView) findViewById(R.id.roulette);

        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
        String temp = Integer.toString(sp.getInt("your_int_key",Activity.MODE_PRIVATE));
        edit=(TextView) findViewById(R.id.coins2);
        edit.setText(temp);

        r = new Random();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getSharedPreferences("your_prefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                if (sp.getInt("your_int_key", Activity.MODE_PRIVATE) <= 0) {
                    Intent intent = new Intent(SecondActivity.this, MoreMoneyActivity.class);
                    startActivity(intent);
                } else {
                    // Vibrate for 150 milliseconds
                    shakeIt();
                    degree_old = degree % 360;
                    degree = r.nextInt(3600) + 720;
                    RotateAnimation rotate = new RotateAnimation(degree_old, degree, RotateAnimation.RELATIVE_TO_SELF,
                            0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                    rotate.setDuration(3600);
                    rotate.setFillAfter(true);
                    rotate.setInterpolator(new DecelerateInterpolator());
                    rotate.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            textView.setText("");
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            //textView.setText(currentNumber(360-(degree % 360)));
                            int box;
                            box = currentNumber(360 - (degree % 360));
                            if(box==10)
                            {
                                Intent intent = new Intent(SecondActivity.this, Pop3Activity.class);
                                startActivity(intent);
                            }
                            else if(box>10)
                            {
                                if(box==20)
                                {
                                    Intent intent = new Intent(SecondActivity.this, PopActivity.class);
                                    startActivity(intent);
                                }
                                else
                                {
                                    Intent intent = new Intent(SecondActivity.this, Pop2Activity.class);
                                    startActivity(intent);
                                }
                            }
                            else
                            {
                                if(box==0)
                                {
                                    Intent intent = new Intent(SecondActivity.this, Pop4Activity.class);
                                    startActivity(intent);
                                }
                                else if(box==-10)
                                {
                                    Intent intent = new Intent(SecondActivity.this, Pop5Activity.class);
                                    startActivity(intent);
                                }
                                else
                                {
                                    Intent intent = new Intent(SecondActivity.this, Pop6Activity.class);
                                    startActivity(intent);
                                }
                            }

                        }
                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }

                    });
                    roulette.startAnimation(rotate);
                }
            }

        });

        roulette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getSharedPreferences("your_prefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                if (sp.getInt("your_int_key", Activity.MODE_PRIVATE) <= 0) {
                    Intent intent = new Intent(SecondActivity.this, MoreMoneyActivity.class);
                    startActivity(intent);
                } else {
                    shakeIt();
                    degree_old = degree % 360;
                    degree = r.nextInt(3600) + 720;
                    RotateAnimation rotate = new RotateAnimation(degree_old, degree, RotateAnimation.RELATIVE_TO_SELF,
                            0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                    rotate.setDuration(3600);
                    rotate.setFillAfter(true);
                    rotate.setInterpolator(new DecelerateInterpolator());
                    rotate.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            textView.setText("");
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            //textView.setText(currentNumber(360-(degree % 360)));
                            int box;
                            box=currentNumber(360-(degree % 360));
                            if(box==10)
                            {
                                Intent intent = new Intent(SecondActivity.this, Pop3Activity.class);
                                startActivity(intent);
                            }
                            else if(box>10)
                            {
                                if(box==20)
                                {
                                    Intent intent = new Intent(SecondActivity.this, PopActivity.class);
                                    startActivity(intent);
                                }
                                else
                                {
                                    Intent intent = new Intent(SecondActivity.this, Pop2Activity.class);
                                    startActivity(intent);
                                }
                            }
                            else
                            {
                                if(box==0)
                                {
                                    Intent intent = new Intent(SecondActivity.this, Pop4Activity.class);
                                    startActivity(intent);
                                }
                                else if(box==-10)
                                {
                                    Intent intent = new Intent(SecondActivity.this, Pop5Activity.class);
                                    startActivity(intent);
                                }
                                else
                                {
                                    Intent intent = new Intent(SecondActivity.this, Pop6Activity.class);
                                    startActivity(intent);
                                }
                            }

                        }
                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }

                    });
                    roulette.startAnimation(rotate);
                }
            }
        });

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector(new ShakeDetector.OnShakeListener() {
            @Override
            public void onShake() {
                shakeIt();
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SharedPreferences sp = getSharedPreferences("your_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();
                        if (sp.getInt("your_int_key", Activity.MODE_PRIVATE) <= 0) {
                            Intent intent = new Intent(SecondActivity.this, MoreMoneyActivity.class);
                            startActivity(intent);
                        } else {
                            shakeIt();
                            degree_old = degree % 360;
                            degree = r.nextInt(3600) + 720;
                            RotateAnimation rotate = new RotateAnimation(degree_old, degree, RotateAnimation.RELATIVE_TO_SELF,
                                    0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                            rotate.setDuration(3600);
                            rotate.setFillAfter(true);
                            rotate.setInterpolator(new DecelerateInterpolator());
                            rotate.setAnimationListener(new Animation.AnimationListener() {
                                @Override
                                public void onAnimationStart(Animation animation) {
                                    textView.setText("");
                                }

                                @Override
                                public void onAnimationEnd(Animation animation) {
                                    //textView.setText(currentNumber(360-(degree % 360)));
                                    int box;
                                    box=currentNumber(360-(degree % 360));
                                    if(box==10)
                                    {
                                        Intent intent = new Intent(SecondActivity.this, Pop3Activity.class);
                                        startActivity(intent);
                                    }
                                    else if(box>10)
                                    {
                                        if(box==20)
                                        {
                                            Intent intent = new Intent(SecondActivity.this, PopActivity.class);
                                            startActivity(intent);
                                        }
                                        else
                                        {
                                            Intent intent = new Intent(SecondActivity.this, Pop2Activity.class);
                                            startActivity(intent);
                                        }
                                    }
                                    else
                                    {
                                        if(box==0)
                                        {
                                            Intent intent = new Intent(SecondActivity.this, Pop4Activity.class);
                                            startActivity(intent);
                                        }
                                        else if(box==-10)
                                        {
                                            Intent intent = new Intent(SecondActivity.this, Pop5Activity.class);
                                            startActivity(intent);
                                        }
                                        else
                                        {
                                            Intent intent = new Intent(SecondActivity.this, Pop6Activity.class);
                                            startActivity(intent);
                                        }
                                    }

                                }
                                @Override
                                public void onAnimationRepeat(Animation animation) {

                                }

                            });
                            roulette.startAnimation(rotate);
                        }
                    }


                });
            }
        });

//        @Override
//        protected void onResume() {
//            super.onResume();
//            mSensorManager.registerListener(mShakeDetector, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
//            // Registers (mShakeDetector which implements) SensorEventListener
//        }
//
//        @Override
//        protected void onPause() {
//            mSensorManager.unregisterListener(mShakeDetector);
//            super.onPause();
//        }
    }

    private int currentNumber(int degrees) {

        int result = -10 ;

        if(degrees >0 && degrees <=45)//(FACTOR * 1) && degrees < (FACTOR * 3))
        {

            result += -20;

        }
        else if(degrees >45 && degrees <=90)//(degrees >= (FACTOR * 3) && degrees < (FACTOR * 5))
        {

            result += 20;
        }
        else if(degrees >90 && degrees <=135)//(degrees >= (FACTOR * 5) && degrees < (FACTOR * 7))
        {

            result += 10;
        }
        else if(degrees >135 && degrees <=180)//(degrees >= (FACTOR * 7) && degrees < (FACTOR * 9))
        {

            result += 40;
        }
        else if(degrees >180 && degrees <=225)//(degrees >= (FACTOR * 9) && degrees < (FACTOR * 11))
        {

            result += 0;
        }
        else if(degrees >225 && degrees <=270)//(degrees >= (FACTOR * 11) && degrees < (FACTOR * 13))
        {

            result += 20;
        }
        else if(degrees >270 && degrees <=315)//(degrees >= (FACTOR * 13) && degrees < (FACTOR * 15))
        {

            result += -10;
        }
        else if(degrees >315 && degrees <=360)//(degrees >= (FACTOR * 15) && degrees < (FACTOR * 17))
        {

            result += 20;
        }
        else if(degrees == 0)//(degrees >= (FACTOR * 17) && degrees < 360 || (degrees >= 0 && degrees < FACTOR * 1))
        {

            result += 0;
        }

        SharedPreferences sp = getSharedPreferences("your_prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =sp.edit();
        int temp1 = sp.getInt("your_int_key",Activity.MODE_PRIVATE) + result;
        editor.putInt("your_int_key",temp1);
        editor.commit();
        String temp = Integer.toString(sp.getInt("your_int_key",Activity.MODE_PRIVATE));
        edit= (TextView) findViewById(R.id.coins2);
        edit.setText(temp);



        return result;
    }

}
