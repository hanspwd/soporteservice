package com.ecomarket.soporteservice.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resena {
    
    private Long id;
    private Long productoId;
    private Long clienteId;
    private Integer calificacionEstrellas;
    private String comentario;
    private LocalDateTime fechaPublicacion;
    private Boolean moderacionAprobado;

}
