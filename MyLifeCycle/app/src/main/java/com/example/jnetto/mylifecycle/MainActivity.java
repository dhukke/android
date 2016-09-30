package com.example.jnetto.mylifecycle;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView = new TextView(this);
        setContentView(textView);

        textView.setText(textView.getText().toString() + "Evento OnCreate executado!");

        if (savedInstanceState == null) {
            textView.setText(textView.getText().toString() + "\nPrimeira vez dp app!");
        } else {
            textView.setText(textView.getText().toString() + "\n" + savedInstanceState.getString("Texto"));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        textView.setText(textView.getText().toString() + "onResume disparado!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        textView.setText(textView.getText().toString() + "evento onPause disparado!");

        if (isFinishing()) {
            textView.setText(textView.getText().toString() + " fui");
            Toast.makeText(MainActivity.this, "Fui", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(MainActivity.this, "Destruindo", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("Texto", "Valor antes da Rotação");
    }
}
