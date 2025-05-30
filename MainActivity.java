package com.example.lethilinhchi_2122110399;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout layoutLogin, layoutRegister;
    TextView tvGoToLogin, tvGoToRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutLogin = findViewById(R.id.layout_login);
        layoutRegister = findViewById(R.id.layout_register);
        tvGoToLogin = findViewById(R.id.tvGoToLogin);
        tvGoToRegister = findViewById(R.id.tvGoToRegister);

        tvGoToLogin.setOnClickListener(v -> {
            layoutRegister.setVisibility(View.GONE);
            layoutLogin.setVisibility(View.VISIBLE);
        });

        tvGoToRegister.setOnClickListener(v -> {
            layoutLogin.setVisibility(View.GONE);
            layoutRegister.setVisibility(View.VISIBLE);
        });
        Button btn =findViewById(R.id.btnLogin);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it= new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(it);
            }
        });
    }
}
