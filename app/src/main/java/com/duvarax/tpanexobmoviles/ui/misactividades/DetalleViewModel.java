package com.duvarax.tpanexobmoviles.ui.misactividades;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DetalleViewModel extends ViewModel {
    private MutableLiveData<Actividad> actividad;

    public DetalleViewModel() {
    }

    public LiveData<Actividad> getActividad(){
        if(actividad == null){
            actividad = new MutableLiveData<>();
        }
        return actividad;
    }

    public void setDetalles(Actividad activi){
        actividad.setValue(activi);
    }
}