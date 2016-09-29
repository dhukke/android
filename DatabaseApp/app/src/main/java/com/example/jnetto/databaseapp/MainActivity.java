package com.example.jnetto.databaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lstProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstProdutos = (ListView) findViewById(R.id.lstProdutos);
        final ProdutoAdapter produtoAdapter = new ProdutoAdapter(this);
        lstProdutos.setAdapter(produtoAdapter);

        DataStore.sharedInstance().addProduto(new Produto("Carne", 20, 10));
        DataStore.sharedInstance().addProduto(new Produto("Ovo", 1, 10));

        lstProdutos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Produto produto = DataStore.sharedInstance().getProduto(position);

                String nomeProduto = produto.getNome();

                DataStore.sharedInstance().removeProduto(position);

                produtoAdapter.notifyDataSetChanged();

                Toast.makeText(getApplicationContext(),nomeProduto + " foi removido", Toast.LENGTH_LONG).show();

                return true;
            }

        });

    }
}
