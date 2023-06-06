package com.example.irfan.evstation.irfan.controller;


import com.example.irfan.evstation.irfan.entities.EvStation;
import com.example.irfan.evstation.irfan.services.EvstationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class EvstationController {

    @Autowired
    private EvstationService evstationService;

    @GetMapping("/home")
    public String home(){
        return "This is home";
    }

    @GetMapping("/")
    public List<EvStation> getStations(
            @RequestParam (value = "limit",  defaultValue = "100", required = false) Integer limit,
            @RequestParam (value="sort", defaultValue = "asc",required = false) String sortOrder,
            @RequestParam(value = "param", defaultValue = "id", required = false) String sortByParam
    ){
        return this.evstationService.getStations(limit,sortOrder,sortByParam);
    }

    @GetMapping(path = "/{id}")
    public Optional<EvStation> getStation(@PathVariable long id){
        return this.evstationService.getStation(id);
    }

    @PostMapping(path = "/add",consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public EvStation addStation(@ModelAttribute EvStation evstation,
                                @RequestParam(value="file",required = true) MultipartFile image
    ) throws IOException {
        return this.evstationService.addStation(evstation,image);
    }

    @PutMapping(path = "/{id}/edit",consumes = { MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public EvStation updateStation(@ModelAttribute EvStation evstation,
                                   @RequestParam(value="file",required = false) MultipartFile image,
                                   @PathVariable long id) throws IOException {
        return this.evstationService.updateStation(evstation,image,id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable long id){
        try{
            this.evstationService.deleteStation(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
