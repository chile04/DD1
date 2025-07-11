package com.example.lethilinhchi_2122110399;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProductsActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> finish());

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.nav_products);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                startActivity(new Intent(ProductsActivity.this, HomeActivity.class));
                return true;

            } else if (id == R.id.nav_products) {
                return true;

            } else if (id == R.id.nav_cart) {
                startActivity(new Intent(ProductsActivity.this, CartActivity.class));
                return true;

            } else if (id == R.id.nav_info) {
                startActivity(new Intent(ProductsActivity.this, InfoActivity.class));
                return true;
            }

            return false;
        });
    }
}
