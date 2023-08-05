package com.BreynnerPerez.juegossena;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;

public class adaptador extends RecyclerView.Adapter<adaptador.ViewHolder> {

    JSONArray jsonArray;

    Context context;

    public adaptador(Context context, JSONArray jsonArray){
        this.jsonArray = jsonArray; this.context=context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_juegos, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        try {
            holder.tvNombre.setText(jsonArray.getJSONObject(position).getString("Nombre del juego"));

        } catch (JSONException e) {
            //error por no se pudo obtener el json
            throw new RuntimeException(e);
        }
    }
    @Override
    public int getItemCount() {
        return jsonArray.length();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        //atributos
        TextView tvNombre;
        ImageView ivimagen;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // relacion de los atributos con la vista
            tvNombre = itemView.findViewById(R.id.tvNombre);
            ivimagen = itemView.findViewById(R.id.ivimagen);
        }
    }

}


