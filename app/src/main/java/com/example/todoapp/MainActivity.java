package com.example.todoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    //Deklarasi variabel untuk button
    Button btnLogin;

    //Deklarasi variabel untuk EditText
    EditText edemail,edpassword;

    //Deklarasi untuk menyimpan email dan password
    String nama, password;

    TextView Register;

    String validasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variabel btnLogin dengan component button
        btnLogin = findViewById(R.id.btSignIn);
        //Menghubungkan variabel edemail dengan componen button
        edemail = findViewById(R.id.edEmail);
        //Menghubungkan variabel passsword dengan componen button
        edpassword = findViewById(R.id.edPassword);

        Register = findViewById(R.id.tRegis);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),RegisterMain.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validasi();
            }
        });
    }


    public void validasi(){
                //menyimpan input user
                nama = edemail.getText().toString();
                password=edpassword.getText().toString();

                String email="erda@mail.com";
                String pass ="123";


                if(nama.isEmpty() && password.isEmpty()){
                    Toast t = Toast.makeText(getApplicationContext(),
                    "Username dan Password Diperlukan",
                            Toast.LENGTH_LONG);
                    t.show();
                }
                else{
                    if (nama.equals(email) && password.equals(pass)) {
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Sukses",
                                Toast.LENGTH_LONG);
                        t.show();

                        //membuat objek bundle
                        Bundle b = new Bundle();
                        b.putString("a", nama.trim());
                        b.putString("b", password.trim());



                    }else{
                        Toast t = Toast.makeText(getApplicationContext(),
                               "Login Gagal", Toast.LENGTH_LONG);
                        //menampilkan toast
                        t.show();
                    }

            }
        };
    }

