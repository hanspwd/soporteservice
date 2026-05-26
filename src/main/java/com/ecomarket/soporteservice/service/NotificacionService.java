package com.ecomarket.soporteservice.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.ecomarket.soporteservice.dto.ClienteDTO;
import com.ecomarket.soporteservice.model.entity.Notificacion;
import com.ecomarket.soporteservice.model.reference.CanalNotificacion;
import com.ecomarket.soporteservice.repository.NotificacionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class NotificacionService {
    
    @Autowired
    private NotificacionRepository notificacionRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CanalNotificacionService canalNotificacionService;

    public List<Notificacion> readAllNotificacion() {
        return notificacionRepository.findAll();
    }

    public Notificacion sendNotificacion(Long destinatarioId, String titulo, String mensaje, Long canalId) {

        // Si el canal no es valido envia la excepcion del elseThrow
        CanalNotificacion canalValido = canalNotificacionService.getCanalNotificacionById(canalId);

        // Obtenemos al destinatario por id
        String url = "http://mock-server:8082/clientes/" + destinatarioId;
        Notificacion notificacion;

        try {
        // Si el cliente no existe es decir la url nos devuelve un (Not Found 404) lo capturamos como un error
        // En caso de que no nos devuelva un Not Found 404 es porque el Cliente si existe por lo tanto continuamos con normalidad

        // No hace nada pero ayuda a capturar el error y verificar que el cliente exista
        @SuppressWarnings("unused")
        ClienteDTO cliente = restTemplate.getForObject(url, ClienteDTO.class);

        notificacion = new Notificacion(null, destinatarioId, canalValido, titulo, mensaje, LocalDateTime.now(), true);
        } catch (HttpClientErrorException.NotFound exNotFound) {
            notificacion = new Notificacion(null, destinatarioId, canalValido, titulo, mensaje, LocalDateTime.now(), false);
        } catch (Exception ex) {
            notificacion = new Notificacion(null, destinatarioId, canalValido, titulo, mensaje, LocalDateTime.now(), false);
        }
        return notificacionRepository.save(notificacion);
    }

}
