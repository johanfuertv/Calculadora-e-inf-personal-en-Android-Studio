package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Random;

public class AgregarUsuarioActivity extends AppCompatActivity {

    private EditText etNombre, etApellido, etCorreo, etEdad, etContrasena, etDireccion, etCodigoBuscar;
    private Button btnGuardar, btnBuscar;
    private TextView tvCodigoGenerado, tvInformacionUsuario;
    private ArrayList<Usuario> listaUsuarios;

    private Spinner spinnerUniversidad, spinnerCarrera;
    private RadioGroup rgGeneroMusical, rgDeporte, rgGenero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_usuario);

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

        spinnerUniversidad = findViewById(R.id.spinnerUniversidad);
        spinnerCarrera = findViewById(R.id.spinnerCarrera);
        rgGeneroMusical = findViewById(R.id.rgGeneroMusical);
        rgDeporte = findViewById(R.id.rgDeporte); // RadioGroup para deporte
        rgGenero = findViewById(R.id.rgGenero);

        listaUsuarios = new ArrayList<>();

        btnGuardar.setOnClickListener(v -> {
            String nombre = etNombre.getText().toString().trim();
            String apellido = etApellido.getText().toString().trim();
            String correo = etCorreo.getText().toString().trim();
            String edadStr = etEdad.getText().toString().trim();
            String contrasena = etContrasena.getText().toString().trim();
            String direccion = etDireccion.getText().toString().trim();

            if (nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty() || edadStr.isEmpty() || contrasena.isEmpty() || direccion.isEmpty()) {
                Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
                return;
            }

            int edad = Integer.parseInt(edadStr);
            String codigo = generarCodigoAleatorio();
            String universidad = spinnerUniversidad.getSelectedItem().toString();
            String carrera = spinnerCarrera.getSelectedItem().toString();

            // Obtener el género musical seleccionado
            int selectedGeneroMusicalId = rgGeneroMusical.getCheckedRadioButtonId();
            RadioButton selectedGeneroMusical = findViewById(selectedGeneroMusicalId);
            String generoMusical = selectedGeneroMusical != null ? selectedGeneroMusical.getText().toString() : "No seleccionado";

            // Obtener el deporte seleccionado
            int selectedDeporteId = rgDeporte.getCheckedRadioButtonId();
            RadioButton selectedDeporte = findViewById(selectedDeporteId);
            String deporte = selectedDeporte != null ? selectedDeporte.getText().toString() : "No seleccionado";

            // Obtener el sexo seleccionado
            int selectedSexoId = rgGenero.getCheckedRadioButtonId();
            RadioButton selectedSexo = findViewById(selectedSexoId);
            String sexo = selectedSexo != null ? selectedSexo.getText().toString() : "No seleccionado";

            // Crear el objeto Usuario y agregarlo a la lista
            Usuario usuario = new Usuario(nombre, apellido, correo, edad, contrasena, direccion, codigo, universidad, carrera, generoMusical, deporte, sexo);
            listaUsuarios.add(usuario);

            // Mostrar el código generado
            tvCodigoGenerado.setText("Código generado: " + codigo);
            tvCodigoGenerado.setVisibility(View.VISIBLE);
        });

        btnBuscar.setOnClickListener(v -> {
            String codigoBuscar = etCodigoBuscar.getText().toString().trim();
            if (codigoBuscar.isEmpty()) {
                Toast.makeText(this, "Ingrese un código", Toast.LENGTH_SHORT).show();
                return;
            }

            Usuario usuarioEncontrado = buscarUsuarioPorCodigo(codigoBuscar);
            tvInformacionUsuario.setText(usuarioEncontrado != null ? usuarioEncontrado.toString() : "Usuario no encontrado");
        });
    }

    private String generarCodigoAleatorio() {
        return "USER" + (new Random().nextInt(9000) + 1000);
    }

    private Usuario buscarUsuarioPorCodigo(String codigo) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getCodigo().equals(codigo)) {
                return usuario;
            }
        }
        return null;
    }
}
