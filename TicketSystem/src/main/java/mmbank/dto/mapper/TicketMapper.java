package mmbank.dto.mapper;

import mmbank.dto.TicketDTO;
import mmbank.entity.TicketEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    TicketEntity toEntity(TicketDTO source);

    TicketDTO toDTO(TicketEntity source);
}
