package com.aulaandroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ExemploComponentesActivity extends AppCompatActivity {

    private Button botaoOK;
    private TextView texto;
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //informando qual tela sera carregada
        setContentView(R.layout.activity_exemplo_componente);
        setTitle("Componentes");

        //vinculando os componentes da tela com o codigo JAVA
        botaoOK = (Button) findViewById(R.id.botaoOK);
        texto = (TextView) findViewById(R.id.textView);
        imageView = (ImageView)  findViewById(R.id.imagem);

        //colocando acao no botao OK
        botaoOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                texto.setText("Atualizando TEXTO =)");
            }
        });
    }
}


/*
https://goo.gl/H5un18

https://goo.gl/pJFETb
*/