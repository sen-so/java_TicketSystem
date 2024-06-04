package mmbank.controller;

import mmbank.dto.TicketDTO;
import mmbank.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/tickets")
    public TicketDTO addTicket(@RequestBody TicketDTO ticketDTO) {
        return ticketService.addTicket(ticketDTO);
    }

    @GetMapping("/tickets")
    public List<TicketDTO> getTickets() {
        return ticketService.getAllActiveTickets();
    }

    @GetMapping("actualTicket")
    public TicketDTO getActualTicket() {
        return ticketService.getActualActiveTicket();
    }

    @DeleteMapping("/deleteLastTicket")
    public TicketDTO removeTicket() {
        return ticketService.removeTicket();
    }
}
