package com.duvarax.tpanexobmoviles.ui.misactividades;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.duvarax.tpanexobmoviles.R;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ActividadesFragmentAdapter extends RecyclerView.Adapter<ActividadesFragmentAdapter.ViewHolder> {

    private DetalleViewModel mv;
    private Context contexto;
    private List<Actividad> actividades;
    private LayoutInflater inflater;

    public ActividadesFragmentAdapter(Context contexto, List<Actividad> actividades, LayoutInflater inflater) {
        this.contexto = contexto;
        this.actividades = actividades;
        this.inflater = inflater;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        contexto = parent.getContext();
        View root = inflater.inflate(R.layout.actividad_item, parent, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        LocalDateTime fechaYHoraActividad = actividades.get(position).getFecha();
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaActividad = fechaYHoraActividad.format(formatoFecha);

        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaActual = fechaYHoraActividad.format(formatoHora);

        holder.nombre.setText((actividades.get(position)).getNombre());
        holder.fecha.setText(fechaActividad);
        holder.hora.setText(horaActual);

        holder.detalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle =new Bundle();
                bundle.putSerializable("actividad", actividades.get(position));
                System.out.println(bundle);

                Navigation.findNavController((Activity)contexto ,R.id.nav_host_fragment_content_navigation).navigate(R.id.detalleFragment, bundle);
            }
        });
    }


    @Override
    public int getItemCount() {
        return actividades.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nombre, fecha, hora;
        Button detalle;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            detalle = itemView.findViewById(R.id.btnDetalle);
            nombre = itemView.findViewById(R.id.tvNombre);
            fecha = itemView.findViewById(R.id.tvFecha);
            hora = itemView.findViewById(R.id.tvHora);
        }
    }


}


