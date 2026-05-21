package com.ecomarket.soporteservice.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EstadoPedidoDTO {
    
    private Long idEstadoPedido;
    private String nombre;

}
