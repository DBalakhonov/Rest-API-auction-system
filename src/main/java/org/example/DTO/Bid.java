package org.example.DTO;

import java.time.OffsetDateTime;

public class Bid {
    private String bidderName;
    private OffsetDateTime bidDate;

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
