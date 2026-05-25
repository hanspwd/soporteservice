package com.ecomarket.soporteservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class NotificacionRequestDTO {

    private Long destinatarioId;
    private String titulo;
    private String mensaje;
    private Long canalId;

}
