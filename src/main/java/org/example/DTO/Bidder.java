package org.example.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.OffsetDateTime;

public class Bidder {
    @NotBlank
    @Size(min=3, max=20)
    private String name;
    private int lot_id;

    private OffsetDateTime offsetDateTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLot_id() {
        return lot_id;
    }

    public void setLot_id(int lot_id) {
        this.lot_id = lot_id;
    }

    public OffsetDateTime getOffsetDateTime() {
        return offsetDateTime;
    }

    public void setOffsetDateTime(OffsetDateTime offsetDateTime) {
        this.offsetDateTime = offsetDateTime;
    }
}
