package com.ecomarket.soporteservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomarket.soporteservice.model.CanalNotificacion;

public interface CanalNotificacionRepository extends JpaRepository<CanalNotificacion, Long> {
    
    CanalNotificacion findByNombre(String nombre);
}
