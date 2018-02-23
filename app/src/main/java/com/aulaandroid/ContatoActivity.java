package com.aulaandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ContatoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);
        setTitle("Contato");

        //exibindo botao de boltar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //habilitando menu na barra de titulos
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        //carregando os itens do menu
        inflater.inflate(R.menu.menu_contato, menu);
        return true;
    }

    //opcoes de selecao de menu (acoes)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
