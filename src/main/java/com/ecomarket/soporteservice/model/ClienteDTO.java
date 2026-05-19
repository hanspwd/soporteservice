package com.ecomarket.soporteservice.model;

import lombok.Data;

@Data
public class ClienteDTO {
    
    private Long idCliente;
    private String nombre;
    private String correo;

}
