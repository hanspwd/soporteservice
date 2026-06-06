package com.ecomarket.soporteservice;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import com.ecomarket.soporteservice.dto.ClienteDTO;
import com.ecomarket.soporteservice.model.entity.Notificacion;
import com.ecomarket.soporteservice.model.reference.CanalNotificacion;
import com.ecomarket.soporteservice.repository.NotificacionRepository;
import com.ecomarket.soporteservice.service.CanalNotificacionService;
import com.ecomarket.soporteservice.service.NotificacionService;

public class NotificacionServiceTest {

    @Mock
    private NotificacionRepository notificacionRepository;

    @Mock
    private CanalNotificacionService canalNotificacionService;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private NotificacionService notificacionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testReadAllNotificaciones() {
        Long canalId = 1L;
        String titulo = "Test send notificacion svc";
        String cuerpo = "dadadadadadadadadadaddadadaada";

        CanalNotificacion canalMock = canalNotificacionService.getCanalNotificacionById(canalId);

        Notificacion notificacion = Notificacion.builder()
        .id(1L).destinatarioId(1L).canal(canalMock).titulo(titulo).cuerpo(cuerpo)
        .fechaEnvioNotificacion(LocalDateTime.now()).enviadaConExito(true).build();

        List<Notificacion> notificaciones = new ArrayList<>();
        notificaciones.add(notificacion);

        when(notificacionRepository.findAll()).thenReturn(notificaciones);

        List<Notificacion> resultado = notificacionService.readAllNotificacion();

        assertThat(resultado).hasSize(1);
        assertThat(resultado).contains(notificacion);

        verify(notificacionRepository).findAll();
    }

    @Test
    void testSendNotificacion() {

        Long canalId = 1L;
        Long destinatarioId = 1L;
        String titulo = "Test send notificacion svc";
        String cuerpo = "dadadadadadadadadadaddadadaada";

        CanalNotificacion canalMock = canalNotificacionService.getCanalNotificacionById(canalId);

        Notificacion notificacionGuardadaDB = Notificacion.builder()
        .id(1L).destinatarioId(1L).canal(canalMock).titulo(titulo).cuerpo(cuerpo)
        .fechaEnvioNotificacion(LocalDateTime.now()).enviadaConExito(true).build();

        when(canalNotificacionService.getCanalNotificacionById(1L)).thenReturn(canalMock);
        when(restTemplate.getForObject(any(String.class), eq(ClienteDTO.class))).thenReturn(new ClienteDTO());
        when (notificacionRepository.save(any(Notificacion.class))).thenReturn(notificacionGuardadaDB);

        Notificacion resultado = notificacionService.sendNotificacion(destinatarioId, titulo, cuerpo, canalId);

        assertThat(resultado).isNotNull();
        assertThat(resultado.getId()).isEqualTo(1L);
        assertThat(resultado.getTitulo()).isEqualTo(titulo);
        assertThat(resultado.getEnviadaConExito()).isTrue();
        
        verify(notificacionRepository).save(any(Notificacion.class));
    }

}
