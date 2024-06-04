package mmbank.service;

import mmbank.dto.TicketDTO;
import mmbank.dto.TicketNotFoundException;
import mmbank.dto.mapper.TicketMapper;
import mmbank.entity.TicketEntity;
import mmbank.entity.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketMapper ticketMapper;

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public TicketDTO addTicket(TicketDTO ticketDTO) {
        TicketEntity ticketEntity = ticketMapper.toEntity(ticketDTO);
        int followingQueueOrderNumber;
        if (ticketRepository.count() > 0) {
            Integer lastQueueOrderNumber = ticketRepository.findTopByQueueOrder();
            followingQueueOrderNumber = lastQueueOrderNumber + 1;
        } else followingQueueOrderNumber = 0;

        ticketEntity.setQueueOrder(followingQueueOrderNumber);
        ticketEntity = ticketRepository.saveAndFlush(ticketEntity);
        return ticketMapper.toDTO(ticketEntity);
    }

    @Override
    public List<TicketDTO> getAllActiveTickets() {
        return ticketRepository.findAll()
                .stream()
                .filter(ticket -> ticket.getQueueOrder() >= 0)
                .map(ticketMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TicketDTO removeTicket() {
        TicketDTO lastTicketDTO = null;
        List<TicketEntity> allTickets = ticketRepository.findAll();
        if (!allTickets.isEmpty()) {
            TicketEntity lastTicket = allTickets.get(allTickets.size() - 1);
            lastTicketDTO = ticketMapper.toDTO(lastTicket);
            ticketRepository.delete(lastTicket);
        } else {
            throw new RuntimeException("Nebyl nalezen žádný ticket ke smazání");
        }
        return lastTicketDTO;
    }

    @Override
    public TicketDTO getActualActiveTicket() {
        return ticketMapper.toDTO(ticketRepository.findByQueueOrder(0));
    }


}
