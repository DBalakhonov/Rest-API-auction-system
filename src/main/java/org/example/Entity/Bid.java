package org.example.Entity;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "bids")
public class Bid {
    @Column(length = 20, nullable = false)
    private String name;

    @Column(name = "date_time", nullable = false)
    private OffsetDateTime dateTime;
    @ManyToOne
    @JoinColumn(name = "lot_id")
    private Lot lot;

    public OffsetDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(OffsetDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lot getLot() {
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }
}
