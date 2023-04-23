package com.shopnow.timestyle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.shopnow.timestyle.adapters.ProductAdapter;
import com.shopnow.timestyle.models.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Product> mostPopularProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mostPopularProducts = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            mostPopularProducts.add(new Product("Lorem ipsum", 600, R.drawable.product_item));
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.mostPopularView);
        ProductAdapter productAdapter = new ProductAdapter(this, mostPopularProducts);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(productAdapter);
    }
}