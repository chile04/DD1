package com.example.lethilinhchi_2122110399;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    LinearLayout layoutLogin, layoutRegister;
    TextView tvGoToLogin, tvGoToRegister;
    Button btnRegister, btnLogin;
    EditText etRegisterUsername, etRegisterPassword, etLoginUsername, etLoginPassword;

    // Biến lưu tài khoản đăng ký
    String registeredUsername = null;
    String registeredPassword = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Ẩn ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        setContentView(R.layout.activity_main);

        // Ánh xạ View
        layoutLogin = findViewById(R.id.layout_login);
        layoutRegister = findViewById(R.id.layout_register);
        tvGoToLogin = findViewById(R.id.tvGoToLogin);
        tvGoToRegister = findViewById(R.id.tvGoToRegister);
        btnRegister = findViewById(R.id.btnRegister);
        btnLogin = findViewById(R.id.btnLogin);
        etRegisterUsername = findViewById(R.id.etRegisterUsername);
        etRegisterPassword = findViewById(R.id.etRegisterPassword);
        etLoginUsername = findViewById(R.id.etLoginUsername);
        etLoginPassword = findViewById(R.id.etLoginPassword);

        // Chuyển từ Đăng ký sang Đăng nhập
        tvGoToLogin.setOnClickListener(v -> {
            layoutRegister.setVisibility(View.GONE);
            layoutLogin.setVisibility(View.VISIBLE);
        });

        // Chuyển từ Đăng nhập sang Đăng ký
        tvGoToRegister.setOnClickListener(v -> {
            layoutLogin.setVisibility(View.GONE);
            layoutRegister.setVisibility(View.VISIBLE);
        });

        // Xử lý Đăng ký
        btnRegister.setOnClickListener(v -> {
            String username = etRegisterUsername.getText().toString().trim();
            String password = etRegisterPassword.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin đăng ký", Toast.LENGTH_SHORT).show();
                return;
            }

            registeredUsername = username;
            registeredPassword = password;

            Toast.makeText(this, "Đăng ký thành công! Vui lòng đăng nhập.", Toast.LENGTH_SHORT).show();
            layoutRegister.setVisibility(View.GONE);
            layoutLogin.setVisibility(View.VISIBLE);
        });

        // Xử lý Đăng nhập
        btnLogin.setOnClickListener(v -> {
            String username = etLoginUsername.getText().toString().trim();
            String password = etLoginPassword.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin đăng nhập", Toast.LENGTH_SHORT).show();
                return;
            }

            if (registeredUsername == null || registeredPassword == null) {
                Toast.makeText(this, "Chưa có tài khoản đăng ký!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (username.equals(registeredUsername) && password.equals(registeredPassword)) {
                Toast.makeText(this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Sai tài khoản hoặc mật khẩu!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
