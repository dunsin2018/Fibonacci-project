package com.ljuv.fibonacciapp;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class SharedPref
{



    public static void StoreFuzzListInSharedPref(Context ac,ArrayList<String> fuzzList,String key)
    {
        SharedPreferences sharedPreferences = ac.getSharedPreferences("FuzzList", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(fuzzList);
        editor.putString(key, json);
        editor.apply();
    }
    public static ArrayList<String> getFuzzListFromSharedPref(Context ac,String key)
    {

        SharedPreferences sharedPreferences = ac.getSharedPreferences("FuzzList",  Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(key, null);
        if(json==null)
            return null;
        Type type = new TypeToken<ArrayList<String >>() {}.getType();
        ArrayList<String> fuzzlist = gson.fromJson(json, type);
        return fuzzlist;

    }

}
