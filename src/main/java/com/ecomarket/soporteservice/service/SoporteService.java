package com.ecomarket.soporteservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomarket.soporteservice.model.entity.MensajeChat;
import com.ecomarket.soporteservice.model.entity.Notificacion;
import com.ecomarket.soporteservice.model.entity.Resena;
import com.ecomarket.soporteservice.model.entity.TicketSoporte;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SoporteService {

    @Autowired
    private NotificacionService notificacionService;

    @Autowired
    private TicketSoporteService ticketSoporteService;

    @Autowired
    private MensajeChatService mensajeChatService;

    @Autowired
    private ResenaService resenaService;

    public Notificacion enviarNotificacionPush(Long destinatarioId, String titulo, String mensaje, Long canalId) {
        return notificacionService.sendNotificacion(destinatarioId, titulo, mensaje, canalId);
    }

    public TicketSoporte ingresarTicket(Long clienteId, Long categoriaId, String asunto, Long pedidoId) throws Exception {
        return ticketSoporteService.ingresarTicket(clienteId, categoriaId, asunto, pedidoId);
    }

    public MensajeChat enviarMensajeChat(Long ticketId, Long remitenteId, Boolean esCliente, String contenido) {
        return mensajeChatService.enviarMensaje(ticketId, remitenteId, esCliente, contenido);
    }

    public Resena crearResena(Long productoId, Long clienteId, Integer calificacionEstrellas, String comentario) {
        return resenaService.crearResena(productoId, clienteId, calificacionEstrellas, comentario);
    }
}
