package com.duvarax.tpanexobmoviles.ui.misactividades;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ActividadesViewModel extends ViewModel {
    private Context context;
    private MutableLiveData<ArrayList<Actividad>> actividades;
    private ArrayList<Actividad> actividadesList = new ArrayList<>();

    public ActividadesViewModel() {

    }

    public LiveData<ArrayList<Actividad>> getActividades(){
        if(actividades == null){
            actividades = new MutableLiveData<>();
        }
        return actividades;
    }

    public void cargarActividades(){
        actividadesList.add(new Actividad("Hacer la cama", "Hacer la cama require colocar bien las sabanas, colchas y por ultimo el cubrecama", LocalDateTime.now().plusMinutes(2), "Habitacion"));
        actividadesList.add(new Actividad("Lavar los platos", "Lavar los platos con agua caliente y detergente", LocalDateTime.now().plusDays(20).plusHours(5), "Cocina"));
        actividadesList.add(new Actividad("Ir al gimnasio", "Ir al gimnasio y hacer algo", LocalDateTime.now().plusDays(10).plusHours(2).plusMinutes(5), "Gimnasio"));
        actividadesList.add(new Actividad("Bañarme", "Bañarme luego de volver del gimnasio ", LocalDateTime.now().plusDays(15).plusHours(3).plusMinutes(7), "Baño"));
        actividades.setValue(actividadesList);
    }


}