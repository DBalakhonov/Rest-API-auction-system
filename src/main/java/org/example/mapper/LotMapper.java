package org.example.mapper;

import org.example.DTO.*;
import org.example.Entity.Bid;
import org.example.Entity.Lot;
import org.springframework.stereotype.Component;

@Component
public class LotMapper {
    public BidDTO bidDto(Bid bid){
        BidDTO bidDto = new BidDTO();
        bidDto.setBidDate(bid.getDateTime());
        bidDto.setBidderName(bid.getName());
        return bidDto;
    }
    public LotDTO lotDTO(Lot lot){
        LotDTO lotDTO = new LotDTO();
        lotDTO.setId(lot.getId());
        lotDTO.setStatus(lot.getStatus());
        lotDTO.setDescription(lot.getDescription());
        lotDTO.setTitle(lot.getTitle());
        lotDTO.setStartPrice(lot.getStartPrice());
        lotDTO.setBidPrice(lot.getBidPrice());
        return lotDTO;
    }
    public Lot toLot(LotDTO lotDTO){
        Lot lot = new Lot();
        lot.setId(lotDTO.getId());
        lot.setStatus(lotDTO.getStatus());
        lot.setDescription(lotDTO.getDescription());
        lot.setTitle(lotDTO.getTitle());
        lot.setStartPrice(lotDTO.getStartPrice());
        lot.setBidPrice(lotDTO.getBidPrice());
        return lot;
    }
    public Bid toBidEntity (Bidder bidder, Lot lot){
        Bid bid = new Bid();
        bid.setName(bidder.getName());
        bid.setDateTime(bidder.getOffsetDateTime());
        bid.setLot(lot);
        return bid;
    }
    public Lot createLotToLot(CreateLot createLot){
        Lot lot = new Lot();
        lot.setId(createLot.getId());
        lot.setStatus(Status.CREATED);
        lot.setDescription(createLot.getDescription());
        lot.setTitle(createLot.getTitle());
        lot.setStartPrice(createLot.getStartPrice());
        lot.setBidPrice(createLot.getBidPrice());
        return lot;
    }
}
