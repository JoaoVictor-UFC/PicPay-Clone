package com.clonepicpay.erco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button botaoEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoEntrar = (Button) findViewById(R.id.button2);

        botaoEntrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                botaoEntrarActivity();
            }
        });
    }

    private void botaoEntrarActivity() {

        startActivity(new Intent(MainActivity.this, TelaEntrar.class));
    }
}