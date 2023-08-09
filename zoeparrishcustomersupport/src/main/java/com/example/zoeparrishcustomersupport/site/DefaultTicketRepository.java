package com.example.zoeparrishcustomersupport.site;
import com.example.zoeparrishcustomersupport.entities.TicketEntity;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultTicketRepository extends GenericJpaRepository<Long, TicketEntity> implements TicketRepository {

}

