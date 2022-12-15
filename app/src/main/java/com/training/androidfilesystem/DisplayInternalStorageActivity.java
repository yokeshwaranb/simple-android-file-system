package com.training.androidfilesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

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

    /**
     * This way(SRIYANK TUT) is not working getting memory error
     * */
//    private void showContent() {
//        String fileName = etDisplayFileName.getText().toString();
////        StringBuffer stringBuffer = new StringBuffer();
//        String str = new String();
//
//        FileInputStream fileInputStream = null;
//
//        try {
//            fileInputStream = openFileInput(fileName);
//
//            int read = fileInputStream.read();
//            while (read != -1) {
//                str += String.valueOf(read);
////                stringBuffer.append(read);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//          if(fileInputStream != null) {
//              try {
//                  fileInputStream.close();
//              } catch (IOException e) {
//                  e.printStackTrace();
//              }
//          }
//        }
//
////        tvFileContent.setText(stringBuffer);
//        tvFileContent.setText(str);
//    }

    private void showContent() {
        String fileName = etDisplayFileName.getText().toString();

        FileInputStream fis = null;
        try {
            //Path: /data/data/{package}/files/{file_name}
            fis = getBaseContext().openFileInput(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader inputStreamReader =
                new InputStreamReader(fis, StandardCharsets.UTF_8);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
            String line = reader.readLine();
            while (line != null) {
                stringBuilder.append(line).append('\n');
                line = reader.readLine();
            }
        } catch (IOException e) {
            // Error occurred when opening raw file for reading.
        } finally {
            String contents = stringBuilder.toString();
            tvFileContent.setText(contents);
        }
    }
}