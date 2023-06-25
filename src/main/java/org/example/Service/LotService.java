package org.example.Service;

import org.example.DTO.*;
import org.example.Entity.Bid;
import org.example.Entity.Lot;
import org.example.Repository.BidRepository;
import org.example.Repository.LotRepository;
import org.example.exception.LotNotFoundException;
import org.example.mapper.LotMapper;

import java.io.StringWriter;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class LotService {
    private final LotRepository lotRepository;
    private final BidRepository bidRepository;
    private final LotMapper lotMapper;

    public LotService(LotRepository lotRepository,
                      BidRepository bidRepository,
                      LotMapper lotMapper) {
        this.lotRepository = lotRepository;
        this.bidRepository = bidRepository;
        this.lotMapper = lotMapper;
    }

    public BidDTO getFirstBidder(int lotId) {
        return bidRepository.findFirstByLot_IdOrderByDateTimeAsc(lotId)
                .map(lotMapper::bidDto)
                .orElseThrow(LotNotFoundException::new);
    }

    public BidDTO getFrequentBidder(int lotId) {
        return bidRepository.findTheMostFrequentBidder(lotId)
                .map(lotMapper::bidDto)
                .orElseThrow(LotNotFoundException::new);
    }

    public FullLot getFullLot(int lotId) {
        LotDTO a = lotRepository.findFirstByLot_Id(lotId)
                .map(lotMapper::lotDTO)
                .orElseThrow(LotNotFoundException::new);
        BidDTO b = bidRepository.findFirstByLot_IdOrderByDateTimeDesc(lotId)
                .map(lotMapper::bidDto)
                .orElseThrow(LotNotFoundException::new);
        List<Bid> c = bidRepository.findAllByLot_Id(lotId);
        FullLot fullLot = new FullLot();
        int currentPrice = c.size() * a.getBidPrice() + a.getStartPrice();
        fullLot.setId(a.getId());
        fullLot.setStatus(a.getStatus());
        fullLot.setTitle(a.getTitle());
        fullLot.setDescription(a.getDescription());
        fullLot.setStartPrice(a.getStartPrice());
        fullLot.setBidPrice(a.getBidPrice());
        fullLot.setCurrentPrice(currentPrice);
        return fullLot;
    }

    public void startLot(int lotId) {
        LotDTO a = lotRepository.findFirstByLot_Id(lotId)
                .map(lotMapper::lotDTO)
                .orElseThrow(LotNotFoundException::new);
        if (a.getStatus()== Status.CREATED){
            lotRepository.updateFirstByLot_Id(lotId);
        }
    }

    public void createBid(Bidder bidder) {
        Lot lot = lotRepository.findFirstByLot_Id(bidder.getLot_id())
                .map(lotMapper::lotDTO)
                .map(lotMapper::toLot)
                .orElseThrow(LotNotFoundException::new);;
        bidRepository.save(lotMapper.toBidEntity(bidder,lot));
    }

    public void stopLot(int lotId) {
        LotDTO lotDTO = lotRepository.findFirstByLot_Id(lotId)
                .map(lotMapper::lotDTO)
                .orElseThrow(LotNotFoundException::new);
        if (lotDTO.getStatus()==Status.STARTED){
            lotRepository.stopLotByLot_Id(lotId);
        }
    }

    public LotDTO createLot(CreateLot createLot) {
        Lot lot = lotMapper.createLotToLot(createLot);
        lotRepository.save(lot);
        return lotMapper.lotDTO(lot);

    }

    public List<LotDTO> findLots(String status, int page) {
        List<LotDTO> a = lotRepository.findLots(status)
                .stream().map(lotMapper::lotDTO)
                .collect(Collectors.toList());
        List<LotDTO> back = new ArrayList<>();
        if (page<0){
            return null;
        }
        else{
            page=page*10+9;
            if(a.size()<page){
                for (int i = page-9; i < a.size(); i++) {
                    back.add(a.get(i));
                }
            }
            else {
                for (int i = page - 9; i < page+1; i++) {
                    back.add(a.get(i));
                }
            }
            return back;
        }
    }

    public byte[] getCSVFile() {
        List<Lot> lots = lotRepository.findAll();
        for (int i = 0; i < lots.size(); i++) {
            BidDTO bidDTO = bidRepository.findFirstByLot_IdOrderByDateTimeDesc(lots.get(i).getId())
                    .map(lotMapper::bidDto)
                    .orElseThrow(LotNotFoundException::new);
            FullLot fullLot = getFullLot(lots.get(i).getId());
            StringWriter sw = new StringWriter();
            CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                    .setHeader("id","title","status","lastBidder","currentPrice")
                    .build();
            try (CSVPrinter csvPrinter = new CSVPrinter(sw, csvFormat)) {
                lots.forEach(lot -> csvPrinter.printRecord(lot.getId(),lot.getTitle(),lot.getStatus(),bidDTO.getBidderName(),fullLot.getCurrentPrice());
                {catch (IOException e) {
                    e.printStackTrace();
                }
                });
        }


        }
    }
}
