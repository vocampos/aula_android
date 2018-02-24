package com.aulaandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ContatoActivity extends AppCompatActivity {

    private EditText edNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);
        setTitle(R.string.contato);

        //exibindo botao de boltar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recuperarComponentes();
    }

    public void onClickValidar(View view) {
        if (TextUtils.isEmpty(edNome.getText().toString())) {
            edNome.setError(getString(R.string.nome_obrigatorio));
        } else {
            Toast.makeText(this,
                    "Informacoes salvas com sucesso!",
                    Toast.LENGTH_LONG).show();
        }

    }

    private void recuperarComponentes() {
        edNome = (EditText) findViewById(R.id.et_nome);
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
