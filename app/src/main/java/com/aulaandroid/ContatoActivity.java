package com.aulaandroid;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.aulaandroid.modelo.Contato;

import java.util.HashSet;

public class ContatoActivity extends AppCompatActivity {

    private EditText edNome, edEmail, edTelefone;
    private CheckBox java, android, html;
    private RadioButton sexoF, sexoM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);
        setTitle(R.string.contato);

        //exibindo botao de boltar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void onClickValidar(View view) {

        if (TextUtils.isEmpty(edNome.getText().toString())) {
            edNome.setError(getString(R.string.campo_obrigatorio));

        } else if (TextUtils.isEmpty(edEmail.getText().toString())) {
            edEmail.setError(getString(R.string.campo_obrigatorio));

        } else if (TextUtils.isEmpty(edTelefone.getText().toString())) {
            edTelefone.setError(getString(R.string.campo_obrigatorio));
        }

        else if (!java.isChecked() && !android.isChecked() && !html.isChecked() ) {
            Toast.makeText(this, "Informe uma habilidade!", Toast.LENGTH_SHORT).show();
        }

        else if (!sexoF.isChecked() && !sexoM.isChecked()) {
            Toast.makeText(this, "Informe o sexo!", Toast.LENGTH_SHORT).show();
        }

        else {
            Contato contato = new Contato();
            contato.setNome(edNome.getText().toString());
            contato.setEmail(edEmail.getText().toString());
            contato.setTelefone(edTelefone.getText().toString());

            if (java.isChecked()) {
                contato.getHabilidades().add(java.getText().toString());
            }

            if (android.isChecked()) {
                contato.getHabilidades().add(android.getText().toString());
            }

            if (html.isChecked()) {
                contato.getHabilidades().add(html.getText().toString());
            }

            if (sexoM.isChecked()) {
                contato.setSexo(sexoM.getText().toString());
            }

            if (sexoF.isChecked()) {
                contato.setSexo(sexoF.getText().toString());
            }

            if (salvarContato(contato)) {

                Toast.makeText(this,
                        "Informacoes salvas com sucesso!",
                        Toast.LENGTH_LONG).show();
            }
        }

    }

    private void recuperarComponentes() {

        edNome = (EditText) findViewById(R.id.et_nome);
        edEmail = (EditText) findViewById(R.id.et_email);
        edTelefone = (EditText) findViewById(R.id.et_telefone);

        java = (CheckBox) findViewById(R.id.hb_java);
        android = (CheckBox) findViewById(R.id.hb_Android);
        html = (CheckBox) findViewById(R.id.hb_html);

        sexoF = (RadioButton) findViewById(R.id.rb_F);
        sexoM = (RadioButton) findViewById(R.id.rb_M);
    }


    private boolean salvarContato(Contato contato) {

        SharedPreferences sharedPreferences =
                this.getSharedPreferences("CONTATO", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("NOME", contato.getNome());
        editor.putString("EMAIL", contato.getEmail());
        editor.putString("TELEFONE", contato.getTelefone());
        editor.putString("SEXO", contato.getSexo());
        editor.putStringSet("HABILIDADES", contato.getHabilidades());

       return editor.commit();

    }

    private Contato recuperarContato() {

        Contato contato = new Contato();
        SharedPreferences sharedPreferences =
                this.getSharedPreferences("CONTATO", Context.MODE_PRIVATE);

        contato.setNome(sharedPreferences.getString("NOME", ""));
        contato.setEmail(sharedPreferences.getString("EMAIL", ""));
        contato.setTelefone(sharedPreferences.getString("TELEFONE", ""));
        contato.setSexo(sharedPreferences.getString("SEXO", ""));
        contato.setHabilidades(sharedPreferences.getStringSet("HABILIDADES",
                new HashSet<String>()));

        return contato;
    }

    private void preencherTela(Contato contato) {
        edNome.setText(contato.getNome());
        edEmail.setText(contato.getEmail());
        edTelefone.setText(contato.getTelefone());

        for (String habilidade : contato.getHabilidades()) {

            if (java.getText().equals(habilidade)) {
                java.setChecked(true);
            }

            if (android.getText().equals(habilidade)) {
                android.setChecked(true);
            }

            if (html.getText().equals(habilidade)) {
                html.setChecked(true);

            }
        }

        if (sexoF.getText().toString().equals(contato.getSexo())) {
            sexoF.setChecked(true);

        } else if (sexoM.getText().toString().equals(contato.getSexo())) {
            sexoM.setChecked(true);
        }

    }

    private void limparFormulario() {
        edNome.setText("");
        edEmail.setText("");
        edTelefone.setText("");
        sexoF.setChecked(false);
        sexoM.setChecked(false);
        java.setChecked(false);
        android.setChecked(false);
        html.setChecked(false);

        salvarContato(new Contato());
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
       /*     case android.R.id.home:
                finish();
                return true;*/
           case R.id.mn_menu:
               limparFormulario();
               return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        recuperarComponentes();
        Contato contato = recuperarContato();
        preencherTela(contato);

        Log.i("CONTATO", "PASSANDO NO onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("CONTATO", "PASSANDO NO onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("CONTATO", "PASSANDO NO onRestart");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("CONTATO", "PASSANDO NO onDestroy");
    }

}
