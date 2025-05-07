package com.synex.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.synex.domain.Ticket;
import com.synex.repository.TicketRepository;

@Service
public class TicketService {

    private final TicketRepository ticketRepo;

    public TicketService(TicketRepository ticketRepo) {
        this.ticketRepo = ticketRepo;
    }

    public List<Ticket> getAllTickets() {
        return ticketRepo.findAll();
    }

    public Optional<Ticket> getTicketById(Long id) {
        return ticketRepo.findById(id);
    }

    public Ticket createTicket(Ticket ticket) {
        ticket.setCreationDate(new java.util.Date());
        return ticketRepo.save(ticket);
    }

    public void deleteTicket(Long id) {
        ticketRepo.deleteById(id);
    }
}
