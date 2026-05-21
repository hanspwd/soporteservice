package com.ecomarket.soporteservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomarket.soporteservice.model.EstadoTicket;

public interface EstadoTicketRepository extends JpaRepository<EstadoTicket, Long>{
    
}
