package com.novanto.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MoveWithObjectAct extends AppCompatActivity {
    public static final String EXTRA_PERSON = "extra_person";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);


        TextView tvObject = findViewById(R.id.tv_object_recieved);

        ArrayList<Person> person = getIntent().getParcelableArrayListExtra(EXTRA_PERSON); //mengumpulkan data intent dari MainActivity
        StringBuffer sb = new StringBuffer(); // membuat object stringbuffer bernama sb untuk menyatukan string

        for (int i=0; i<person.size();i++) {
            String str[] = new String[person.size()]; //membuat object string
            Person x = person.get(i); //membuat variabel x bertipe Person
            str[i] = "\nNama : " + x.getName() + "\nAge: " + x.getAge() + "\nCity : " + x.getEmail() + "\n Iterasi : " + i; // mengambil data dari setiap objek person
            sb.append(str[i]); // memasukkan string ke dalam objeck stringbuffer
            sb.append("\n"); // membuat spasi
        }

        String str = sb.toString(); // membuat variabel str bertipe string dan dimasukkan nilai objek sb yang dikonversi menjadi string dengan method tostring
        tvObject.setText(str); // memasukkan nilai str ke dalam textview dengan method settext

    }
}
