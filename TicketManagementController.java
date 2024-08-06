package com.example.demo.controller;

import com.example.demo.dto.TicketDTO;
import com.example.demo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tickets/management")
public class TicketManagementController {

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public String listTickets(Model model) {
        model.addAttribute("tickets", ticketService.getAllTickets());
        return "ticket-list";
    }

    @GetMapping("/create")
    public String createTicketForm(Model model) {
        model.addAttribute("ticket", new TicketDTO());
        return "ticket-form";
    }

    @PostMapping("/create")
    public String createTicket(@ModelAttribute TicketDTO ticketDTO) {
        ticketService.createTicket(ticketDTO);
        return "redirect:/tickets";
    }

    @GetMapping("/edit/{id}")
    public String editTicketForm(@PathVariable Long id, Model model) {
        model.addAttribute("ticket", ticketService.getTicketById(id));
        return "ticket-form";
    }

    @PostMapping("/update/{id}")
    public String updateTicket(@PathVariable Long id, @ModelAttribute TicketDTO ticketDTO) {
        ticketService.updateTicket(id, ticketDTO);
        return "redirect:/tickets";
    }

    @GetMapping("/delete/{id}")
    public String deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
        return "redirect:/tickets";
    }
}
