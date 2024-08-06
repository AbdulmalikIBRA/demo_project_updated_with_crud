package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.TicketDTO;
import com.example.demo.service.TicketService;

import java.util.List;

/**
 * TicketControllerV2 is a version 2 REST controller for handling ticket-related requests.
 * It provides endpoints for retrieving and creating tickets.
 */
@RestController // Marks this class as a Spring MVC controller where every method returns a domain object instead of a view.
@RequestMapping("/api/v2/tickets-v2") // Maps HTTP requests to /api/v2/tickets.
public class TicketControllerV2 {

    private final TicketService ticketService;

    /**
     * Constructor for TicketControllerV2.
     * @param ticketService the ticket service to handle business logic.
     */
    @Autowired // Marks a constructor, field, setter method, or config method to be autowired by Spring's dependency injection facilities.
    public TicketControllerV2(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    /**
     * Retrieves all tickets.
     * @return a list of TicketDTO objects.
     */
    @GetMapping // Maps HTTP GET requests to /api/v2/tickets.
    public List<TicketDTO> getAllTickets() {
        return ticketService.getAllTickets();
    }

    /**
     * Creates a new ticket.
     * @param ticketDTO the data transfer object representing the ticket to be created.
     * @return the created TicketDTO object.
     */
    @PostMapping // Maps HTTP POST requests to /api/v2/tickets.
    public TicketDTO createTicket(TicketDTO ticketDTO) {
        return ticketService.createTicket(ticketDTO);
    }
}
