package com.example.jnetto.mysecondactivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SecondActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String nome = getIntent().getStringExtra("Nome");

        Toast.makeText(SecondActivity.this, "Escolha uma das opções, " + nome, Toast.LENGTH_SHORT).show();

        String[] items = {
                "Curitiba", "Floripa", "Gramado", "Osasco"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_activated_1,
                items
        );

        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent data = new Intent();

        switch (position) {
            case 0:
                data.putExtra("Retorno", "Curitiba");
                break;
            case 1:
                data.putExtra("Retorno", "Floripa");
                break;
            case 2:
                data.putExtra("Retorno", "Gramado");
                break;
            case 3:
                data.putExtra("Retorno", "Osasco");
                break;
        }

        setResult(RESULT_OK, data);
        finish();
    }
}
