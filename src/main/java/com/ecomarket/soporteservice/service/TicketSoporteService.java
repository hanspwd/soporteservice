package com.ecomarket.soporteservice.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.ecomarket.soporteservice.dto.ClienteDTO;
import com.ecomarket.soporteservice.dto.PedidoDTO;
import com.ecomarket.soporteservice.exception.NoExisteEnBdException;
import com.ecomarket.soporteservice.model.entity.TicketSoporte;
import com.ecomarket.soporteservice.model.reference.CategoriaTicket;
import com.ecomarket.soporteservice.model.reference.EstadoTicket;
import com.ecomarket.soporteservice.repository.TicketSoporteRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TicketSoporteService {
    
    @Autowired
    private TicketSoporteRepository ticketSoporteRepository;

    @Autowired 
    private EstadoTicketService estadoTicketService;

    @Autowired 
    private CategoriaTicketService categoriaTicketService;

    @Autowired
    private RestTemplate restTemplate;

    public TicketSoporte ingresarTicket(Long clienteId, Long categoriaId, String asunto, Long pedidoId) throws Exception {

        // Traer excepcion de estado o de categoria en caso de que se ingrese uno inexistente
        // DEFAULT AL APENAS ABRIR TICKET (ABIERTO)
        EstadoTicket estadoValido = estadoTicketService.findEstadoTicketById(1L);
        CategoriaTicket categoriaValida = categoriaTicketService.findCategoriaTicketById(categoriaId);

        // verificar existencia de cliente
        String urlCliente = "http://localhost:8082/clientes/" + clienteId;
        
        try {
        @SuppressWarnings("unused")
        ClienteDTO cliente = restTemplate.getForObject(urlCliente, ClienteDTO.class);
        } catch (HttpClientErrorException.NotFound exNotFound) {
            throw new NoExisteEnBdException("No se puede ingresar el ticket debido a que el id del cliente ingresado no existe en DB.");
        } catch (Exception ex) {
            throw new Exception("Error inesperado, no se pudo ingresar el ticket a soporte. Contacte con el administrador del sistema.");
        }

        // verificar existencia de pedido
        String urlPedido = "http://localhost:8082/pedidos/" + pedidoId;

        try {
            PedidoDTO pedido = restTemplate.getForObject(urlPedido, PedidoDTO.class);

            if(pedido != null && !pedido.getClienteId().equals(clienteId)) {
                throw new IllegalArgumentException("El pedido ingresado no pertenece al cliente que esta creando el ticket.");
            }

        } catch (HttpClientErrorException exNotFound) {
            throw new NoExisteEnBdException("No se puede ingresar el ticket debido a que el id del pedido ingresado no existe en DB.");
        } catch (Exception ex) {
            throw new Exception("Error inesperado, no se pudo ingresar el ticket a soporte. Contacte con el administrador del sistema.");
        }

        TicketSoporte ticket = new TicketSoporte();
        ticket.setClienteId(clienteId);
        ticket.setCategoria(categoriaValida);
        ticket.setAsunto(asunto.trim());
        ticket.setFechaCreacion(LocalDateTime.now());
        ticket.setPedidoRelacionadoId(pedidoId);
        ticket.setEstado(estadoValido);

        // El empleado del area requerida tomara el ticket y se le asignara ahi. (OTRO METODO)
        // ticket.setEmpleadoAsignadoId(null);

       return ticketSoporteRepository.save(ticket);
    }

}
