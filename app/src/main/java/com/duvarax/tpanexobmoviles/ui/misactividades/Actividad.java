package com.duvarax.tpanexobmoviles.ui.misactividades;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class Actividad implements Serializable {
    private String nombre;
    private String descripcion;
    private LocalDateTime fecha;
    private String lugar;

    public Actividad() {
    }

    public Actividad(String nombre, String descripcion, LocalDateTime fecha, String lugar) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.lugar = lugar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @NonNull
    @Override
    public String toString() {
        return nombre + " " + descripcion;
    }
}
