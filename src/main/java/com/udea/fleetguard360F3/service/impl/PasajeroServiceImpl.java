package com.udea.fleetguard360F3.service.impl;

import com.udea.fleetguard360F3.dto.RegistroPasajeroDto;
import com.udea.fleetguard360F3.model.Pasajero;
import com.udea.fleetguard360F3.repository.PasajeroRepository;
import com.udea.fleetguard360F3.service.PasajeroService;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PasajeroServiceImpl implements PasajeroService {
    private final PasajeroRepository repo;
    private final BCryptPasswordEncoder passwordEncoder;

    public PasajeroServiceImpl(PasajeroRepository repo, BCryptPasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    @Transactional
    public Pasajero register(RegistroPasajeroDto dto) {
        // validaciones
        if (!dto.getPassword().equals(dto.getPasswordConfirm())) {
            throw new IllegalArgumentException("Las contraseñas no coinciden.");
        }
        if (repo.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("El email ya está registrado.");
        }
        if (repo.existsByUsername(dto.getUsername())) {
            throw new IllegalArgumentException("El username ya está en uso.");
        }

        Pasajero p = new Pasajero();
        p.setUsername(dto.getUsername());
        p.setNombre(dto.getNombre());
        p.setApellido(dto.getApellido());
        p.setIdentificacion(dto.getIdentificacion());
        p.setTelefono(dto.getTelefono());
        p.setEmail(dto.getEmail());
        p.setPasswordHash(passwordEncoder.encode(dto.getPassword()));

        return repo.save(p);
    }

    @Override
    public boolean emailAvailable(String email) {
        return !repo.existsByEmail(email);
    }

    @Override
    public boolean usernameAvailable(String username) {
        return !repo.existsByUsername(username);
    }

    @Override
    public Pasajero findById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
