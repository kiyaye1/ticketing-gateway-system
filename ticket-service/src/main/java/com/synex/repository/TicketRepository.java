package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synex.domain.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
	
}
