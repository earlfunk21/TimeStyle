package com.shopnow.timestyle.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.shopnow.timestyle.R;

public class ProductActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        Toolbar toolbar = findViewById(R.id.toolbar); // Attaching the layout to the toolbar object
        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_ios_new_24);
        setSupportActionBar(toolbar);

        // enabling action bar app icon and behaving it as toggle button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        TextView tv_product_name = findViewById(R.id.tv_product_name1);
        TextView tv_product_price = findViewById(R.id.tv_product_price1);
        ImageView tv_product_thumbnail = findViewById(R.id.iv_product_thumbnail1);

        Intent intent = getIntent();
        String name = intent.getExtras().getString("name");
        String price = intent.getExtras().getString("price");
        int thumbnail = intent.getExtras().getInt("thumbnail");

        tv_product_name.setText(name);
        tv_product_price.setText(price);
        tv_product_thumbnail.setImageResource(thumbnail);
    }
}