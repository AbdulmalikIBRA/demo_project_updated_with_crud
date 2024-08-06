package com.example.demo.controller;

import com.example.demo.dto.TicketDTO;
import com.example.demo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/create")
    public String showCreateTicketPage(Model model) {
        List<TicketDTO> tickets = ticketService.getAllTickets();
        model.addAttribute("tickets", tickets);
        return "createTicket";
    }

    @PostMapping("/create")
    public String createTicket(@ModelAttribute TicketDTO ticketDTO) {
        ticketService.createTicket(ticketDTO);
        return "redirect:/tickets/create";
    }

    @GetMapping("/api/v2/tickets")
    @ResponseBody
    public List<TicketDTO> getAllTickets() {
        return ticketService.getAllTickets();
    }
}
