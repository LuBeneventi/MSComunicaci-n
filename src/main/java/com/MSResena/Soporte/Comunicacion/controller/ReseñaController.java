package com.MSResena.Soporte.Comunicacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MSResena.Soporte.Comunicacion.model.resena;
import com.MSResena.Soporte.Comunicacion.service.resenaService;

@RestController
@RequestMapping("api/Reseñas")
public class ReseñaController {
    
    @Autowired
    private resenaService rService;

    @PostMapping("/Comentar")
    public ResponseEntity<resena> guardar(@RequestBody resena res) {
        return ResponseEntity.ok(rService.guardar(res));
    }

    @GetMapping
    public ResponseEntity<List<resena>> listarTodas() {
        return ResponseEntity.ok(rService.listar());
    }

    @GetMapping("/{idProducto}")
    public ResponseEntity<List<resena>> buscarPorProducto(@PathVariable int idProducto) {
        return ResponseEntity.ok(rService.buscarPorProducto(idProducto));
    }
}
