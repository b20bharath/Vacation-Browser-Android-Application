package com.example.sai_bharath_kumar_bandi_project02;



import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity {

    private GridView gridview; // Declaring the gridView

    static String[] links; // array of URLs of the websites for all the cars
    static String[] image_names = null;
    // Getting images from the res folder and storing in an integer Array List
    static ArrayList<Integer> images_full= new ArrayList<>(Arrays.asList(R.drawable.audi_etron,R.drawable.bmw_i8,R.drawable.bugatti_veyron,R.drawable.ferrari_458,R.drawable.koenigsegg_jesko,R.drawable.lamborghini_aventador,R.drawable.range_rover_velar,R.drawable.tesla_x));
    // Getting image thumbnails from the res folder and storing in an integer Array List
    static ArrayList<Integer> images= new ArrayList<>(Arrays.asList(R.drawable.audi_etron_thumbnail,R.drawable.bmw_i8_thumbnail,R.drawable.bugatti_veyron_thumbnail,R.drawable.ferrari_458_thumnail,R.drawable.koenigsegg_jesko_thumbnail,R.drawable.lamborghini_aventador_thumbnail,R.drawable.range_rover_velar_thumbnail,R.drawable.tesla_x_thumbnail));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        links = null;
        gridview = findViewById(R.id.grid_view); // Grid view Reference from the layout
        image_names = getResources().getStringArray(R.array.carName); // Image names from the strings.xml file stored in a String Array

        links = getResources().getStringArray(R.array.links);


        gridview.setAdapter(new myAdapter(images,getApplicationContext())); // creating a custom adapter myAdapter and Assigned

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) { // Action to be taken on each item click
                Intent intent = new Intent(getApplicationContext(),ImageViewFull.class);
                intent.putExtra("link",links[i]);
                intent.putExtra("Position",i);

                startActivity(intent);

            }
        });

        registerForContextMenu(gridview); // registering the gridview for Context Menu

    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) { // creating the context menu with Menu Inflator
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) { // Action to be taken on each item click


        AdapterView.AdapterContextMenuInfo menu_info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()){
            case R.id.fullimage: // viewing full image
                Intent intent_mini = new Intent(getApplicationContext(),ImageViewFull.class);
                intent_mini.putExtra("Position",menu_info.position);
                intent_mini.putExtra("link",links[menu_info.position]);
                startActivity(intent_mini);
                break;
            case R.id.webpage: // open the website of the car
                Intent intent_web = new Intent(Intent.ACTION_VIEW);
                intent_web.setData(Uri.parse(links[menu_info.position]));
                intent_web.addCategory(Intent.CATEGORY_BROWSABLE);
                startActivity(intent_web);
                break;


            case R.id.dealers:// displaying three dealers for each car
                Intent intent_dealer = new Intent(getApplicationContext(),CarDealers.class);
                intent_dealer.putExtra("Position",menu_info.position);
                startActivity(intent_dealer);
                break;
            default:
                return super.onContextItemSelected(item);
        }
        return super.onContextItemSelected(item);
    }
}

