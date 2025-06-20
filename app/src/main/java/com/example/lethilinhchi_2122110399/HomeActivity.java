package com.example.lethilinhchi_2122110399;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // Setup sản phẩm
        RecyclerView recyclerProducts = findViewById(R.id.recyclerProducts);
        recyclerProducts.setLayoutManager(
                new GridLayoutManager(this, 2)); // 2 cột
        int spacingInPixels = 32; // khoảng cách giữa các sản phẩm (tuỳ chỉnh theo nhu cầu)
        recyclerProducts.addItemDecoration(new GridSpacingItemDecoration(2, spacingInPixels, true));


        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Mì Tương Đen", R.drawable.mituogden, 199000));
        productList.add(new Product("Pizza", R.drawable.pizza, 499000));
        productList.add(new Product("Steck", R.drawable.steck, 299000));
        productList.add(new Product("Sushi", R.drawable.sushi, 399000));

        ProductAdapter productAdapter = new ProductAdapter(this, productList);
        recyclerProducts.setAdapter(productAdapter);

        // Setup danh mục
        RecyclerView recyclerCategories = findViewById(R.id.recyclerCategories);
        recyclerCategories.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category("Hot Deal", R.drawable.miy));
        categoryList.add(new Category("Món Âu", R.drawable.steck));
        categoryList.add(new Category("Món Hàn", R.drawable.mituogden));
        categoryList.add(new Category("Món Nhật", R.drawable.sushi));
        categoryList.add(new Category("Món Việt", R.drawable.phobo));

        CategoryAdapter categoryAdapter = new CategoryAdapter(this, categoryList);
        recyclerCategories.setAdapter(categoryAdapter);
    }
}