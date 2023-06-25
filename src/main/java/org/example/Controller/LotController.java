package org.example.Controller;

import jakarta.validation.constraints.Null;
import org.example.Service.LotService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/lot")
public class LotController {
    private final LotService lotService;

    public LotController(LotService lotService) {
        this.lotService = lotService;
    }

    @GetMapping
    public List<Null> allLots(){
    return null;
}
@PostMapping
    public String createLot(){
    return "1";
}
@GetMapping("/{id}")
    public Null lotById(@PathVariable int id){
    return null;
}
@PostMapping("/{id}/start")
    public String startLot(@PathVariable int id){
    return null;
}
@PostMapping("/{id}/bid")
    public String bidLot(@PathVariable int id){
    return null;
}
@PostMapping("/{id}/stop")
    public String stopLot(@PathVariable int id){
    return null;
}
@GetMapping("/{id}/first")
    public Null nameFirstBidOnLot(@PathVariable int id){
    return null;
}
@GetMapping("/{id}/frequent")
    public Null frequentBidName(@PathVariable int id){
    return null;
}
}
