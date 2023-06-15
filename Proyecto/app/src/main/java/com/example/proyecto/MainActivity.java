package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText email, contrasena;
    Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.etEmaiLogin);
        contrasena = findViewById(R.id.etContrasenaLogin);
        if (getIntent().hasExtra("usuarios")) {
            user = (Usuario) getIntent().getSerializableExtra("usuarios");
        } else {
           user = new Usuario();
        }
    }

    public void btnIngresar(View view) {
        int bandera = 0;
        String correo = email.getText().toString();
        String password = contrasena.getText().toString();
        if(correo.equals("") && password.equals("")){
           Toast mensaje = Toast.makeText(this, "Datos no ingresados", Toast.LENGTH_LONG);
            mensaje.show();
        }else{

                if (correo.equals(user.getEmail()) && password.equals(user.getContrasena())) {
                    Intent intent = new Intent(this, MenuLateral.class);
                    startActivity(intent);
                    bandera++;
                    Toast.makeText(this, "Bienvenido "+user.getNombre(), Toast.LENGTH_SHORT).show();
                }

            if (bandera == 0) {
                Toast mensaje = Toast.makeText(this, "Usuario no registrado", Toast.LENGTH_LONG);
                mensaje.show();
            }
        }

    }

    public void registrarse(View view) {
        Intent intent = new Intent(MainActivity.this, Register_activity.class);
        intent.putExtra("usuarios", user);
        startActivity(intent);
    }
}