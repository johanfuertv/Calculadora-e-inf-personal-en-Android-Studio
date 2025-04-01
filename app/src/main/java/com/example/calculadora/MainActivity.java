package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etPantalla;
    private String operacion = "";
    private double numero1 = 0;
    private double numero2 = 0;
    private boolean esNuevoNumero = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPantalla = findViewById(R.id.etPantalla);

        // Configurar los listeners para los botones
        setButtonListeners();
    }

    private void setButtonListeners() {
        int[] botonesNumeros = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};
        for (int id : botonesNumeros) {
            findViewById(id).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button btn = (Button) v;
                    String numero = btn.getText().toString();
                    if (esNuevoNumero) {
                        etPantalla.setText(numero);
                        esNuevoNumero = false;
                    } else {
                        etPantalla.append(numero);
                    }
                }
            });
        }

        int[] botonesOperaciones = {R.id.btnSumar, R.id.btnRestar, R.id.btnMultiplicar, R.id.btnDividir};
        for (int id : botonesOperaciones) {
            findViewById(id).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button btn = (Button) v;
                    operacion = btn.getText().toString();
                    numero1 = Double.parseDouble(etPantalla.getText().toString());
                    esNuevoNumero = true;
                }
            });
        }

        findViewById(R.id.btnIgual).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero2 = Double.parseDouble(etPantalla.getText().toString());
                double resultado = calcular(numero1, numero2, operacion);
                etPantalla.setText(String.valueOf(resultado));
                esNuevoNumero = true;
            }
        });

        findViewById(R.id.btnBorrar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etPantalla.setText("0");
                esNuevoNumero = true;
                numero1 = 0;
                numero2 = 0;
                operacion = "";
            }
        });
    }

    private double calcular(double num1, double num2, String operacion) {
        switch (operacion) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    return 0;
                }
            default:
                return 0;
        }
    }
}