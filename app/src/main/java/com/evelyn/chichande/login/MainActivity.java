package com.evelyn.chichande.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void irinicio(View view){
        Intent i =new Intent(this, Iniciarsesion.class);
        startActivity(i);
    }

    public void irregistro(View view){
        Intent i =new Intent(this, Registro.class);
        startActivity(i);
    }
}