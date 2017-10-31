package com.example.itp1dam.frutas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView ListaFrutas;
    private AdaptadorFrutas adaptador;
    private RadioGroup rOpcion;
    private String opcion;

    public String getOpcion(){
        return opcion;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        opcion = "Toast";
        ListaFrutas = (RecyclerView)findViewById(R.id.ListaFrutas);
        rOpcion = (RadioGroup)findViewById(R.id.rOpcion);
        rOpcion.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                RadioButton rb=(RadioButton)findViewById(checkedId);
                opcion = (String) rb.getText();
                //Toast.makeText(getApplicationContext(), rb.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        ArrayList<Fruta> frutas = new ArrayList<>();
        frutas.add(new Fruta(R.drawable.banana, getString(R.string.platano)));
        frutas.add(new Fruta(R.drawable.coco, getString(R.string.coco)));
        frutas.add(new Fruta(R.drawable.manzana, getString(R.string.manzana)));
        frutas.add(new Fruta(R.drawable.pera, getString(R.string.pera)));
        frutas.add(new Fruta(R.drawable.sandia, getString(R.string.sandia)));
        frutas.add(new Fruta(R.drawable.uva, getString(R.string.uva)));

        ListaFrutas.setHasFixedSize(true);

        ListaFrutas.addItemDecoration(new SpaceItemDecoration(this, R.dimen.list_space, true, true));

        LinearLayoutManager llm = new LinearLayoutManager(this);
        ListaFrutas.setLayoutManager(llm);

        adaptador = new AdaptadorFrutas(frutas, this, this);

        ListaFrutas.setAdapter(adaptador);
        adaptador.refrescar();
    }
}
