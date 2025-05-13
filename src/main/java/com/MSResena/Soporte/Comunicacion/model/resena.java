package com.MSResena.Soporte.Comunicacion.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class resena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idResena;

    @Column(nullable = false)
    private int idCliente;

    @Column(nullable = false)
    private int idProducto;

    @Column(nullable = false)
    private int calificacion;

    @Column(length = 500)
    private String comentario;

    @Column(name = "fecha_emision", nullable = false)
    private LocalDate fechaEmision;

}
