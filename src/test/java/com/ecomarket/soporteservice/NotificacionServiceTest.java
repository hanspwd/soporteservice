package com.ecomarket.soporteservice;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ecomarket.soporteservice.model.entity.Notificacion;
import com.ecomarket.soporteservice.model.reference.CanalNotificacion;
import com.ecomarket.soporteservice.repository.NotificacionRepository;
import com.ecomarket.soporteservice.service.NotificacionService;

public class NotificacionServiceTest {
//EJEMPLO GUIA 
/*

Mascota mascota = new Mascota(null, "Rex", "Perro", 5);
        Mascota mascotaGuardada = new Mascota(1L, "Rex", "Perro", 5);

        when(mascotaRepository.save(mascota)).thenReturn(mascotaGuardada);

        Mascota resultado = mascotaService.guardarMascota(mascota);

        assertThat(resultado).isEqualTo(mascotaGuardada);
        assertThat(resultado.getId()).isEqualTo(1L);
        assertThat(resultado.getNombre()).isEqualTo("Rex");

*/

    @Mock
    private NotificacionRepository notificacionRepository;

    @InjectMocks
    private NotificacionService notificacionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSendNotificacion() {
        CanalNotificacion canal = new CanalNotificacion(1L, "SMS");
        
        //!!!!!!!!! IMPORTANTE !!!!!!!!!!!!!
        // PENDIENTE MODIFICACION DE ALGUNOS SERVICES, INCLUIR DTO PARA QUE SE PUEDAN REALIZAR CIERTAS PRUEBAS
        // EL LA VALIDACION DE ERROR DE CANALNOTIFICACIONSERVICE PROVOCA UN ERROR NO DESEADO EN testNotificacionService

        @SuppressWarnings("static-access")
        Notificacion notificacion = new Notificacion().builder()
        .id(null).destinatarioId(1L).canal(canal).titulo("Test send notificacion svc").cuerpo("dadadada")
        .fechaEnvioNotificacion(LocalDateTime.now()).enviadaConExito(true).build();

        @SuppressWarnings("static-access")
        Notificacion notificacionEnviada = new Notificacion().builder()
        .id(1L).destinatarioId(1L).canal(canal).titulo("Test send notificacion svc").cuerpo("dadadada")
        .fechaEnvioNotificacion(LocalDateTime.now()).enviadaConExito(true).build();

        when(notificacionRepository.save(notificacion)).thenReturn(notificacionEnviada);
        
        Notificacion resultado = notificacionService.sendNotificacion(1L, "Test send notificacion svc", "dadadada", 1L);

        assertThat(resultado).isEqualTo(notificacionEnviada);
        assertThat(resultado.getId()).isEqualTo(notificacionEnviada.getId());
        assertThat(resultado.getEnviadaConExito()).isEqualTo(true);

        verify(notificacionRepository.save(notificacion));
    }

}
