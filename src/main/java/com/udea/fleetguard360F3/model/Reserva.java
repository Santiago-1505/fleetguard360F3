package com.udea.fleetguard360F3.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pasajero_id", nullable = false)
    private Pasajero pasajero;

    @ManyToOne
    @JoinColumn(name = "viaje_id", nullable = false)
    private Viaje viaje;

    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PasajeroAdicional> pasajerosAdicionales;

    private int cantidadAsientos;

    private LocalDateTime fechaReserva;

    private String codigoReserva;

    private String estado;


    public Reserva() {
    }

    public Reserva(Long id, Pasajero pasajero, Viaje viaje, List<PasajeroAdicional> pasajerosAdicionales,
                   int cantidadAsientos, LocalDateTime fechaReserva, String codigoReserva, String estado) {
        this.id = id;
        this.pasajero = pasajero;
        this.viaje = viaje;
        this.pasajerosAdicionales = pasajerosAdicionales;
        this.cantidadAsientos = cantidadAsientos;
        this.fechaReserva = fechaReserva;
        this.codigoReserva = codigoReserva;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }

    public List<PasajeroAdicional> getPasajerosAdicionales() {
        return pasajerosAdicionales;
    }

    public void setPasajerosAdicionales(List<PasajeroAdicional> pasajerosAdicionales) {
        this.pasajerosAdicionales = pasajerosAdicionales;
    }

    public int getCantidadAsientos() {
        return cantidadAsientos;
    }

    public void setCantidadAsientos(int cantidadAsientos) {
        this.cantidadAsientos = cantidadAsientos;
    }

    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDateTime fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
