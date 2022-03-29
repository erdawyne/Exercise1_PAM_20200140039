package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class hasil extends AppCompatActivity {

    TextView task1,task2,task3;
    String task,jenis,waktu;
    FloatingActionButton fhasil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);
        task1 = findViewById(R.id.hTaska);
        task2 = findViewById(R.id.hTask1);
        task3 = findViewById(R.id.hTaska2);
        fhasil = findViewById(R.id.fhasil);

        Bundle b = getIntent().getExtras();

        String task = b.getString("task");
        String jenis= b.getString("jenis");
        String waktu= b.getString("Waktu");

        task1.setText(task);
        task2.setText(jenis);
        task3.setText(waktu);
    }
}