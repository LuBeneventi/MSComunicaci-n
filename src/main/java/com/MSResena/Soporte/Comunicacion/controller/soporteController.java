package com.MSResena.Soporte.Comunicacion.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MSResena.Soporte.Comunicacion.model.RespuestaSoporte;
import com.MSResena.Soporte.Comunicacion.model.solicitudSoporte;
import com.MSResena.Soporte.Comunicacion.service.soporteService;

@RestController
@RequestMapping("/api/SoporteTécnico")
public class soporteController {

    @Autowired
    private soporteService sService;

    @PostMapping("/Comentar")
    public ResponseEntity<solicitudSoporte> crear(@RequestBody solicitudSoporte solicitud) {
        return ResponseEntity.ok(sService.crearSolicitud(solicitud));
    }

    @GetMapping
    public ResponseEntity<List<solicitudSoporte>> listar() {
        return ResponseEntity.ok(sService.listar());
    }

    @PutMapping("/{id}/Cerrar")
    public ResponseEntity<solicitudSoporte> cerrar(@PathVariable int id) {
        return ResponseEntity.ok(sService.cerrar(id));
    }

    @PostMapping("/{id}/Responder")
    public ResponseEntity<RespuestaSoporte> responder(
            @PathVariable int id,
            @RequestBody RespuestaSoporte respuesta) {
        return ResponseEntity.ok(sService.agregarRespuesta(id, respuesta));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<solicitudSoporte>> buscar(@PathVariable int id){
        return ResponseEntity.ok(sService.buscarPorId(id));
    }

    @GetMapping("/Cliente: {idCliente}")
    public ResponseEntity<List<solicitudSoporte>> buscarPorCliente(@PathVariable int idCliente){
        return ResponseEntity.ok(sService.buscarPorCliente(idCliente));
    }
}
