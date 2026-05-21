package com.ecomarket.soporteservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomarket.soporteservice.model.CategoriaTicket;
import com.ecomarket.soporteservice.repository.CategoriaTicketRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoriaTicketService {
    
    @Autowired
    private CategoriaTicketRepository categoriaTicketRepository;

    public CategoriaTicket createCategoriaTicket(CategoriaTicket categoriaTicket) {

        return categoriaTicketRepository.save(categoriaTicket);
    }

}