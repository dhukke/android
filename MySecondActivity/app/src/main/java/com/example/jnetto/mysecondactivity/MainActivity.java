package com.example.jnetto.mysecondactivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtNome;
    EditText txtRetorno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Teste de Menu");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtNome = (EditText) findViewById(R.id.txtNome);
        txtRetorno = (EditText) findViewById(R.id.txtRetorno);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.action_about:

                new AlertDialog.Builder(this)
                        .setMessage("Turma 3 de Dev Android!")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Sobre")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();

                break;

            case android.R.id.home:

                Toast.makeText(MainActivity.this, "Oi Home", Toast.LENGTH_SHORT).show();

                break;

            case R.id.action_next:

                btnGoOnClick(txtNome);

                break;
        }

        return true;
    }

    public void btnGoOnClick(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("Nome", txtNome.getText().toString());

        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeCustomAnimation(this, R.anim.fade_in, R.anim.fade_out);

        ActivityCompat.startActivityForResult(this, intent, 1, optionsCompat.toBundle());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            txtRetorno.setText(data.getStringExtra("Retorno"));
        }
    }

    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setMessage("Quer vazar loco?")
                .setIcon(android.R.drawable.ic_menu_help)
                .setTitle("Confirmação")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setNegativeButton("Não", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).show();
    }
}
