package com.clonepicpay.erco;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.clonepicpay.erco.adapter.AdapterCartoes;
import com.clonepicpay.erco.model.Cartao;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PrincipalActivity extends AppCompatActivity {

    private RecyclerView recyclerCartoes;
    private List<Cartao> listaCartoes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);




        //listagem de filmes
        this.criarCartoes();


        //configurar adapter
        AdapterCartoes adapterCartoes = new AdapterCartoes(listaCartoes);

        //configurar recycler view
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerCartoes.setLayoutManager(layoutManager);
        recyclerCartoes.setHasFixedSize(true);      //otimizar recycleview dizendo que tem tamanho fixo
        recyclerCartoes.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerCartoes.setAdapter(adapterCartoes);

        //evento de clique
        recyclerCartoes.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerCartoes,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Cartao c = listaCartoes.get(position);

                                Toast.makeText(
                                        getApplicationContext(),
                                        "Item pressionado: " + c.getApelidoCartao(),
                                        Toast.LENGTH_LONG
                                ).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Cartao c = listaCartoes.get(position);

                                Toast.makeText(
                                        getApplicationContext(),
                                        "Click longo em:" + c.getApelidoCartao(),
                                        Toast.LENGTH_LONG
                                ).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                )
        );
    }

    public void criarCartoes() {
        this.listaCartoes.add(new Cartao("Xodo","Mastercard","8899 8899 8899"));
        this.listaCartoes.add(new Cartao("Carimbo","Mastercard","8899 8899 8899"));
        this.listaCartoes.add(new Cartao("Coto","Mastercard","8899 8899 8899"));
        this.listaCartoes.add(new Cartao("Mocoto","Mastercard","8899 8899 8899"));
        this.listaCartoes.add(new Cartao("Coio","Mastercard","8899 8899 8899"));

    }

}