package com.MSResena.Soporte.Comunicacion.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MSResena.Soporte.Comunicacion.model.resena;
import com.MSResena.Soporte.Comunicacion.repository.ReseñaRepository;

@Service
public class resenaService {
    @Autowired
    private ReseñaRepository rRepo;

    public resena guardar(resena reseña) {
    if (reseña.getCalificacion() < 1 || reseña.getCalificacion() > 5) {
        throw new IllegalArgumentException("La calificación debe estar entre 1 y 5.");
    }
    reseña.setFechaEmision(LocalDate.now());
    return rRepo.save(reseña);
}

    public List<resena> listar() {
        return rRepo.findAll();
    }

    public List<resena> buscarPorProducto(int idProducto) {
        return rRepo.findByIdProducto(idProducto);
    }
}
