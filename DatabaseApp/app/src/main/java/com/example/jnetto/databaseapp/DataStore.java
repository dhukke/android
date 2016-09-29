package com.example.jnetto.databaseapp;

import android.content.Context;

import java.util.List;

/**
 * Created by jnetto on 29/09/2016.
 */
public class DataStore {

    private static DataStore instance = null;
    private BarDatabase barDatabase;
    private List<Produto> produtos;
    private Context context;

    /**
     *
     */
    protected DataStore() {
    }

    /**
     *
     * @return
     */
    public static DataStore sharedInstance() {

        if (instance == null) {
            instance = new DataStore();
        }

        return instance;
    }

    /**
     *
     * @param context
     */
    public void setContext(Context context) {

        this.context = context;
        this.barDatabase = new BarDatabase(context);
        this.produtos = barDatabase.getAll();
    }

    public Produto getProduto(int position) {
        return produtos.get(position);
    }

    /**
     *
     * @return
     */
    public List<Produto> getProdutos() {

        return this.produtos;
    }

    /**
     *
     * @param produto
     */
    public void addProduto(Produto produto) {

        produtos.add(produto);
        barDatabase.insertProduto(produto);
    }

    /**
     *
     * @param produto
     * @param position
     */
    public void editProduto(Produto produto, int position) {
        produtos.set(position, produto);
        barDatabase.updateProduto(produto);
    }

    /**
     *
     * @param position
     */
    public void removeProduto(int position) {

        Produto produto = produtos.get(position);
        barDatabase.removeProduto(produto);
        produtos.remove(position);
    }
}
