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
@Table(name = "notificacion")
public class Notificacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long destinatarioId;

    @ManyToOne
    @JoinColumn(name = "canal_id")
    private CanalNotificacion canal;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String cuerpo;

    @Column(nullable = false)
    private LocalDateTime fechaEnvioNotificacion;

    @Column(nullable = false)
    private Boolean enviadaConExito;


}
