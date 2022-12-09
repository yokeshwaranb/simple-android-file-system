package com.training.androidfilesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayInternalStorageActivity extends AppCompatActivity {

    EditText etDisplayFileName;
    Button btnShowContent;
    TextView tvFileContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_internal_storage);

        etDisplayFileName = findViewById(R.id.etDisplayFileName);
        btnShowContent = findViewById(R.id.btnShowContent);
        tvFileContent = findViewById(R.id.tvFileContent);

        btnShowContent.setOnClickListener(v -> showContent());
    }

    private void showContent() {
    }
}