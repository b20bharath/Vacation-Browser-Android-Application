package com.example.sai_bharath_kumar_bandi_project02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class CarDealers extends Activity {

    ListView lv; // Reference for ListView
    String[] deal_list; // Array of dealers list
    int posi = 0; // position of view in the gridView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_dealers);
        deal_list = null;
        lv = (ListView) findViewById(R.id.listView);

        Intent inte = getIntent(); // Called intent

        posi = inte.getIntExtra("Position",0);
        switch(posi){
            case 0:
                deal_list = getResources().getStringArray(R.array.list0);
                break;
            case 1:
                deal_list = getResources().getStringArray(R.array.list1);
                break;
            case 2:
                deal_list = getResources().getStringArray(R.array.list2);
                break;
            case 3:
                deal_list = getResources().getStringArray(R.array.list3);
                break;
            case 4:
                deal_list = getResources().getStringArray(R.array.list4);
                break;
            case 5:
                deal_list = getResources().getStringArray(R.array.list5);
                break;
            case 6:
                deal_list = getResources().getStringArray(R.array.list6);
                break;
            case 7:
                deal_list = getResources().getStringArray(R.array.list7);
                break;
            default:
                break;
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(CarDealers.this,R.layout.list_text,deal_list); // Creating the Array Adapter with the appropriate dealers list

        lv.setAdapter(arrayAdapter);
    }
}