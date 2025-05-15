package com.MSResena.Soporte.Comunicacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("api/reseñas")
public class ReseñaController {
    
    @Autowired
    private resenaService rService;

    @PostMapping("/comentar")
    public ResponseEntity<resena> guardar(@RequestBody resena res) {
        return ResponseEntity.ok(rService.guardar(res));
    }

    @GetMapping
    public ResponseEntity<List<resena>> listarTodas() {
        List<resena> resena = rService.listar();
        if(resena.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(rService.listar());
    }

    @GetMapping("/producto/{idProducto}")
    public ResponseEntity<List<resena>> buscarPorProducto(@PathVariable int idProducto) {
        List<resena> producto = rService.buscarPorProducto(idProducto);
        if(producto.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(rService.buscarPorProducto(idProducto));
    }

    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<List<resena>> buscarPorCliente(@PathVariable int idCliente) {
         List<resena> cliente = rService.buscarPorCliente(idCliente);
         if(cliente.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
         }
        return ResponseEntity.ok(rService.buscarPorCliente(idCliente));
    }
}
