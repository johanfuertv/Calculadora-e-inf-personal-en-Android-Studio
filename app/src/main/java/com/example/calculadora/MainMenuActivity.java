package com.example.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainMenuActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_AGREGAR_USUARIO = 1;
    private ArrayList<Usuario> listaUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        // Obtener la lista de usuarios (si no existe)
        if (getIntent().hasExtra("listaUsuarios")) {
            listaUsuarios = (ArrayList<Usuario>) getIntent().getSerializableExtra("listaUsuarios");
        } else {
            listaUsuarios = new ArrayList<>(); // Crear una nueva lista si no hay datos
        }

        // Botón para la Calculadora
        Button btnCalculadora = findViewById(R.id.btnCalculadora);
        btnCalculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Botón para Agregar Usuario
        Button btnAgregarUsuario = findViewById(R.id.btnAgregarUsuario);
        btnAgregarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, AgregarUsuarioActivity.class);
                intent.putExtra("listaUsuarios", listaUsuarios);
                startActivityForResult(intent, REQUEST_CODE_AGREGAR_USUARIO);
            }
        });
    }

    // Recibir la lista actualizada desde AgregarUsuarioActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_AGREGAR_USUARIO && resultCode == RESULT_OK) {
            if (data != null && data.hasExtra("listaUsuarios")) {
                listaUsuarios = (ArrayList<Usuario>) data.getSerializableExtra("listaUsuarios");
            }
        }
    }
}
