package com.example.irfan.evstation.irfan.services;

import com.example.irfan.evstation.irfan.entities.EvStation;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface EvstationService {
    public List<EvStation> getStations(int limit, String SortOrder, String SortByParam);

    public Optional<EvStation> getStation(long id);


    public EvStation updateStation(EvStation evStation, MultipartFile image, Long id) throws IOException;

    public void deleteStation(long id);

    EvStation addStation(EvStation evStation, MultipartFile image) throws IOException;
}
