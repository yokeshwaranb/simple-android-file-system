package com.training.androidfilesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CacheStorageActivity extends AppCompatActivity {

    private EditText etIntData;
    private Button btnSaveIntCache;
    private Button btnLoadIntCache;
    private TextView tvIntCacheContent;
    private EditText etExtData;
    private Button btnSaveExtCache;
    private Button btnLoadExtCache;
    private TextView tvExtCacheContent;
    private String INTERNAL_CACHE_STORAGE_FILE_NAME = "MyInternalCacheFile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cache_storage);

        etIntData = findViewById(R.id.etIntData);
        btnSaveIntCache = findViewById(R.id.btnSaveIntCache);
        btnLoadIntCache = findViewById(R.id.btnLoadIntCache);
        tvIntCacheContent = findViewById(R.id.tvIntCacheContent);
        etExtData = findViewById(R.id.etExtData);
        btnSaveExtCache = findViewById(R.id.btnSaveExtCache);
        btnLoadExtCache = findViewById(R.id.btnLoadExtCache);
        tvExtCacheContent = findViewById(R.id.tvExtCacheContent);

        btnSaveIntCache.setOnClickListener(v -> saveToInternalCache());
        btnLoadIntCache.setOnClickListener(v -> loadFromInternalCache());
        btnSaveExtCache.setOnClickListener(v -> saveToExternalCache());
        btnLoadExtCache.setOnClickListener(v -> loadFromExternalCache());
    }

    private void saveToInternalCache() {
        String internalCacheData = etIntData.getText().toString();

        File cacheDir = getCacheDir();
        File myCacheFile = new File(cacheDir, INTERNAL_CACHE_STORAGE_FILE_NAME);

        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(myCacheFile);
            fileOutputStream.write(internalCacheData.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void loadFromInternalCache() {
    }

    private void saveToExternalCache() {
    }

    private void loadFromExternalCache() {
    }
}