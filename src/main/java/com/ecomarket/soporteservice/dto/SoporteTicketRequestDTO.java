package com.ecomarket.soporteservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SoporteTicketRequestDTO {

    private Long clienteId;
    private Long categoriaId;
    private String asunto;
    private Long pedidoId;
    
}
