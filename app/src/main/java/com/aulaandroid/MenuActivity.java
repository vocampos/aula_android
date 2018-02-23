package com.aulaandroid;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setTitle("Aula Android");

        //
    }

    //funcionalidade acionada ao clicar nas imagens, conforme atributo
    // //android:onClick="executarClique"
    public void executarClique(View view) {
        //configurando as acoes para redirecionamento da tela
        Class activity = null;
        switch (view.getId()) {
            case R.id.ico_calculadora:
                activity = MainActivity.class;
                break;
            case R.id.ico_exemplos:
                activity = ExemploComponentesActivity.class;
                break;
            case R.id.ico_contato:
                activity = ContatoActivity.class;
                break;
        }

        if (activity != null) {
            //abrindo a tela
            Intent intent = new Intent(MenuActivity.this, activity);
            startActivity(intent);
        }
    }
}
