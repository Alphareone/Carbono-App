package com.carbono2050.carbono_app.service;

import com.carbono2050.carbono_app.model.Emision;
import com.carbono2050.carbono_app.repository.EmisionRepository;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.lang.Nullable;

@Service
public class EmisionService {

    private final EmisionRepository emisionRepository;

    public EmisionService(EmisionRepository emisionRepository) {
        this.emisionRepository = emisionRepository;
    }

    public List<Emision> listarEmisiones() {
        return emisionRepository.findAll();
    }

    public void guardarEmision(Emision emision) {
        emisionRepository.save(emision);
    }

    public void borrarTodo() {

        throw new UnsupportedOperationException("Unimplemented method 'borrarTodo'");
    }

    public void addEmision(Emision emision) {

        throw new UnsupportedOperationException("Unimplemented method 'addEmision'");
    }

    public @Nullable Object totalGlobal() {

        throw new UnsupportedOperationException("Unimplemented method 'totalGlobal'");
    }

    public @Nullable Object getEmisiones() {

        throw new UnsupportedOperationException("Unimplemented method 'getEmisiones'");
    }
}
