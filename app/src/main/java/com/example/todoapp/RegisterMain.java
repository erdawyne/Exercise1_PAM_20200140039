package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RegisterMain extends AppCompatActivity {
    //Deklarasi Button Register
    Button btnRegiss;
    //Deklarasi untuk edit teks di layout register
    EditText etNama, etEmail, etPass, etPassw;
    //Deklarasi untuk menyimpan Nama, Email, Password, Re-Password
    String nama, email, password, repassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_main);

        //Menghubungkan seluruh variabel ke komponen register

        btnRegiss = findViewById(R.id.btnRegis);
        etNama = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);
        etPassw = findViewById(R.id.etPassw);

        btnRegiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama=etNama.getText().toString();

                if(etNama.getText().toString().length()==0){
                    etNama.setError("Nama tidak boleh kosong");
                } else if (etEmail.getText().toString().length() == 0) {
                    etEmail.setError("Email tidak boleh kosong");
                } else if (etPass.getText().toString().length() ==0){
                    etPass.setError("Password tidak boleh kosong");
                } else if (etPassw.getText().toString().isEmpty()
                        || etPassw.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Data Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }
                else {
                    if (etPass.getText().toString().equals(etPassw.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Register Berhasil", Toast.LENGTH_SHORT).show();
                        Bundle b = new Bundle();

                        b.putString("Q",nama.trim());
                        Intent in = new Intent(getApplicationContext(),Task.class);
                        in.putExtras(b);
                        startActivity(in);
                    }
                    else {Toast.makeText(getApplicationContext(),"Password Salah",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}


