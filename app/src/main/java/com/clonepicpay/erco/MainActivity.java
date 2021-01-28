package com.clonepicpay.erco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.clonepicpay.erco.register.Register001;

public class MainActivity extends AppCompatActivity {

    private Button botaoEntrar;
    private Button botaoCadatrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoEntrar = (Button) findViewById(R.id.button2);
        botaoCadatrar = (Button) findViewById(R.id.button1);

        botaoEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                botaoEntrarActivity();
            }
        });

        botaoCadatrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botaoCadatrarActivity();
            }
        });
    }

    private void botaoEntrarActivity() {

        startActivity(new Intent(MainActivity.this, TelaEntrar.class));
    }

    private void botaoCadatrarActivity() {

        startActivity(new Intent(MainActivity.this, Register001.class));
    }


}