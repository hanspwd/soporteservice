package com.ecomarket.soporteservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomarket.soporteservice.model.MensajeChat;

public interface MensajeChatRepository extends JpaRepository<MensajeChat, Long>{
    
}
