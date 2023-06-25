package org.example.Controller;
import jakarta.validation.Valid;
import org.example.DTO.*;
import org.example.Service.LotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/lot")
public class LotController {
    private final LotService lotService;

    public LotController(LotService lotService) {
        this.lotService = lotService;
    }
    @GetMapping("/{id}/first")
    public BidDTO getFirstBidder(@PathVariable int id){
        return lotService.getFirstBidder(id);
    }
    @GetMapping("/{id}/frequent")
    public BidDTO getFrequentBidder(@PathVariable int id){
        return lotService.getFrequentBidder(id);
    }
    @GetMapping("/{id}")
    public FullLot getFullLot(@PathVariable int id){
        return lotService.getFullLot(id);
    }
    @PostMapping("/{id}/start")
    public void startLot(@PathVariable int id){
        lotService.startLot(id);
    }
   @PostMapping("/{id}/bid")
    public void createBid(@PathVariable int id,@RequestBody @Valid Bidder bidder){
        lotService.createBid(bidder);
   }
    @PostMapping("/{id}/stop")
    public void stopLot(@PathVariable int id){
        lotService.stopLot(id);
    }
    @PostMapping
    public Status.LotDTO createLot(@RequestBody @Valid CreateLot createLot){
        return lotService.createLot(createLot);
    }
    @GetMapping
    public List<Status.LotDTO> findLots(@RequestParam String status , int page){
        return lotService.findLots(status,page);
    }
    @GetMapping("/export")
    public ResponseEntity<byte[]> getCSVFile(){
        return null;
    }
}
