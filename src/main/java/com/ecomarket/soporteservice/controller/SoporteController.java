package com.ecomarket.soporteservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomarket.soporteservice.dto.NotificacionRequestDTO;
import com.ecomarket.soporteservice.dto.SoporteTicketRequestDTO;
import com.ecomarket.soporteservice.model.entity.Notificacion;
import com.ecomarket.soporteservice.model.entity.TicketSoporte;
import com.ecomarket.soporteservice.service.SoporteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/soporte")
public class SoporteController {

    @Autowired
    private SoporteService soporteService;

    @PostMapping("enviar-notificacion-push")
    public ResponseEntity<?> postNotificacionPush(@RequestBody NotificacionRequestDTO notificacionRequestDTO) {
        Notificacion notificacion = soporteService.enviarNotificacionPush(notificacionRequestDTO.getDestinatarioId(),
        notificacionRequestDTO.getTitulo(), notificacionRequestDTO.getMensaje(), notificacionRequestDTO.getCanalId());

        return ResponseEntity.ok(notificacion);
    }

    @PostMapping("ingresar-ticket")
    public ResponseEntity<?> postTicket(@RequestBody SoporteTicketRequestDTO soporteTicketRequestDTO) throws Exception {
         TicketSoporte ticket = soporteService.ingresarTicket(soporteTicketRequestDTO.getClienteId(),
          soporteTicketRequestDTO.getCategoriaId(), soporteTicketRequestDTO.getAsunto(), soporteTicketRequestDTO.getPedidoId());
        
          return ResponseEntity.ok(ticket);
    }
    
    
}
