package com.example.katsa.myapplication;

import java.util.Random;

public class RandomString {
    public static final String DATA = "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static Random random = new Random();

    public RandomString(){

    }

    public String RandomString(int len){
        StringBuilder sb = new StringBuilder(len);
        for(int i=0;i<len;i++){
            sb.append(DATA.charAt(random.nextInt(DATA.length())));
        }
        return sb.toString();

    }
}
