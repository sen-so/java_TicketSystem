package mmbank.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity(name = "branchTicket")
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ticketId;

    @CreatedDate
    private LocalDateTime timeGenerated;

    @Column(nullable = false)
    private int  queueOrder;

    @PrePersist
    protected void ticketGenerated(){
        this.timeGenerated= LocalDateTime.now();
    }
}
