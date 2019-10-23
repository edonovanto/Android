package com.example.inexstorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;

public class MainActivity extends AppCompatActivity {
    EditText editContent;
    TextView textContent;
    public static final String FILENAME = "example.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editContent = findViewById(R.id.editContent);
        textContent = findViewById(R.id.textContent);
    }

    public void createFile (View view) {
        String content = editContent.getText().toString();

        File file = new File (getFilesDir(), FILENAME);

        FileOutputStream fileOutputStream = null;
        try{
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file, true);
            fileOutputStream.write (content.getBytes());

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void editFile (View view) {
        String content = editContent.getText().toString();

        File file = new File (getFilesDir(), FILENAME);

        FileOutputStream fileOutputStream = null;
        try{
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file, false);
            fileOutputStream.write (content.getBytes());

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void readFile (View view) {
        String content = editContent.getText().toString();

        File file = new File (getFilesDir(), FILENAME);

        if (file.exists()) {
            StringBuilder text = new StringBuilder();

            try{
                BufferedReader br = new BufferedReader(new FileReader(file));

                String line = br.readLine();

                while(line != null){
                    text.append(line);
                    line = br.readLine();
                }
                br.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            textContent.setText(text.toString());
        }else{
            textContent.setText("File not exist");
        }

    }

    public void deleteFile (View view) {
        File file = new File (getFilesDir(), FILENAME);

        if (file.exists()) {
            file.delete();
        }else{
            textContent.setText("File not exist");
        }

    }
}
