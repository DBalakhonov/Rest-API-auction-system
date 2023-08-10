package org.example.Controller;
import jakarta.validation.Valid;
import org.example.DTO.*;
import org.example.Service.LotService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
    public LotDTO createLot(@RequestBody @Valid CreateLot createLot){
        return lotService.createLot(createLot);
    }
    @GetMapping
    public List<LotDTO> findLots(@RequestParam String status , int page){
        return lotService.findLots(status,page);
    }
    @GetMapping("/export")
    public ResponseEntity<byte[]> getCSVFile(){
        byte[] result = lotService.getCSVFile();
        return ResponseEntity
                .status(HttpStatus.OK)
                .header(HttpHeaders.CONTENT_TYPE,"text/csv")
                .body(result);
    }
}
