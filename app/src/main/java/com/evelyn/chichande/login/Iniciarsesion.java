package com.evelyn.chichande.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Iniciarsesion extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText correo1;
    private EditText contrasena1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciarsesion);

        mAuth = FirebaseAuth.getInstance();
        correo1 = findViewById(R.id.correo1);
        contrasena1 = findViewById(R.id.contrasena1);
    }

    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    public void iniciarSesion(View view) {
        mAuth.signInWithEmailAndPassword(correo1.getText().toString(), contrasena1.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Autenticacion es correcta", Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(getApplicationContext(), "Autentication fallida.", Toast.LENGTH_SHORT).show();
                            //updateUI(null)
                        }
                    }
                });
    }
}