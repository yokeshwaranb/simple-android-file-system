package com.training.androidfilesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnInternalStorage;
    Button btnCacheStorage;
    Button btnExternalStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInternalStorage = findViewById(R.id.btnInternalStorage);
        btnCacheStorage = findViewById(R.id.btnCacheStorage);
        btnExternalStorage = findViewById(R.id.btnExternalStorage);

        btnInternalStorage.setOnClickListener(v -> launchInternalStorageActivity());
        btnCacheStorage.setOnClickListener(v -> launchCacheStorageActivity());
        btnExternalStorage.setOnClickListener(v -> launchExternalStorageActivity());
    }

    private void launchInternalStorageActivity() {
        Intent intent = new Intent(this, InternalStorageActivity.class);
        startActivity(intent);
    }

    private void launchCacheStorageActivity() {

    }

    private void launchExternalStorageActivity() {

    }
}