package org.example.Repository;

import org.example.Entity.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BidRepository extends JpaRepository<Bid,Integer> {
    Optional<Bid> findFirstByLot_IdOrderByDateTimeAsc(int lotId);
    @Query("""
        SELECT new org.example.DTO.BidDTO(b.name, b.dateTime) FROM Bid b WHERE b.id = (
        SELECT b.name FROM Bid b GROUP BY b.name ORDER BY count(b.name) DESC ,LIMIT 1
        ) ORDER BY b.dateTime DESC LIMIT 1
            """)
    Optional<Bid> findTheMostFrequentBidder(@Param("lotId") int lotId);
    Optional<Bid> findFirstByLot_IdOrderByDateTimeDesc(int lotId);
    List<Bid> findAllByLot_Id(int lotId);
}
