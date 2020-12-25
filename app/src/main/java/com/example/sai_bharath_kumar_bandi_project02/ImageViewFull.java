package com.example.sai_bharath_kumar_bandi_project02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class ImageViewFull extends AppCompatActivity {
    int post = 0; // position of the view in grid view
    String link = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view_full); // setting the layout

        Intent intent = getIntent();
        post = intent.getIntExtra("Position",0);
        link = intent.getStringExtra("link");
        ImageView enlarge = (ImageView) findViewById(R.id.enlarge_view); // Referencing the ImageView




        enlarge.setImageResource(MainActivity.images_full.get(post));

        enlarge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // Action to be taken when clicked on the image
                Uri link_uri = Uri.parse(link);
                Intent intent2 = new Intent(Intent.ACTION_VIEW);
                intent2.setData(link_uri);
                intent2.addCategory(Intent.CATEGORY_BROWSABLE);
                startActivity(intent2);
            }
        });

    }


}