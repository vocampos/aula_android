package com.aulaandroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ExemploComponentesActivity extends AppCompatActivity {

    private Button botaoOK;
    private TextView texto;
    private ImageView imageView;
    private RadioButton radioButton;
    private RadioGroup radioGroup;
    private CheckBox checkBox;


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

        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        //colocando acao
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton = (RadioButton) group.findViewById(checkedId);
                Toast.makeText(ExemploComponentesActivity.this, "Radio selecionado " + radioButton.getText().toString(), Toast.LENGTH_SHORT).show();
            }

        });


    }

    public void onCheckboxClicked(View view) {
        checkBox = (CheckBox) view;
        //verifica se esta checado
        boolean checked = checkBox.isChecked();
        Toast.makeText(ExemploComponentesActivity.this, "CheckBox selecionado " + checkBox.getText().toString(), Toast.LENGTH_SHORT).show();
    }
}


/*
https://goo.gl/H5un18

https://goo.gl/pJFETb
*/