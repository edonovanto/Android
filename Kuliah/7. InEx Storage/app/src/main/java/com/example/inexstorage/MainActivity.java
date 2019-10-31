package com.example.inexstorage;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText editContent;
    TextView textContent;
    Button btnCreate, btnEdit, btnRead, btnDelete;
    public static final String FILENAME = "example.txt";
    public static final int REQUEST_CODE_STORAGE = 100;
    public int selectEvent =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editContent = findViewById(R.id.editContent);
        textContent = findViewById(R.id.textContent);
        btnCreate = findViewById(R.id.btnCreate);
        btnEdit = findViewById(R.id.btnEdit);
        btnRead = findViewById(R.id.btnRead);
        btnDelete = findViewById(R.id.btnDelete);

        btnCreate.setOnClickListener(this);
        btnEdit.setOnClickListener(this);
        btnRead.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnCreate:
            case R.id.btnEdit:
            case R.id.btnRead:
            case R.id.btnDelete:
                if(checkStoragePermission()){
                    //cek permission ketika
                    selectEvent = v.getId();
                    doTask(selectEvent);
                }
                break;
        }
    }

    private void doTask(int id) {
        switch (id) {
            case R.id.btnCreate:
                createFile();
                break;
            case R.id.btnEdit:
                editFile();
                break;
            case R.id.btnRead:
                readFile();
                break;
            case R.id.btnDelete:
                removeFile();
                break;
        }
    }

    private void removeFile() {
        String path = Environment.getExternalStorageDirectory().toString()+ "/PAPB";
        File file = new File(path);

        if(file.exists()){
            file.delete();
        }
        else{
            Toast.makeText(MainActivity.this, "Tidak Ada File", Toast.LENGTH_SHORT).show();
        }

    }

    private void readFile() {
        String path = Environment.getExternalStorageDirectory().toString()+ "/PAPB";
        File file = new File(path);

        if(file.exists()){
            StringBuilder text = new StringBuilder();

            try{
                BufferedReader br = new BufferedReader(new FileReader(file));

                String line = br.readLine();

                while(line != null){
                    text.append(line);
                    line = br.readLine();
                }
                br.close();
            }
            catch (FileNotFoundException e){
                e.printStackTrace();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            textContent.setText(text.toString());
        }
        else{
            Toast.makeText(MainActivity.this, "Tidak Ada File", Toast.LENGTH_SHORT).show();
        }
    }

    private void editFile() {
        String content = editContent.getText().toString();
        String path = Environment.getExternalStorageDirectory().toString()+ "/PAPB";
        File parent = new File(path);

        if(parent.exists()){
            //buat file
            File file = new File(path, FILENAME);
            FileOutputStream outputStream = null;
            try{
                file.createNewFile();
                outputStream = new FileOutputStream(file);
                outputStream.write(content.getBytes());
                outputStream.close();
            }
            catch (FileNotFoundException e){
                e.printStackTrace();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        else {
            Toast.makeText(MainActivity.this, "Tidak Ada File", Toast.LENGTH_SHORT).show();
        }
    }

    private void createFile() {
        String content = editContent.getText().toString();

        String path = Environment.getExternalStorageDirectory().toString()+ "/PAPB";
        File parent = new File(path);
        if(parent.exists()){
            //buat file
            File file = new File(path, FILENAME);
            FileOutputStream outputStream = null;
            try{
                file.createNewFile();
                outputStream = new FileOutputStream(file);
                outputStream.write(content.getBytes());
                outputStream.close();
            }
            catch (FileNotFoundException e){
                e.printStackTrace();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        else {
            parent.mkdir();
            File file = new File(path, FILENAME);
            FileOutputStream outputStream = null;
            try{
                file.createNewFile();
                outputStream = new FileOutputStream(file);
                outputStream.write(content.getBytes());
                outputStream.close();
            }
            catch (FileNotFoundException e){
                e.printStackTrace();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        super.onRequestPermissionsResult(requestCode, permissions,grantResults);
        switch (requestCode){
            case REQUEST_CODE_STORAGE:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    //JALANKAN
                    doTask(selectEvent);
                }
                else{
                    //ERROR
                    Toast.makeText(MainActivity.this, "Izin Belum Diberikan", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public boolean checkStoragePermission(){
        if(Build.VERSION.SDK_INT >= 23){
            if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED){
                return true;
            }
            else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},REQUEST_CODE_STORAGE);
                return false;
            }
        }
        else{
            return true;
        }
    }

//    public void createFile (View view) {
//        String content = editContent.getText().toString();
//
//        File file = new File (getFilesDir(), FILENAME);
//
//        FileOutputStream fileOutputStream = null;
//        try{
//            file.createNewFile();
//            fileOutputStream = new FileOutputStream(file, true);
//            fileOutputStream.write (content.getBytes());
//
//        }catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//
//    }
//
//    public void editFile (View view) {
//        String content = editContent.getText().toString();
//
//        File file = new File (getFilesDir(), FILENAME);
//
//        FileOutputStream fileOutputStream = null;
//        try{
//            file.createNewFile();
//            fileOutputStream = new FileOutputStream(file, false);
//            fileOutputStream.write (content.getBytes());
//
//        }catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//
//    }
//
//    public void readFile (View view) {
//        String content = editContent.getText().toString();
//
//        File file = new File (getFilesDir(), FILENAME);
//
//        if (file.exists()) {
//            StringBuilder text = new StringBuilder();
//
//            try{
//                BufferedReader br = new BufferedReader(new FileReader(file));
//
//                String line = br.readLine();
//
//                while(line != null){
//                    text.append(line);
//                    line = br.readLine();
//                }
//                br.close();
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            textContent.setText(text.toString());
//        }else{
//            textContent.setText("File not exist");
//        }
//
//    }
//
//    public void deleteFile (View view) {
//        File file = new File (getFilesDir(), FILENAME);
//
//        if (file.exists()) {
//            file.delete();
//        }else{
//            textContent.setText("File not exist");
//        }
//
//    }
}
