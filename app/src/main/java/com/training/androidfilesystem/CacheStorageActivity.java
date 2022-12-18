package com.training.androidfilesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
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

        writeToFile(myCacheFile, internalCacheData);
    }

    private void loadFromInternalCache() {
        File cacheDir = getCacheDir();
        File cacheFile = new File(cacheDir, INTERNAL_CACHE_STORAGE_FILE_NAME);

        tvIntCacheContent.setText(cacheDir.toString() + "\n\n" + readFromFile(cacheFile));
    }

    private void saveToExternalCache() {
    }

    private void loadFromExternalCache() {
    }

    private void writeToFile(File file, String data) {
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(data.getBytes());
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

    private String readFromFile(File file) {
        StringBuffer stringBuffer = new StringBuffer();
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(file);

            int read;
            while ((read = fileInputStream.read()) != -1) {
                stringBuffer.append((char) read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return stringBuffer.toString();
    }
}