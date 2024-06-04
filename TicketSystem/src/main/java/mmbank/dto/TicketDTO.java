package mmbank.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDTO {

    @JsonProperty("id")
    private Long ticketId;

   @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
   private LocalDateTime timeGenerated;

    private int queueOrder;
}
