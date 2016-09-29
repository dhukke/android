package com.example.jnetto.databaseapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jnetto on 29/09/2016.
 */
public class ProdutoAdapter extends BaseAdapter{

    private List<Produto> produtos;
    private Context context;

    public ProdutoAdapter(Context context) {

        this.context = context;
        DataStore.sharedInstance().setContext(context);
        produtos = DataStore.sharedInstance().getProdutos();
    }

    @Override
    public int getCount() {
        return produtos.size();
    }

    @Override
    public Object getItem(int position) {
        return produtos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Produto produto = produtos.get(position);
        View view = LayoutInflater.from(context).inflate(R.layout.list_adapter, parent, false);

        TextView nome = (TextView) view.findViewById(R.id.nome);
        TextView preco = (TextView) view.findViewById(R.id.preco);
        TextView estoque = (TextView) view.findViewById(R.id.estoque);

        nome.setText(produto.getNome());
        preco.setText(produto.getPreco().toString());
        estoque.setText(produto.getEstoque().toString());

        return view;
    }
}
