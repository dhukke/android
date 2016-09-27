package com.example.jnetto.bebidasapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carregarImagem();
    }

    /**
     * Click do btnSucesso
     * @param view
     */
    public void click(View view) {

        carregarImagem();
    }

    private void carregarImagem() {

        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radio_group);
        ImageView img = (ImageView) findViewById(R.id.imageView);

        int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();

        if (checkedRadioButtonId != -1) {

            String bedidaEscolhida = "";

            switch (checkedRadioButtonId) {
                case R.id.opt1:
                    img.setImageResource(R.drawable.pinga);
                    bedidaEscolhida = "Pinga deliciosa";
                    break;
                case R.id.opt2:
                    img.setImageResource(R.drawable.vodka);
                    bedidaEscolhida = "Vodka marota";
                    break;
                case R.id.opt3:
                    img.setImageResource(R.drawable.rum);
                    bedidaEscolhida = "Rum nectar dos mares";
                    break;
                case R.id.opt4:
                    img.setImageResource(R.drawable.activia);
                    bedidaEscolhida = "Activia pro seu corpinho";
                    break;
            }

            Toast.makeText(MainActivity.this, "Bebida Escolhida: " + bedidaEscolhida , Toast.LENGTH_SHORT).show();
        }
    }

}
