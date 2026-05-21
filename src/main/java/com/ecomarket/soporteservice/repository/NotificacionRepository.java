package com.ecomarket.soporteservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomarket.soporteservice.model.Notificacion;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long>{
    
}
