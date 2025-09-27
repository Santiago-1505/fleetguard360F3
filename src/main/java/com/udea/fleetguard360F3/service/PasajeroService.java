package com.udea.fleetguard360F3.service;

import com.udea.fleetguard360F3.dto.RegistroPasajeroDto;
import com.udea.fleetguard360F3.model.Pasajero;

public interface PasajeroService {
    Pasajero register(RegistroPasajeroDto dto);
    boolean emailAvailable(String email);
    boolean usernameAvailable(String username);
    Pasajero findById(Long id);
}
