package com.example.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Random;

public class AgregarUsuarioActivity extends AppCompatActivity {

    private EditText etNombre, etApellido, etCorreo, etEdad, etContrasena, etDireccion, etCodigoBuscar;
    private Button btnGuardar, btnBuscar;
    private TextView tvCodigoGenerado, tvInformacionUsuario;
    private ArrayList<Usuario> listaUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_usuario);

        // Inicializar vistas
        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        etCorreo = findViewById(R.id.etCorreo);
        etEdad = findViewById(R.id.etEdad);
        etContrasena = findViewById(R.id.etContrasena);
        etDireccion = findViewById(R.id.etDireccion);
        etCodigoBuscar = findViewById(R.id.etCodigoBuscar);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnBuscar = findViewById(R.id.btnBuscar);
        tvCodigoGenerado = findViewById(R.id.tvCodigoGenerado);
        tvInformacionUsuario = findViewById(R.id.tvInformacionUsuario);

        // Obtener la lista de usuarios desde MainMenuActivity
        listaUsuarios = (ArrayList<Usuario>) getIntent().getSerializableExtra("listaUsuarios");
        if (listaUsuarios == null) {
            listaUsuarios = new ArrayList<>();
        }

        // Botón para guardar el usuario
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = etNombre.getText().toString();
                String apellido = etApellido.getText().toString();
                String correo = etCorreo.getText().toString();
                String edadStr = etEdad.getText().toString();
                String contrasena = etContrasena.getText().toString();
                String direccion = etDireccion.getText().toString();

                if (nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty() || edadStr.isEmpty() || contrasena.isEmpty() || direccion.isEmpty()) {
                    Toast.makeText(AgregarUsuarioActivity.this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
                    return;
                }

                int edad = Integer.parseInt(edadStr);
                String codigo = generarCodigoAleatorio();

                // Crear usuario y agregarlo a la lista
                Usuario usuario = new Usuario(nombre, apellido, correo, edad, contrasena, direccion, codigo);
                listaUsuarios.add(usuario);

                // Mostrar el código generado
                tvCodigoGenerado.setText("Código generado: " + codigo);
                tvCodigoGenerado.setVisibility(View.VISIBLE);

                btnGuardar.setEnabled(false);
            }
        });

        // Botón para buscar usuario por código
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String codigoBuscar = etCodigoBuscar.getText().toString();
                if (codigoBuscar.isEmpty()) {
                    Toast.makeText(AgregarUsuarioActivity.this, "Ingrese un código", Toast.LENGTH_SHORT).show();
                    return;
                }
                Usuario usuarioEncontrado = buscarUsuarioPorCodigo(codigoBuscar);
                if (usuarioEncontrado != null) {
                    tvInformacionUsuario.setText("Nombre: " + usuarioEncontrado.getNombre() + "\n" +
                            "Apellido: " + usuarioEncontrado.getApellido() + "\n" +
                            "Correo: " + usuarioEncontrado.getCorreo() + "\n" +
                            "Edad: " + usuarioEncontrado.getEdad() + "\n" +
                            "Dirección: " + usuarioEncontrado.getDireccion());
                } else {
                    tvInformacionUsuario.setText("Usuario no encontrado");
                }
            }
        });
    }

    // Genera un código aleatorio único
    private String generarCodigoAleatorio() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(9000) + 1000;
        return "USER" + numeroAleatorio;
    }

    // Busca un usuario por su código en la lista
    private Usuario buscarUsuarioPorCodigo(String codigo) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getCodigo().equals(codigo)) {
                return usuario;
            }
        }
        return null;
    }
}
