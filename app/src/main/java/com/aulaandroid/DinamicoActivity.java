package com.aulaandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DinamicoActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private Button btSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinamico);

        linearLayout = (LinearLayout) findViewById(R.id.ll_dinamico);
        btSalvar = (Button) findViewById(R.id.salvar);

        for (int i = 0; i < 10; i++) {

            EditText tv = new EditText(DinamicoActivity.this);
            tv.setText("DINAMICO " + i);
            tv.setId(i);
        }
    }

    public void onClickSalvar(View view) {

        int qtd = linearLayout.getChildCount();

        EditText tv = (EditText) linearLayout.getChildAt(0);

        Toast.makeText(DinamicoActivity.this, tv.getText().toString(),
                Toast.LENGTH_SHORT).show();
    }
}
