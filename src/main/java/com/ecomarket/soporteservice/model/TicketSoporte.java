package com.ecomarket.soporteservice.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ticket_soporte")
public class TicketSoporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long empleadoAsignadoId;

    @Column(nullable = false)
    private Long pedidoRelacionadoId;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaTicket categoria;

    @Column(nullable = false)
    private String asunto;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private EstadoTicket estado;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(nullable = false)
    private LocalDateTime fechaCierre; 
}
