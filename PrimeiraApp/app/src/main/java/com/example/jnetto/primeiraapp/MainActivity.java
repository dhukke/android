package com.example.jnetto.primeiraapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnSucessoClick(View view) {

        Button btnSucesso = (Button) findViewById(R.id.btnSucesso);
        TextView nome = (TextView) findViewById(R.id.txtNome);

        Toast.makeText(MainActivity.this, nome.getText().toString(), Toast.LENGTH_LONG).show();

        Log.i("oi bonitao ", nome.getText().toString());
    }
}
