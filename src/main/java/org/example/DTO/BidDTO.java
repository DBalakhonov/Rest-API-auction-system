package org.example.DTO;

import java.time.OffsetDateTime;

public class BidDTO {
    private String bidderName;
    private OffsetDateTime bidDate;

    public BidDTO(String bidderName, OffsetDateTime bidDate) {
        this.bidderName = bidderName;
        this.bidDate = bidDate;
    }

    public BidDTO() {
    }

    public String getBidderName() {
        return bidderName;
    }

    public void setBidderName(String bidderName) {
        this.bidderName = bidderName;
    }

    public OffsetDateTime getBidDate() {
        return bidDate;
    }

    public void setBidDate(OffsetDateTime bidDate) {
        this.bidDate = bidDate;
    }
}
