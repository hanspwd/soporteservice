package com.ecomarket.soporteservice.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RolDTO {
    
    private Long idRol;
    private String nombre;

}
