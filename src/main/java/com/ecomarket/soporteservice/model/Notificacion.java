package com.ecomarket.soporteservice.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notificacion {
    
    private Long id;
    private Long destinatarioId;
    private CanalNotificacion canal;
    private String titulo;
    private String cuerpo;
    private LocalDateTime fechaEnvioNotificacion;
    private Boolean enviadaConExito;


}
