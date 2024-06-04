package mmbank.service;

import mmbank.dto.TicketDTO;

import java.util.List;

public interface TicketService {


    TicketDTO addTicket(TicketDTO ticketDTO);

    List<TicketDTO> getAllActiveTickets();

    TicketDTO getActualActiveTicket();

    TicketDTO removeTicket();
}
