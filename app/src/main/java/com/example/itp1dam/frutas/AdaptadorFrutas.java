package com.example.itp1dam.frutas;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ITP1DAM on 23/10/2017.
 */

public class AdaptadorFrutas  extends RecyclerView.Adapter<AdaptadorFrutas.HolderFruta>{

    private ArrayList<Fruta> frutas;
    private Context contexto;
    private MainActivity mactiv;

    public AdaptadorFrutas(ArrayList<Fruta> frutas, Context contexto, MainActivity m) {
        this.frutas = frutas;
        this.contexto = contexto;
        this.mactiv = m;
    }

    public class HolderFruta extends RecyclerView.ViewHolder{
        TextView tNombreFruta;
        ImageView ivFruta;

        HolderFruta(View v){

            super(v);
            tNombreFruta = (TextView) v.findViewById(R.id.tNombreFruta);
            ivFruta = (ImageView) v.findViewById(R.id.ivFruta);

            ivFruta.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    switch(mactiv.getOpcion()){
                        case "Toast":
                            break;
                        case "SnackBar":
                            break;
                    }
                }
            });
        }
    }



    public void add(ArrayList<Fruta> frutas){
        frutas.clear();
        frutas.addAll(frutas);
    }

    public void refrescar(){
        notifyDataSetChanged();
    }

    @Override
    public HolderFruta onCreateViewHolder(ViewGroup parent, int viewType) {
        View v =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento_fruta,
                        parent, false);
        HolderFruta pvh = new HolderFruta(v);
        return pvh;

    }

    @Override
    public void onBindViewHolder(HolderFruta holder, int position) {
        holder.tNombreFruta.setText(frutas.get(position).getNombre());
        holder.ivFruta.setImageResource(frutas.get(position).getImagen());
    }

    @Override
    public int getItemCount() {
        return frutas.size();
    }
}
