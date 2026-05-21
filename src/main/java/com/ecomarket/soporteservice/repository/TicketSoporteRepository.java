package com.ecomarket.soporteservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomarket.soporteservice.model.TicketSoporte;

public interface TicketSoporteRepository extends JpaRepository<TicketSoporte, Long>{
    
}
