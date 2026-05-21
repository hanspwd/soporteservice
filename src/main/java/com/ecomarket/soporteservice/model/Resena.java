package com.ecomarket.soporteservice.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "resena")
public class Resena {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long productoId;

    @Column(nullable = false)
    private Long clienteId;

    @Column(nullable = false)
    private Integer calificacionEstrellas;

    @Column(nullable = false)
    private String comentario;

    @Column(nullable = false)
    private LocalDateTime fechaPublicacion;

    @Column(nullable = false)
    private Boolean moderacionAprobado;

}
