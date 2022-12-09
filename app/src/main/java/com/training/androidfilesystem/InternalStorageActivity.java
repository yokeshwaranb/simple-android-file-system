package com.training.androidfilesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InternalStorageActivity extends AppCompatActivity {

    EditText etFileName;
    EditText etMessage;
    Button btnSaveFile;
    Button btnDisplayActivity;
    Button btnShowInternalStoragePath;
    TextView tvInternalStoragePath;
    Button btnShowFiles;
    TextView tvNameOfFiles;
    EditText etDeleteFileName;
    Button btnDeleteFile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);

        etFileName = findViewById(R.id.etFileName);
        etMessage = findViewById(R.id.etMessage);
        btnSaveFile = findViewById(R.id.btnSaveFile);
        btnDisplayActivity = findViewById(R.id.btnDisplayActivity);
        btnShowInternalStoragePath = findViewById(R.id.btnShowInternalStoragePath);
        tvInternalStoragePath = findViewById(R.id.tvInternalStoragePath);
        btnShowFiles = findViewById(R.id.btnShowFiles);
        tvNameOfFiles = findViewById(R.id.tvNameOfFiles);
        etDeleteFileName = findViewById(R.id.etDeleteFileName);
        btnDeleteFile = findViewById(R.id.btnDeleteFile);

        btnSaveFile.setOnClickListener(v -> saveFile());
        btnDisplayActivity.setOnClickListener(v -> openInternalStorageDisplay());
        btnShowInternalStoragePath.setOnClickListener(v -> showInternalStoragePath());
        btnShowFiles.setOnClickListener(v -> showFiles());
        btnDeleteFile.setOnClickListener(v -> deleteInternalFile());
    }

    private void saveFile() {
    }

    private void openInternalStorageDisplay() {
        Intent intent = new Intent(this, DisplayInternalStorageActivity.class);
        startActivity(intent);
    }

    private void showInternalStoragePath() {
    }

    private void showFiles() {
    }

    private void deleteInternalFile() {
    }
}