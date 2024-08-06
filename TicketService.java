package com.example.demo.service;

import com.example.demo.dto.TicketDTO;
import com.example.demo.entity.Ticket;
import com.example.demo.mapper.TicketMapper;
import com.example.demo.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    @Autowired
    public TicketService(TicketRepository ticketRepository, TicketMapper ticketMapper) {
        this.ticketRepository = ticketRepository;
        this.ticketMapper = ticketMapper;
    }

    public List<TicketDTO> getAllTickets() {
        return ticketRepository.findAll().stream()
                .map(ticketMapper::toDto)
                .collect(Collectors.toList());
    }

    public TicketDTO getTicketById(Long id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        return ticket.map(ticketMapper::toDto).orElse(null);
    }

    public TicketDTO createTicket(TicketDTO ticketDTO) {
        Ticket ticket = ticketMapper.toEntity(ticketDTO);
        Ticket savedTicket = ticketRepository.save(ticket);
        return ticketMapper.toDto(savedTicket);
    }
    public TicketDTO approveTicket(Long id) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket not found"));
        ticket.setStatus("APPROVED");
        ticket = ticketRepository.save(ticket);
        return ticketMapper.toDto(ticket);
    }

    public TicketDTO updateTicket(Long id, TicketDTO ticketDTO) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(id);
        if (optionalTicket.isPresent()) {
            Ticket ticket = optionalTicket.get();
            ticket.setTitle(ticketDTO.getTitle());
            ticket.setDescription(ticketDTO.getDescription());
            ticket.setStatus(ticketDTO.getStatus());
            Ticket updatedTicket = ticketRepository.save(ticket);
            return ticketMapper.toDto(updatedTicket);
        } else {
            return null;
        }
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}
