package mmbank.entity.repository;

import mmbank.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
    @Query("""
            SELECT COALESCE(queueOrder,0)
            FROM branchTicket
            ORDER BY queueOrder DESC
            LIMIT 1            
            """)
    int findTopByQueueOrder();
    TicketEntity findByQueueOrder(int queueOrder);


}