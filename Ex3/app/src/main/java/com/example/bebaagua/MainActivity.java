package com.example.bebaagua;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListAdapter listAdapter;
    private EditText inputQuilos;
    private TextView qtd_bebida;
    private TextView qtd_faltante;
    private Button calculaButton;
    private AppModel appModel = new AppModel();
    private ArrayList<Boolean> listaDeCopos;

    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculaButton = findViewById(R.id.calcButton);
        qtd_bebida = findViewById(R.id.label_qtd_bebida);
        qtd_faltante = findViewById(R.id.label_qtd_faltante);
        inputQuilos = findViewById(R.id.edtext);
        fab.setOnClickListener(view -> resetar());
        fab = findViewById(R.id.fab);
        calculaButton.setOnClickListener(view -> {
            appModel.setQuilos(Double.valueOf(inputQuilos.getText().toString()));
            appModel.setQtdCopos();
            appModel.setQtdBebida(0);
            appModel.setQtdFaltante(appModel.getQtdCopos());
            configuraListaDeCopos(appModel.getQtdCopos());
            listAdapter.reconfigurar(listaDeCopos);
            atualizarParametros();
        });
        listaDeCopos = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        listAdapter = new ListAdapter(this, listaDeCopos);
        listAdapter.setOnItemClickListener((status, posicao) -> {
            if (listaDeCopos.get(posicao) == true){
                listaDeCopos.set(posicao, false);
                consumirCopo();
                atualizarParametros();
                listAdapter.reconfigurar(listaDeCopos);
            }
        });
        recyclerView.setAdapter(listAdapter);

    }
    private void consumirCopo(){
        Integer qtdBebidaAtual = appModel.getQtdBebida();
        qtdBebidaAtual += 150;
        appModel.setQtdBebida(qtdBebidaAtual);
        Integer qtdFaltanteAtual = appModel.getQtdFaltante();
        qtdFaltanteAtual--;
        appModel.setQtdFaltante(qtdFaltanteAtual);
    }
    private void atualizarParametros() {
        qtd_bebida.setText(appModel.getQtdBebida().toString()+" ml");
        qtd_faltante.setText(appModel.getQtdFaltante().toString()+" copos");
    }

    private void configuraListaDeCopos(int tamanho) {
        listaDeCopos = new ArrayList<>();
        for (int i = 0; i < tamanho; i++) {
            listaDeCopos.add(true);
        }
    }

    public void resetar(){
        listaDeCopos = new ArrayList<>();
        appModel = new AppModel();
        listAdapter.reconfigurar(listaDeCopos);
        atualizarParametros();
    }
}