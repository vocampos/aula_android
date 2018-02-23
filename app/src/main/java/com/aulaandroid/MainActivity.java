package com.aulaandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //variaveis para componentes de tela
    private TextView resultado;
    private Button somar, subtrair, dividir, multiplicar, igual, limpar;

    //variaveis para regra de negocio
    private int numero1, numero2;
    private String operacao = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setTitle("Calculadora");

        //configurando botao voltar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        resultado = (TextView) findViewById(R.id.resultado);
        somar = (Button) findViewById(R.id.opSomar);
        subtrair = (Button) findViewById(R.id.opSubrair);
        dividir = (Button) findViewById(R.id.opDividir);
        multiplicar = (Button) findViewById(R.id.opMultiplicar);
        igual= (Button) findViewById(R.id.opIgual);
        limpar = (Button) findViewById(R.id.opLimpar);

        somar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacao = "+";
                numero1 = Integer.parseInt(resultado.getText().toString());
                resultado.setText("");
            }
        });

        subtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacao = "-";
                numero1 = Integer.parseInt(resultado.getText().toString());
                resultado.setText("");
            }
        });

        dividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacao = "/";
                numero1 = Integer.parseInt(resultado.getText().toString());
                resultado.setText("");
            }
        });

        multiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacao = "*";
                numero1 = Integer.parseInt(resultado.getText().toString());
                resultado.setText("");
            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero2 = Integer.parseInt(resultado.getText().toString());
                executarOperacao();
            }
        });

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado.setText("");
                numero1 = 0;
                numero2 = 0;
                operacao = "";
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setarValor(View view) {
        String numero = ((TextView) view).getText().toString();
        resultado.setText(resultado.getText() + numero);
    }

    private void executarOperacao() {
        switch (operacao) {
            case "+":
                resultado.setText(String.valueOf(numero1 + numero2));
                break;
            case "-":
                resultado.setText(String.valueOf(numero1 - numero2));
                break;
            case "/":
                resultado.setText(String.valueOf(numero1 / numero2));
                break;
            case "*":
                resultado.setText(String.valueOf(numero1 * numero2));
                break;
            default:
        }

        operacao = "";
    }

}
