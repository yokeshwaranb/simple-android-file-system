package com.training.androidfilesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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
        String fileName = etFileName.getText().toString();
        String messageData = etMessage.getText().toString();

        FileOutputStream fileOutputStream = null;

        try {
            //Path: /data/data/{package}/files/{file_name}
            fileOutputStream = openFileOutput(fileName, MODE_APPEND);
            fileOutputStream.write(messageData.getBytes());
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