package com.example.todoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Task extends AppCompatActivity {
    //deklarasi edit teks variabel task
    EditText ettNama, ettJenis, ettWaktu;
    String namatask, jenistask, waktutask;
    FloatingActionButton fab;
    Menu mnSubmit, mnLogout;
    TextView nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        //menghubungkan task
        ettNama = findViewById(R.id.ettNama);
        ettJenis = findViewById(R.id.ettJenis);
        ettWaktu = findViewById(R.id.ettWaktu);

        fab = findViewById(R.id.faTambah);

        nama = findViewById(R.id.tnamaku);

        Bundle b = getIntent().getExtras();
        namatask = b.getString("Q");
        nama.setText(namatask);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                namatask = ettNama.getText().toString();
                jenistask = ettJenis.getText().toString();
                waktutask = ettWaktu.getText().toString();

                if (jenistask.length() == 0) {
                    ettJenis.setError("Jenis Task");
                    Toast.makeText(getApplicationContext(), "Isi Semua Data", Toast.LENGTH_SHORT).show();
                } else if (waktutask.length() == 0) {
                    ettWaktu.setError("Waktu Task");
                    Toast.makeText(getApplicationContext(), "Isi semua data", Toast.LENGTH_SHORT).show();
                } else if (namatask.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Isi Semua data", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_SHORT).show();

                    Bundle b = new Bundle();

                    b.putString("namatask", namatask.trim());
                    b.putString("jenistask", jenistask.trim());
                    b.putString("waktutask", waktutask.trim());

                    Intent in = new Intent(getApplicationContext(), hasil.class);
                    in.putExtras(b);
                    startActivity(in);
                }
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnSubmit) {
            namatask = ettNama.getText().toString();
            jenistask = ettJenis.getText().toString();
            waktutask = ettWaktu.getText().toString();

            if (namatask.length() == 0) {
                ettJenis.setError("Jenis Task");
                Toast.makeText(getApplicationContext(), "Isi Semua Data", Toast.LENGTH_SHORT).show();

            } else if (waktutask.length() == 0) {
                ettWaktu.setError("Waktu Task");
                Toast.makeText(getApplicationContext(), "Isi Semua Data", Toast.LENGTH_SHORT).show();
            } else if (namatask.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Ise Semua Data", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_SHORT).show();

                Bundle b = new Bundle();

                b.putString("namatask", namatask.trim());
                b.putString("jenistask", jenistask.trim());
                b.putString("waktutask", waktutask.trim());

                Intent in = new Intent(getApplicationContext(), hasil.class);

                in.putExtras(b);
                startActivity(in);
            }
        } else {
            Intent in = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(in);
        }
        return super.onOptionsItemSelected(item);
    }
}













