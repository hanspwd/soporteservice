package com.ecomarket.soporteservice.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PedidoDTO {
    
    private Long pedidoId;
    private Long clienteId;
    private Double subtotal;
    private Double total;
    private Long estado;
    private Long fechaCreacion;
}
