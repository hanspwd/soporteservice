package com.ecomarket.soporteservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomarket.soporteservice.model.entity.Notificacion;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SoporteService {
 
    @Autowired
    private NotificacionService notificacionService;

    public Notificacion enviarNotificacionPush(Long destinatarioId, String titulo, String mensaje, Long canalId) {
        Notificacion notificacion = notificacionService.sendNotificacion(destinatarioId, titulo, mensaje, canalId);
        return notificacion;
    }
}
