package org.example.Repository;

import org.example.Entity.Lot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LotRepository extends JpaRepository<Lot,Integer> {
    Optional<Lot> findFirstByLot_Id(int lotId);
    @Query(value = "UPDATE lot SET status = 'STARTED' WHERE id = :lotId")
    void updateFirstByLot_Id(@Param("lotId") int lotId);

    @Query (value = "UPDATE lot SET status = 'STOPPED' WHERE id = :lotId")
    void stopLotByLot_Id(@Param("lotId") int lotId);
    @Query(value = "SELECT e FROM lot WHERE status = :status")

    List<Lot> findLots(@Param("status") String status);
}

