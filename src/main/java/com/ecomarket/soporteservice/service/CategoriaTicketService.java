package com.ecomarket.soporteservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomarket.soporteservice.exception.NoExisteEnBdException;
import com.ecomarket.soporteservice.exception.YaExisteEnBdException;
import com.ecomarket.soporteservice.model.reference.CategoriaTicket;
import com.ecomarket.soporteservice.repository.CategoriaTicketRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoriaTicketService {
    
    @Autowired
    private CategoriaTicketRepository categoriaTicketRepository;

    public List<CategoriaTicket> readAllCategoriaTicket() {
        return categoriaTicketRepository.findAll();
    }

    public CategoriaTicket createCategoriaTicket(CategoriaTicket categoriaTicket) {
        CategoriaTicket existente = categoriaTicketRepository.findByNombre(categoriaTicket.getNombre()).orElse(null);
        if(existente != null) {
           throw new YaExisteEnBdException("La categoria de ticket con nombre " + categoriaTicket.getNombre() + " ya existe en BD.");
        }
        return categoriaTicketRepository.save(categoriaTicket);
    }

    public void deleteCategoriaTicketById(Long id) {

        CategoriaTicket existente = categoriaTicketRepository.findById(id).orElse(null);

        if(existente == null) {
            throw new NoExisteEnBdException("La categoria con id " + id + " no se puede borrar debido a que no existe en la BD.");
        }
        categoriaTicketRepository.deleteById(id);
    }

}