package com.ecomarket.soporteservice.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketSoporte {
    /* 
    - id: Long

- clienteId: Long
- empleadoAsignadoId: Long
- pedidoRelacionadoId: Long
- categoria: CategoriaTicket
- asunto: String
- estado: EstadoTicket
- fechaCreacion: LocalDateTime
- fechaCierre: LocalDateTime */

    private Long id;
    private Long empleadoAsignadoId;
    private Long pedidoRelacionadoId;
    private CategoriaTicket categoria;
    private String asunto;
    private EstadoTicket estado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaCierre; 
}
