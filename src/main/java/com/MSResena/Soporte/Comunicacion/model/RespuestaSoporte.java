package com.MSResena.Soporte.Comunicacion.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespuestaSoporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRespuesta;

    @Column(nullable = true)
    private int idUsuario;

    @Column(nullable = true)
    private int idCliente;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String contenido;

    @Column(name = "fecha_respuesta", nullable = false)
    private LocalDate fechaRespuesta;

    @ManyToOne
    @JoinColumn(name = "idSoporte", nullable = false)
    @JsonIgnore
    private solicitudSoporte soporte;
}
