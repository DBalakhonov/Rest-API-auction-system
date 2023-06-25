package org.example.Repository;

import org.example.Entity.Lot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LotRepository extends JpaRepository<Lot,Integer> {
}
